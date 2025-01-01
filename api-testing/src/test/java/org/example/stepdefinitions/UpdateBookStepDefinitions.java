package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class UpdateBookStepDefinitions{
    public Response response;


    @When("I send a PUT request to update the test book")
    public void i_send_a_PUT_request_update_the_test_book(){

        response = SerenityRest.when()
                .put("/books/1");

    }
    // @Then(" the response status code should be as {int}")
    // public void the_response_status_should_be_as(int status){
    //     SerenityRest.restAssuredThat(response->response.statusCode(status));
    // }
    @Then("the response status code should be as {int}")
    public void the_response_status_code_should_be_as(Integer int1) {

        // Write code here that turns the phrase above into concrete actions
        SerenityRest.restAssuredThat(response->response.statusCode(int1));
        // throw new io.cucumber.java.PendingException();
    }

}
