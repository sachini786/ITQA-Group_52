package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class UpdateBookStepDefinitions{
    public Response response;

    @When("I send a PUT request to update the test book")
    public void iSendRequestToUpdateBooks(){
        response = SerenityRest.when()
                .put("/books/1");
    }

    @Then("the response status code should be as {int}")
    public void responseStatusCodeShouldBe(Integer int1) {
        SerenityRest.restAssuredThat(response->response.statusCode(int1));
    }

    @When("I send a PUT request to update the test book with missing mandatory fields")
    public void iSendRequestToUpdateBooksWithMissingFields(){
        response = SerenityRest.when()
                .put("/books/1");
    }
    @Then("the response status code should be {int}")
    public void responseStatusCodeShouldBeExact(Integer expectedStatusCode) {
        SerenityRest.restAssuredThat(response -> response.statusCode(expectedStatusCode));
    }

    @When("I send a PUT request to update the test book as a normal user")
    public void iSendRequestToUpdateBooksAsNormalUser() {
        response = SerenityRest.when()
                .put("/books/1");
    }

    @Then("the response status code should be in {int}")
    public void responseStatusCodeShouldBeIn(Integer expectedStatusCode) {
        SerenityRest.restAssuredThat(response -> response.statusCode(expectedStatusCode));
    }

}
