package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import static org.junit.Assert.assertEquals;

public class CreateBookStepDefinitions {
    private static final String BASE_URL = "http://localhost:7081/api";
    private static final String USER = "admin";
    private static final String PASSWORD = "password";
    public Response response;
    private String requestBody;

    private RequestSpecification requestSpecification;

    @Given("user as {string}")
    public void userAs(String role) {
        requestSpecification = SerenityRest.given().baseUri(BASE_URL);

        if ("admin".equalsIgnoreCase(role)) {
            requestSpecification.auth().basic("admin", "password");
        } else if ("user".equalsIgnoreCase(role)) {
            requestSpecification.auth().basic("user", "password");
        }
    }
    @When("send request to create book with {int},{string},{string}")
    public void sendRequestToCreateBookWithId(int id ,String title,String author) {
        final String REQUEST_BODY=
                """
             {
                 "id":%d,
                 "title":"%s",
                 "author":"%s"
             }
             """;
        response= requestSpecification.when().header("Content-Type", "application/json").body(REQUEST_BODY.formatted(id,title,author)).post("/books");

    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int expectedStatus) {
        int actualStatusCode = response.getStatusCode();
        assert actualStatusCode == expectedStatus : System.out.printf("Expected status code %d but got %d", expectedStatus, actualStatusCode);

    }
    @Given("request payload with" )
    public void requestPayloadWith(String requestBody) {
        requestSpecification = SerenityRest.given().baseUri(BASE_URL).auth().basic("user","password").body(requestBody);


    }

    @When("method POST with endpoint {string}")
    public void methodPOSTWithEndpoint(String endpoint) {
        response= requestSpecification.when().header("Content-Type", "application/json").post(endpoint);
    }

    @Then("status {int}")
    public void statusStatus(int expectedStatus) {
        int actualStatusCode = response.getStatusCode();
        assert actualStatusCode == expectedStatus :
                String.format("Expected status code %d but got %d", expectedStatus, actualStatusCode);

    }


    @And("the response message should contain {string}")
    public void theResponseMessageShouldContain(String expectedMessage) {
        String responseMessage = response.getBody().asString();
        System.out.printf(responseMessage);
    }




}
