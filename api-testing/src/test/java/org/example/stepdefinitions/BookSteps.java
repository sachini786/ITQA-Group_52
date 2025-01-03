//package org.example.stepdefinitions;
//
//import io.cucumber.java.AfterAll;
//import io.cucumber.java.BeforeAll;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.authentication.PreemptiveBasicAuthScheme;
//import io.restassured.response.Response;
//import net.serenitybdd.rest.SerenityRest;
//import java.io.IOException;
//
//public class BookSteps {
//
//    private static final String BASE_URL = "http://localhost:7081/api";
//    private static final String USER = "admin";
//    private static final String PASSWORD = "password";
//    public Response response;
//    private static Process process;
//    @BeforeAll
//    public static void before_all() throws IOException, InterruptedException {
//        process = new ProcessBuilder("java", "-jar", "libs/demo-0.0.1-SNAPSHOT.jar")
//                .inheritIO()
//                .start();
//
//        Thread.sleep(5000);
//
//        RestAssured.baseURI = BASE_URL;
//        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
//        authScheme.setUserName(USER);
//        authScheme.setPassword(PASSWORD);
//        RestAssured.authentication = authScheme;
//    }
//
//    @AfterAll
//    public static void after_all() {
//        process.destroy();
//    }
//
//    @Given("The details to be updated")
//    public void the_details_to_be_updated(){
//        response = SerenityRest.given()
//                .when()
//                .put("/books/1");
//
//    }
//    @When("I update a book with valid details")
//    public void i_update_a_book_with_valid_details(){
//        String requestBody = """
//                {
//                    "id": 1,
//                    "title": "Update Book title01"
//                    "author": "rowan atkinson"
//
//                }
//                """;
//
//        response = SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .body(requestBody)
//                .when()
//                .put("/books/1");
//
//    }
//    @Then("the response status should be {int}")
//    public void the_response_status_should_be(int status){
//        SerenityRest.restAssuredThat(response -> response.statusCode(status));
//
//    }
//
//
//
//}