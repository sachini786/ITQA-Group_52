package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class GetBookStepDefinitions {

    @When("I send a GET request to get all books")
    public void iSendAGETRequestTo() {
        SerenityRest.when()
                .get("/books");
    }
    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

}
