package cucumber.stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageobject.AutoTestPage;
import utils.BaseTests;
import utils.Utils;

import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;


public class AutoTestStepDefs {

    BaseTests stepData;
    AutoTestPage automationPractise;
    final Supplier<String> titlePage = ( ) -> "Cookie Clicker!";


    public AutoTestStepDefs (BaseTests stepData) {
        this.stepData = stepData;

    }

    @Given("^Navigate to home page \"([^\"]*)\"$")
    public void navigateToHomePage (String url) {
        stepData.launchApplication(url);
    }


    @When("^The name \"([^\"]*)\" is given$")
    public void theNameIsGiven (String namePlayer) {
        automationPractise = new AutoTestPage (stepData.getWebDriver());
        assertThat(namePlayer,notNullValue ());
        assertThat(namePlayer,is(not(equalTo (""))));
        assertThat(namePlayer, not(Utils.checkSpecialChars (namePlayer)));
        automationPractise.enterName(namePlayer);
        automationPractise.clickOnButtonStart ();
    }

    @Then("^New game will start$")
    public void newGameWillStart() {
        automationPractise = new AutoTestPage (stepData.getWebDriver ());
        assertThat (titlePage.get () , equalTo (automationPractise.getTextFromTitle ()));

    }
    @Then ("^I add new cookies$")
    public void iAddNewCookie(){
        automationPractise = new AutoTestPage (stepData.getWebDriver ());
        automationPractise.clickOnCookieButton();
        assertNotNull (automationPractise.getCookieAdded ());
    }
    @After
    public void cleanUp() {
        BaseTests.getWebDriver ().quit ();
    }

}
