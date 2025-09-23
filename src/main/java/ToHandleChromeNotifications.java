import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToHandleChromeNotifications {

    public static void toHandleChromeNotifications(WebDriver driver , WebDriverWait wait) throws InterruptedException {
        driver.get("https://www.goibibo.com/");

        Thread.sleep(2000);
        driver.quit();
    }
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        toHandleChromeNotifications(driver, wait);
    }
}
