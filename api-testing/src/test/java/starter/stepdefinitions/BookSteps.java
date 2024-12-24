package starter.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class BookSteps {

    private Response response;
    private final String BASE_URL = "http://localhost:7081/api/books";

    @Given("the API is running")
    public void theApiIsRunning() {
        RestAssured.baseURI = BASE_URL;
    }

    @When("I update a book with valid details")
    public void iUpdateABookWithValidDetails() {
        String requestBody = """
            {
                "id": 1,
                "title": "Updated Book Title",
                "author": "Updated Author Name"
            }
        """;

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .put("/1");
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("the response should contain the updated details")
    public void theResponseShouldContainTheUpdatedDetails() {
        String responseBody = response.getBody().asString();
        assert responseBody.contains("Updated Book Title");
        assert responseBody.contains("Updated Author Name");
    }

    @When("I update a book with missing title")
    public void iUpdateABookWithMissingTitle() {
        String requestBody = """
            {
                "id": 1,
                "author": "Updated Author Name"
            }
        """;

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .put("/1");
    }

    @When("I update a book with a non-existent id")
    public void iUpdateABookWithANonExistentId() {
        String requestBody = """
            {
                "id": 999,
                "title": "Non-existent Book",
                "author": "Author Name"
            }
        """;

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .put("/999");
    }
}
