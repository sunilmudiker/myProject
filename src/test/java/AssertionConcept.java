import POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AssertionConcept {
    @Test
    public static void hardAssert()
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        Assert.assertEquals(driver.getTitle(), "LoginPage Practise | Rahul Shetty Academy");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApp("rahulshettyacademy", "learning");
    }

    @Test
    public static void softAssert()
    {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "LoginPage Practise | Rahul Shetty Academy");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApp("rahulshettyacademy", "learning");

        softAssert.assertAll();
    }
}
