import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUpload {

    public static void fileUploadUsingFileType(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        driver.get("https://demoqa.com/");

        WebElement elements = driver.findElement(By.xpath("//h5[text() = 'Elements']/parent::div/parent::div//div[@class='card-up']"));

        elements.click();

        WebElement fileUpload= driver.findElement(By.xpath("//li[@id='item-7' and .='Upload and Download']"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",fileUpload);
        wait.until(ExpectedConditions.visibilityOf(fileUpload));
        fileUpload.click();

        WebElement fileUploadOption = driver.findElement(By.id("uploadFile"));
        fileUploadOption.sendKeys("C:\\Users\\smudi\\IdeaProjects\\MyProject\\src\\main\\testData\\original-1218843-2.jpg");

        Thread.sleep(3000);
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fileUploadUsingFileType(driver, wait);
    }
}
