package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;


public class InvalidAccessForUpdate {
    
    public Response response;

    @Given("I need to update data of Books by accessing to the needed endpoint")
    public void i_need_to_update_data_of_Books_by_accessing_to_the_needed_endpoint(){
        response = SerenityRest.given()
                .when()
                .put("/books/1");
    }
    @When("I accessed to the Invalid endpoint")
    public void i_accessed_to_the_Invalid_endpoint(){
        String requestBody = """
            {
                "id": 1,
                "title": "Update Book title01"
                "author": "rowan atkinson"
    
            }
            """;

    response = SerenityRest.given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .put("/books/1");
    }
    @Then("the response status code will be {int}")
    public void the_response_status_should_be_the_number(Integer status){
        SerenityRest.restAssuredThat(response->response.statusCode(status));

   
    }
}
