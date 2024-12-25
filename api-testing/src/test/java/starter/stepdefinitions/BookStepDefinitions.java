package starter.stepdefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import java.io.IOException;

public class BookStepDefinitions {
    private static final String BASE_URL = "http://localhost:7081/api";
    private static final String USER = "admin";
    private static final String PASSWORD = "password";
    public Response response;
    private static Process process;
    @BeforeAll
    public static void before_all() throws IOException, InterruptedException {
        process = new ProcessBuilder("java", "-jar", "libs/demo-0.0.1-SNAPSHOT.jar")
                .inheritIO()
                .start();

        Thread.sleep(5000);

        RestAssured.baseURI = BASE_URL;
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(USER);
        authScheme.setPassword(PASSWORD);
        RestAssured.authentication = authScheme;
    }

    @AfterAll
    public static void after_all() {
        process.destroy();
    }

    @Given("I send a request to get all books")
    public void i_send_request_to_get_all_books() {
        response = SerenityRest.given()
                .when()
                .get("/books");
         
    }

    @Then("the API should return status {int}")
    public void the_api_should_return_status(int status){
        SerenityRest.restAssuredThat(response -> response.statusCode(status));
   
    }

}