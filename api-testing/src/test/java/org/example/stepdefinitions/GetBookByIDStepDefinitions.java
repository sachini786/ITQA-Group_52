package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.example.models.Book;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class GetBookByIDStepDefinitions {
    private Response response;
    private int createBookId;
    private RequestSpecification requestSpecification;
    private static final String BASE_URL = "http://localhost:7081/";

    @Given("user authenticate using by {string} and {string} wants to retrieve the book with valid ID")
    public void userUsernameAndPassword(String username, String password) {
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(username, password);
    }

    @Given("admin user wants to get book the ID is valid")
    public void adminUserWantsToGetBookWithValidID() {
        userUsernameAndPassword("admin", "password");
    }

    @Given("regular user wants to get book the ID is valid")
    public void regularUserWantsToGetBookWithValidID() {
        userUsernameAndPassword("user", "password");
    }

    @Given("admin user wants to get a non-existent book")
    public void adminUserWantsToGetNonExistentBook() {
        userUsernameAndPassword("admin", "password");
    }

    @Given("regular user wants to get a non-existent book")
    public void regularUserWantsToGetNonExistentBook() {
        userUsernameAndPassword("user", "password");
    }

    @Given("admin user wants to get a book with an invalid ID")
    public void adminUserWantsToGetBookWithInvalidID() {
        userUsernameAndPassword("admin", "password");
    }

    @Given("regular user wants to get a book with an invalid ID")
    public void regularUserWantsToGetBookWithInvalidID() {
        userUsernameAndPassword("user", "password");
    }

    @Given("the book exists")
    public void hasBooks() {
        userUsernameAndPassword("user","password");
        final String REQUEST_BODY= """
                    {
                        "title": "Harry Potter",
                        "author": "JK Rolling"
                    }
                """;

        createBookId= requestSpecification
                .body(REQUEST_BODY)
                .header("Content-Type", "application/json")
                .post("/api/books").getBody().as(Book.class, ObjectMapperType.JACKSON_2).id();
        System.out.println("Created Book ID: " + createBookId);
    }

    @After("@ValidIdFormat-Admin")
    public void afterBooksExistScenario1() {
        requestSpecification.when()
                .delete("/api/books/" + createBookId);
    }

    @After("@ValidIdFormat-RegularUser")
    public void afterBooksExistScenario2() {
        requestSpecification.when()
                .delete("/api/books/" + createBookId);
    }

    @When("user calls service to get the book with ID")
    public void userCallsServiceToGetBookWithID() {
        response = requestSpecification.when().get("/api/books/" + createBookId);
    }

    @When("user calls service to get the book with ID {int}")
    public void userCallsServiceToGetBookWithSpecificID(int bookId) {
        response = requestSpecification.when().get("/api/books/" + bookId);
    }

    @When("user calls service to get the book with ID {string}")
    public void userCallsServiceToGetBookWithInvalidID(String bookId) {
        response = requestSpecification.when().get("/api/books/" + bookId);
    }

    @Then("user expects response status to be {int}")
    public void responseStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("user expects response should contain the book details with ID")
    public void responseShouldContainBookDetails() {
        response.then()
                .body("id", equalTo(createBookId))
                .body("title", notNullValue())
                .body("author", notNullValue());
    }

    @Then("user expects response should contain a {string} message")
    public void responseShouldContainMessage(String expectedMessage) {
        response.then().body(equalTo(expectedMessage));
    }
}
