package test;

import POM.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginToRahulShetty {

    @Test(priority = 1, invocationCount = 2)
    public static void loginToApp()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApp("rahulshettyacademy", "learning");
    }

    @Test (priority = -1)
    public static void loginToApplication()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/");

        driver.quit();
    }

//    public static void main(String[] args)
//    {
//        loginToApp();
//    }
}
