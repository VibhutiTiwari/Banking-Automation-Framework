package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import projectUtils.ConfigReader;

public class LoginPage {

    private WebDriver driver;
    private ConfigReader config = ConfigReader.getInstance();

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By userIdField = By.name("uid");
    private By passwordField = By.name("password");
    private By loginButton = By.name("btnLogin");

    public LoginPage enterCredentials(String username, String password){
        driver.findElement(userIdField).sendKeys(config.getManagerUserId());
        driver.findElement(passwordField).sendKeys(config.getManagerPassword());

        return this;
    }

    public HomePage clickLogin(){
        driver.findElement(loginButton).click();

        return new HomePage(driver);
    }



}
