package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By welcomeMessage = By.xpath("//marquee");
    private By newCustomerLink = By.xpath("//a[text()='New Customer']");
    private By logoutLink = By.xpath("//a[text()='Log out']");


    public boolean isWelcomeMsgDisplayed(){
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    public boolean isHomePage(){
        return driver.getTitle().contains("Managerhomepage");
    }

    public NewCustomerPage clickNewCustomer(){
        driver.findElement(newCustomerLink).click();
        return new NewCustomerPage(driver);
    }
}
