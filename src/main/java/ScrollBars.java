import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScrollBars {

    public static void handleScrollBars(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.get("https://demoqa.com/");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("window.scrollBy(500, 500)");

        Thread.sleep(2000);

        WebElement element  = driver.findElement(By.xpath("//a[@href='https://demoqa.com']"));
        Point point = element.getLocation();
        int x = point.getX();
        System.out.println(x);
        int y = point.getY();
        System.out.println(y);

//        javascriptExecutor.executeScript("window.scrollBy("+x+","+y+")");

        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        handleScrollBars(driver,wait);
    }
}
