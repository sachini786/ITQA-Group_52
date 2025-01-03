package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.example.hooks.HookDefinitions;

public class DeleteBookStepDefinitions {

    public Response response;
    private RequestSpecification requestSpecification;
    private static final String BASE_URL = "http://localhost:7081/api/";
    private final int bookId = HookDefinitions.getCreatedBookID();

    @Given("user authenticate using by {string} and {string}")
    public void userUsernameAndPassword(String username,String password) {
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(username, password);
    }

    @When("I send a DELETE request to delete a book with")
    public void iSendRequestToDeleteBooks() {
        response = requestSpecification.when()
                .delete("/books/" + bookId);
    }

//    @When("I send a DELETE request to delete a book with {int}")
//    public void iSendRequestToDeleteBooks(int bookId) {
//        response = requestSpecification.when()
//                .delete("/books/" + bookId);
//    }

    @Then("the response status should be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {
        SerenityRest.restAssuredThat(response->response.statusCode(statusCode));
    }

    @When("I send a DELETE request to delete a book with {string}")
    public void iSendADELETERequestToDeleteABookWithID(String id) {
        response = requestSpecification.when()
                .delete("/books/" + id);
    }
}
