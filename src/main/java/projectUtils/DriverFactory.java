package projectUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
//import utils.ConfigReader;


public class DriverFactory {

    //DriverFactory - ThreadLocal Webdriver management which gives each thread it's own WebDriver
    // this is perfect for parallel testing as there will be no interferance

    // this line means each thread will store it's own webDriver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ConfigReader config = ConfigReader.getInstance();

    public static WebDriver getDriver(){
        return driver.get();
    }

    // initalize webdriver based on browser type
    public static WebDriver initializeDriver(String browserName){
        if(browserName == null){
            browserName = config.getBrowser();
        }

        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if(config.isHeadless()){
                    options.addArguments("--headless");
                }
                driver.set(new ChromeDriver(options));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getTimeout()));
        getDriver().manage().window().maximize();

        return getDriver();
    }

    public static void quitDriver(){
        if(driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }

}



