package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.mapper.ObjectMapperType;
import lombok.Getter;
import net.serenitybdd.rest.SerenityRest;
import org.example.models.Book;


public class HookDefinitions {
    int createdBookID;
    private static final String BASE_URL = "http://localhost:7081/api";

//    @Getter
//    private static int createdBookID;
    @Before(value="@CreateBook")
    public void beforeCreateBook(){

        String requestBody ="""
                {
                "title": "Book1",
                "author": "Author1"
                }
                """;
        createdBookID = SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("user","password")
                .header("Content-Type", "application/json")
                         .body(requestBody).post("/books").getBody().as(Book.class, ObjectMapperType.JACKSON_2).id();
        ;    }
    @After(value="@CreateBook")
    public void afterCreateBook(){
         SerenityRest.given()
                .baseUri(BASE_URL)
                .auth()
                .basic("user","password")
                 .header("Content-Type", "application/json")
                .delete(String.format("/books/%d",createdBookID));

    }
}
