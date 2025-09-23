import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class WindowHandleConcepts
{
    public static void windowHandle(WebDriver driver, WebDriverWait wait)
    {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        String parentWindowId = driver.getWindowHandle();

        WebElement interviewPage = driver.findElement(By.partialLinkText("Free Access to InterviewQues"));
        interviewPage.click();

        Set<String> childWindowIds = driver.getWindowHandles();
        Iterator<String> iterator = childWindowIds.iterator();

        while (iterator.hasNext())
        {
           driver.switchTo().window(iterator.next());

           if(Objects.equals(driver.getTitle(), "RS Academy"))
               break;
        }

        WebElement redPara = driver.findElement(By.cssSelector("p.red"));
        System.out.println(redPara.getText());

        driver.switchTo().window(parentWindowId);

        WebElement londonMeet = driver.findElement(By.partialLinkText("London QA Meetup"));
        londonMeet.click();

        childWindowIds = driver.getWindowHandles();
        iterator = childWindowIds.iterator();

        while (iterator.hasNext())
        {
            driver.switchTo().window(iterator.next());
            if(Objects.equals(driver.getTitle(), "Software Testing Meetup 2025"))
                break;
        }

        WebElement location = driver.findElement(By.cssSelector("p.event_location"));

        System.out.println(location.getText());

        driver.quit();

    }
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        windowHandle(driver, wait);
    }
}
