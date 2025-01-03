package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.example.hooks.HookDefinitions;
import org.example.models.Book;

public class UpdateAllBooksStepDefinitions{
    public Response response;
    int bookID;

    private RequestSpecification requestSpecification;
    private static final String BASE_URL = "http://localhost:7081/api";
//    private final int bookID = HookDefinitions.getCreatedBookID();

    @When("I send a PUT request to update the test book with ID {int}")
    public void iSendRequestToUpdateBooks(int bookID){
        String requestBody ="""
                {
                "id": %d,
                "title": "updated book title",
                "author": "Updated author"
                }
                """;
        response = requestSpecification.when()
                .header("Content-Type", "application/json")
                .body(requestBody.formatted(bookID))
                .put("/books/" + bookID);
    }
        @When("I send a PUT request to update the test book with ID")
        public void iSendRequestToUpdateBooks(){
            String requestBody ="""
                        {
                        "id": %d,
                        "title": "updated book title",
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

    @Given("User need to update a book as an admin")
    public void userNeedToUpdateABookAsAnAdmin() {

        requestSpecification =  SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("admin","password")
        ;
    }

    @Given("User need to update a book as an normal user")
    public void userNeedToUpdateABookAsAnNormalUser() {
        requestSpecification =  SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("user","password")
        ;
    }


}


