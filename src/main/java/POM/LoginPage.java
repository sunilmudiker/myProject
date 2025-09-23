package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id="username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "signInBtn")
    private  WebElement signBtn;

    public void loginToApp(String userName, String password)
    {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.signBtn.click();
        try {
            Thread.sleep(3000);
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }

        this.driver.quit();
    }
}
