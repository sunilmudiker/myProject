import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramesConcepts
{
    public static void framesConcept(WebDriver driver, WebDriverWait wait)
    {
        driver.get("https://demoqa.com/");

        WebElement framesOption =driver.findElement(By.xpath("//h5[text() = 'Alerts, Frame & Windows']/parent::div/parent::div//div[@class='card-up']"));

        framesOption.click();

        WebElement frames= driver.findElement(By.xpath("//li[@id='item-2' and .='Frames']"));
        wait.until(ExpectedConditions.visibilityOf(frames));
        frames.click();

        driver.switchTo().frame(driver.findElement(By.id("frame1")));

        System.out.println(driver.findElement(By.id("sampleHeading")).getText());

        driver.switchTo().defaultContent();

        WebElement nestedFrames = driver.findElement(By.xpath("//li[@id='item-3' and .='Nested Frames']"));

        nestedFrames.click();

        driver.quit();
    }

    public static void switchToNewTab(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.get("https://demoqa.com/");

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        driver.quit();
    }

    public static void switchToNewWindow(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.get("https://demoqa.com/");

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        framesConcept(driver,wait);
//        switchToNewTab(driver, wait);
        switchToNewWindow(driver, wait);
    }
}
