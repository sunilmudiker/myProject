import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateConcepts {

    public static void navigateMethods() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.icc-cricket.com/");

        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        driver.get("https://www.udemy.com/");

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.navigate().to("https://www.icc-cricket.com/");
        Thread.sleep(2000);

        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        navigateMethods();
    }
}
