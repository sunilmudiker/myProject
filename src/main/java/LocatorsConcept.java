import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocatorsConcept {

    public static void locators() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.manage().window().maximize();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
        driver.findElement(By.name("password")).sendKeys("learning");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("signInBtn"))));
        driver.findElement(By.id("signInBtn")).click();

        Thread.sleep(2000);

        driver.quit();
    }

    public static void linkTextLocators() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.manage().window().maximize();

//        driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();

        driver.findElement(By.partialLinkText("Free Access to InterviewQues")).click();

        Thread.sleep(2000);

        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        locators();
//        linkTextLocators();
    }
}
