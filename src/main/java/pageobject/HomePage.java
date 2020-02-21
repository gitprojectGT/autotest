package pageobject;


import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {


    public void setDriver (WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        setDriver (driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);

    }

    public WebDriver getDriver ( ) {
        return driver;
    }



}

