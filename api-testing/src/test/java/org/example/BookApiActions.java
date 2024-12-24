package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import static net.serenitybdd.rest.SerenityRest.then;
import static net.serenitybdd.rest.SerenityRest.when;
import static net.serenitybdd.rest.SerenityRest.given;
// import static org.mockito.Mockito.when;

import net.serenitybdd.core.steps.UIInteractions;
import org.hamcrest.Matchers;

// import static net.serenitybdd.rest.SerenityRest.*;

public class BookApiActions extends UIInteractions{
    
    @Given("Book is available in the book store")
    public Long givenBookIsAvailableInBookStore(){
        Book book = new Book("Bookname", "available");

        Long newId = given()
                .baseUri("http://localhost:7081/api")
                .basePath("/api/books")
                .body(book, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post().getBody().as(Book.class, ObjectMapperType.GSON).getId();
        return newId;

    }
    @When("I ask for a book using book's ID: {0}")
    public void whenIAskForABookwithId(Long id){
        when().get("/" + id);
    }
    @Then("I get book as result")
    public void thenISeeBookAsResult(){
        then().body("name", Matchers.equalTo("book"));
        }
    
}
