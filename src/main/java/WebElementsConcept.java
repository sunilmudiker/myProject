import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class WebElementsConcept {

    public static void webElementMethods() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("signInBtn"));
        WebElement checkBox = driver.findElement(By.cssSelector("input[type='submit']"));

        wait.until(ExpectedConditions.visibilityOf(userName));
        System.out.println(userName.getAttribute("type"));
        System.out.println("username displayed : "+userName.isDisplayed());
        userName.sendKeys("rahulshettyacademy");

        wait.until(ExpectedConditions.visibilityOf(password));
        System.out.println(password.getTagName());
        password.sendKeys("learning");

        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        System.out.println("check box css value : "+checkBox.getCssValue("name"));
        checkBox.click();
        System.out.println("checkbox selected : "+ checkBox.isSelected());

        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        System.out.println(checkBox.getLocation());
        System.out.println("login button enabled : "+ loginButton.isEnabled());
        loginButton.submit();

        Thread.sleep(3000);

        driver.get("https://the-internet.herokuapp.com/");

        WebElement dragNDrop = driver.findElement(By.linkText("Drag and Drop"));

        wait.until(ExpectedConditions.elementToBeClickable(dragNDrop));
        System.out.println(dragNDrop.getText());
        dragNDrop.click();

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        System.out.println(columnA.getSize());
        System.out.println(columnB.getRect().getHeight());

        driver.quit();
    }

    public static void takesScreenshot() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\smudi\\IdeaProjects\\MyProject\\target\\screenshots"+ "screenshot.png");

        FileUtils.copyFile(source, destination);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
//        webElementMethods();
        takesScreenshot();
    }
}
