package org.example.stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class DeleteBookStepDefinitions {

    public Response response;

    @When("I send a DELETE request to delete a book with ID {int}")
    public void iSendRequestToDeleteBooks(int bookId) {
        response = SerenityRest.when()
                .delete("/books/" + bookId);
    }

    @Then("the response status should be {int}")
    public void responseStatusCodeShouldBe(int int1) {
        SerenityRest.restAssuredThat(response->response.statusCode(int1));
    }

}
