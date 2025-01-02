package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class UpdateBookStepDefinitions {
    public Response response;

    private RequestSpecification requestSpecification;
    private static final String BASE_URL = "http://localhost:7081/api";

    @When("I send a PUT request to update the test book with ID {int}")
    public void iSendRequestToUpdateBooks(int bookID){
        String requestBody ="""
                {
                "id": %d,
                "title": "updated title01",
                "author": "Updated author"
                }
                """;
        response = requestSpecification.when()
                .header("Content-Type", "application/json")
                .body(requestBody.formatted(bookID))
                .put("/books/" + bookID);
    }



    @When("I send a PUT request to update the test book with missing mandatory fields with ID {int}")
    public void iSendRequestToUpdateBooksWithMissingFields(int bookID){
        String requestBody ="""
                {
                "id": %d,
                "author": "Updated author"
                }
                """;
        response = requestSpecification.when()
                .header("Content-Type", "application/json")
                .body(requestBody.formatted(bookID))
                .put("/books/" + bookID);
    }
    @Then("the response status code should be {int}")
    public void responseStatusCodeShouldBeExact(Integer expectedStatusCode) {
        SerenityRest.restAssuredThat(response -> response.statusCode(expectedStatusCode));
    }

    @Given("I am an admin user")
    public void userNeedToUpdateABookAsAnAdmin() {

        requestSpecification =  SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("admin","password")
        ;
    }

    @Given("I am a normal user")
    public void userNeedToUpdateABookAsAnNormalUser() {
        requestSpecification =  SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("user","password")
        ;
    }
}


