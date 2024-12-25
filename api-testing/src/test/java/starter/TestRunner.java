package starter;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
 
        features = "src/test/resources/features",
        glue = "starter.stepdefinitions",
        plugin = {"pretty"}
)
//Run this file to execute tests
public class TestRunner{

}