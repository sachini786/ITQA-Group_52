package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class DeleteBookStepDefinitions {
    private String bookId; // Book ID to delete
    private int statusCode; // Response status code
    //private int responseStatus;
    private static final String BASE_URL = "http://localhost:7081/api";

    @When("I send a DELETE request to delete a book with ID {int}")
    public void i_send_a_delete_request_to_delete_a_book_with_id(Integer id) {
        // Store the ID
        String bookId = id.toString();


        // Send the DELETE request and store the response status
        statusCode = given().baseUri(BASE_URL)
                .auth().basic("user", "password") // Use normal user credentials
                .when()
                .delete("/books/" + bookId) // Perform DELETE request
                .getStatusCode(); // Store the status code
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer expectedStatusCode) {
        if (statusCode != expectedStatusCode) {
            throw new AssertionError(
                    "Expected status code " + expectedStatusCode + " but got " + statusCode
            );
        }
        System.out.println("Delete request resulted in status code: " + statusCode);
    }

//    @Then("the book should still exist")
//    public void the_book_should_still_exist() {
//        // Send a GET request to check if the book still exists
//        given()
//                .auth().basic("user", "password") // Admin credentials to verify book existence
//                .when()
//                .get("/books/" + bookId)
//                .then()
//                .statusCode(200) // Expecting 200 because the book should still exist
//                .body("id", equalTo(Integer.parseInt(bookId))); // Validate book ID matches
//    }
}
