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
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.*;

public class GetAllBooksStepDefinitions {
    private Response response;
    private int createBookId;
    private RequestSpecification requestSpecification;
    private static final String BASE_URL = "http://localhost:7081/";

    @Given("user authenticate using by {string} and {string} wants to get all books")
    public void authenticatedUserWantsToGetAllBooks(String username,String password) {
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic(username, password);
    }

    @Given("user want to get all books when there are no books available")
    public void userWantToGetAllBooksWhenThereAreNoBooksAvailable() {
        authenticatedUserWantsToGetAllBooks("user","password");
        userCallServiceToGetAllBooks();

        Book[] allBooksAvailable= response.getBody().as(Book[].class, ObjectMapperType.JACKSON_2);
        for (Book book : allBooksAvailable) {

            SerenityRest.given()
                    .baseUri(BASE_URL)
                    .auth()
                    .basic("user","password")
                    .delete(String.format("api/books/%d",book.id()));
        }

    }

    @When("user call service to get all books")
    public void userCallServiceToGetAllBooks() {
        response = requestSpecification.when().get("/api/books");
    }


    @Then("user expect response status to be {int}")
    public void userExpectResponseStatusToBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("user expect response should contain an empty list")
    public void userExpectResponseShouldContainAnEmptyList() {
        response.then().body("result",Matchers.hasSize(0));
    }

    @Given("user want to get all books when there are books available")
    public void userWantToGetAllBooksThereAreBooksAvailable() {
        authenticatedUserWantsToGetAllBooks("user","password");
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
    }

    @After(value="@BooksExist")
    public void afterBooksExistScenario() {
        requestSpecification.when()
                .delete(String.format("api/books/%d",createBookId));
    }

    @Then("user expect response should contain a list of books")
    public void userExpectResponseShouldContainAListOfBooks() {
        response.then().body("result.size()", greaterThan(0));
    }

    @Then("user expect response should have valid schema")
    public void userExpectResponseShouldHaveValidSchema() {
        response
        .then()
        .body("$", not(empty()))
        .body("$", everyItem(
                allOf(
                        hasKey("id"),
                        hasKey("title"),
                        hasKey("author")
                )
        ));
    }
}
