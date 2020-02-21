package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoTestPage extends HomePage {


    @FindBy(xpath="//input")
    private WebElement inputName;

    @FindBy(xpath="//button[contains(text(),'Start!')]")
    private  WebElement submitLogin;

    @FindBy(id="click")
    private WebElement clickCookie;

    @FindBy(id="cookies")
    private WebElement cookiesAdded;


    public void enterName(String name){
        inputName.sendKeys (name);
    }

    public void clickOnButtonStart() { submitLogin.click (); }

    public String getTextFromTitle() {  return getDriver ().getTitle (); }

    public void clickOnCookieButton(){
        clickCookie.click ();
    }

    public String getCookieAdded(){
        return getDriver ().findElement (By.id ("cookies")).getText ();
    }

    public AutoTestPage (WebDriver driver) {
        super(driver);
    }

}
