import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DropDowns {

    public static void singleAndMultipleDropdown() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Dropdown"))));
        driver.findElement(By.linkText("Dropdown")).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("dropdown"))));

        Select select = new Select(driver.findElement(By.id("dropdown")));

        System.out.println(select.isMultiple());

        select.selectByValue("1");

        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Dropdown"))));
        driver.findElement(By.linkText("Dropdown")).click();

        select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByIndex(2);

        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Dropdown"))));
        driver.findElement(By.linkText("Dropdown")).click();

        select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\smudi\\IdeaProjects\\MyProject\\target\\screenshots"+"screenshot.png");

        FileUtils.copyFile(src,dest);
        driver.quit();

    }

    public static void main(String[] args) throws IOException {
        singleAndMultipleDropdown();
    }
}
