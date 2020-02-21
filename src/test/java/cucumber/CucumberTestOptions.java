package cucumber;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.BaseTests;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty", "html:target/cucumber","json:target/cucumber/cucumber.json"},
        glue={"cucumber/stepdefs"},
        features={"src/test/java/cucumber/features"}
      )

    public class CucumberTestOptions   {


}
