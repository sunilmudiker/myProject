import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptConcept {

    public static void jsMethods (WebDriver driver, WebDriverWait wait) throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("window.location = arguments[0]", "https://rahulshettyacademy.com/loginpagePractise/");

        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement signInBtn = driver.findElement(By.id("signInBtn"));

        wait.until(ExpectedConditions.visibilityOf(userName));
        System.out.println(javascriptExecutor.executeScript("return document.title"));
        System.out.println(javascriptExecutor.executeScript("return window.location.href"));
        javascriptExecutor.executeScript("arguments[0].value = arguments[1]", userName, "rahulshettyacademy");
        javascriptExecutor.executeScript("arguments[0].value = arguments[1]", password, "learning");
        javascriptExecutor.executeScript("arguments[0].click()", signInBtn);

        Thread.sleep(3000);
        javascriptExecutor.executeScript("history.go(0)");

        Thread.sleep(3000);
        driver.quit();
    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        jsMethods(driver,wait);
    }
}
