package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {
    private WebDriver driver;

    public NewCustomerPage(WebDriver driver){
        this.driver = driver;
    }

    By customerNameField = By.name("name");



}
