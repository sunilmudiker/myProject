import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MouseActions {

    public static void mouseActions() throws InterruptedException {
        String username = "username";
        String password = "password";
        String loginButton = "signInBtn";
        String checkbox = "terms";
        String dragAndDrop = "Drag and Drop";
        String columnA = "column-a";
        String columnB = "column-b";


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actions = new Actions(driver);

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(username))));
        driver.findElement(By.id(username)).sendKeys("rahulshettyacademy");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(password))));
        driver.findElement(By.id(password)).sendKeys("learning");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(checkbox))));
        actions.moveToElement(driver.findElement(By.id(checkbox))).perform();
        actions.click().perform();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(loginButton))));
        driver.findElement(By.id(loginButton)).click();

        Thread.sleep(3000);

        driver.get("https://the-internet.herokuapp.com/");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(dragAndDrop))));
        driver.findElement(By.linkText(dragAndDrop)).click();

        actions.dragAndDrop(driver.findElement(By.id(columnA)), driver.findElement(By.id(columnB))).perform();

        actions.contextClick(driver.findElement(By.id(columnA))).perform();

        Thread.sleep(3000);

        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        mouseActions();
    }

}
