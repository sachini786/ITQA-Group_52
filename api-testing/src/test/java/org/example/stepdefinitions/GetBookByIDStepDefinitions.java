package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetBookByIDStepDefinitions {
    private Response response;

    @When("I send a GET request to retrieve the book with ID {int}")
    public void iSendAGetRequestToRetrieveTheBookWithID(int bookId) {
        response = SerenityRest.when()
                .get("/books/" + bookId);
    }

    @Then("The API response status code should be {int}")
    public void responseStatusCodeForBookByIDShouldBe(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @And("The response should contain the book details with ID {int}")
    public void theResponseShouldContainTheBookDetails(int bookId) {
        response.then().body("id", equalTo(bookId));
        response.then().body("title", notNullValue());
        response.then().body("author", notNullValue());

        //String title = response.jsonPath().getString("title");
        //String author = response.jsonPath().getString("author");
        //System.out.println("Retrieved Book Details - ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
}
