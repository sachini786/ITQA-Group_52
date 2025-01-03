package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.example.hooks.HookDefinitions;

public class EdgeCasesStepDefinitions {

    private Response response;

    private int createBookId = HookDefinitions.getCreatedBookIDForUpdate();
    private RequestSpecification requestSpecification;
    private static final String BASE_URL = "http://localhost:7081/";

    @Given("user needs to get all the authors")
    public void userNeedsToGetAllTheAuthors() {
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("user", "password");

    }

    @When("user send request to get all authors")
    public void userSendRequestToGetAllAuthors() {
        response = requestSpecification.when().get("/api/authors");
    }

    @Then("the edge case response status should be {int}")
    public void theEdgeCaseResponseStatusShouldBeThe(int status){
        SerenityRest.restAssuredThat(response->response.statusCode(status));
    }

    @Given("user need to create a book with extra field")
    public void userNeedToCreateABookWithExtraField() {
        String requestBody = """
            {
                "id": 999,
                "title": "Update Book title01"
                "author": "rowan atkinson"
                "registration": "ISBN0032"
    
            }
            """;
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("user", "password").body(requestBody);
    }
    @When("user send request to create book")
    public void userSendRequestToCreateBook() {
        response = requestSpecification.given()
                .header("Content-Type", "application/json")
                .when()
                .post("/books");
    }


    @Given("user need to update a book with extra field")
    public void userNeedToUpdateABookWithExtraField() {
        String requestBody = """
            {
                "id": %d,
                "title": "Update Book title01"
                "author": "rowan atkinson"
                "registration": "ISBN0032"
    
            }
            """;
        requestSpecification = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("user", "password").body(requestBody.formatted(createBookId));

    }

    @When("user send request to update book")
    public void userSendRequestToUpdateBook() {
        response = requestSpecification.given()
                .header("Content-Type", "application/json")
                .when()
                .put("/books/"+createBookId);
    }
}
