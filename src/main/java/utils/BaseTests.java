package utils;

import io.cucumber.java.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.HomePage;
import pageobject.MainPage;

import java.util.logging.Logger;


public class BaseTests {

    private final static Logger log = Logger.getLogger(BaseTests.class.getName());


    private static WebDriver webDriver;
    protected static HomePage homePage;

    @BeforeClass
    public static void launchApplication(String urlToRunApplication) {

        if ( urlToRunApplication != null ) {
            switch (urlToRunApplication) {
                case "Cookie":
                    webDriver = setDriverProperty("chrome");
                    webDriver.get(PropertyLoader.loadProperty("application.main.url"));
                    homePage = new HomePage(webDriver);
                    break;
                case "google":
                    webDriver = setDriverProperty ("chrome");
                    webDriver.get(PropertyLoader.loadProperty ("application.google.url"));
                    homePage = new MainPage (webDriver);
                    break;
            }
        }
    }

    @AfterClass
    public static void closeBrowser() {
        webDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    protected static WebDriver setDriverProperty(String driverToSet) {
        WebDriver webDriverToset = null;
        if ( driverToSet != null ) {
            switch (driverToSet) {
                case "chrome":
                    setChromeDriverProperty();
                    webDriverToset = new ChromeDriver();
                    break;
                case "firefox":
                    setFirefoxDriverProperty();
                    webDriverToset = new FirefoxDriver();
                    break;
            }
        }
        return webDriverToset;
    }

    private static void setChromeDriverProperty() {

        if ( System.getProperty("os.name").contains("Windows") ) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        } else {
            if ( System.getProperty("os.name").contains("Linux") ) {
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            }
        }
    }

    private static void setFirefoxDriverProperty() {

        if ( System.getProperty("os.name").contains("Windows") ) {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        }

    }


    public static void setWebDriver(WebDriver webDriver) {
        BaseTests.webDriver = webDriver;
    }


}
