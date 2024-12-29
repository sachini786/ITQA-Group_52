package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class GetBookStepDefinitions {

    @When("I send a request to get all books")
    public void iSendRequestToGetAllBooks() {
        SerenityRest.when()
                .get("/books");
    }
    @Then("API response status code should be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

}
