package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;


public class BookUpdateExtraUnexpectedData {
    public Response response;

    @Given("The details to be updated extra")
    public void the_details_to_be_updated_extra(){
        response = SerenityRest.given()
                .when()
                .put("/books/1");
    }
    @When("I update a book with Extra details")
    public void i_update_a_book_with_extra_details(){
        String requestBody = """
            {
                "id": 1,
                "title": "Update Book title01"
                "author": "rowan atkinson"
                "registration": "ISBN0032"
    
            }
            """;

    response = SerenityRest.given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .when()
            .put("/books/1");
    }
    @Then("the response status should be the number {int}")
    public void the_response_status_should_be_the_number(Integer int1){
        SerenityRest.restAssuredThat(response->response.statusCode(int1));

   
    }
}


