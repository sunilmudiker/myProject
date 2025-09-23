import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsConcepts {

    public static void alertsConcepts(WebDriver driver, WebDriverWait wait)
    {
        driver.get("https://demoqa.com/");

        WebElement alertOption =driver.findElement(By.xpath("//h5[text() = 'Alerts, Frame & Windows']/parent::div/parent::div//div[@class='card-up']"));

        alertOption.click();

        WebElement alerts= driver.findElement(By.xpath("//li[@id='item-1' and .='Alerts']"));
        wait.until(ExpectedConditions.visibilityOf(alerts));
        alerts.click();

        WebElement singleAlert = driver.findElement(By.id("alertButton"));
        wait.until(ExpectedConditions.visibilityOf(singleAlert));
        singleAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement timerAlert = driver.findElement(By.id("timerAlertButton"));
        timerAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();


        WebElement confirmAlert = driver.findElement(By.id("confirmButton"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", confirmAlert);
        confirmAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        alert.accept();

        confirmAlert.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();

        WebElement promptElement = driver.findElement(By.id("promtButton"));
        promptElement.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("hi how are you?");
        alert.accept();

        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertsConcepts(driver, wait);
    }
}
