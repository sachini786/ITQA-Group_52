//package org.example.stepdefinitions;
//
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.response.Response;
//import net.serenitybdd.rest.SerenityRest;
//
//
//public class BookDeletion {
//    public Response response;
//
//    @Given("The book is needed to be deleted")
//    public void the_book_is_needed_to_be_deleted(){
//        response = SerenityRest.given()
//                .when()
//                .delete("/books/1");
//    }
//    @When("I delete a book which is already deleted")
//    public void i_delete_a_book_which_is_already_deleted(){
//        String requestBody = """
//            {
//                "id": 1,
//                "title": "Update Book title01"
//                "author": "rowan atkinson"
//
//            }
//            """;
//
//        response = SerenityRest.given()
//                .header("Content-Type", "application/json")
//                .body(requestBody)
//                .when()
//                .delete("/books/1");
//    }
//    @Then("the response status should be the {int}")
//    public void the_response_status_should_be_the(int status){
//        SerenityRest.restAssuredThat(response->response.statusCode(status));
//    }
//}
//
//


