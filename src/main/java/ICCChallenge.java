import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICCChallenge {

    public static void fetchTestTeamRankings() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.icc-cricket.com/");

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("a[alt='Rankings']")).click();

        Thread.sleep(3000);

    }
}
