package org.example;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.example.definitions",
        plugin = {"pretty","html:target/cucumber-reports.html"}
)
//Run this file to execute tests
public class TestRunner{

}