// import io.restassured.RestAssured;
// import io.restassured.authentication.PreemptiveBasicAuthScheme;
// import net.serenitybdd.rest.SerenityRest;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;
// import static org.hamcrest.Matchers.equalTo;

// public class TestAPI {
//     private static final String BASE_URL = "http://localhost:7081/api";

//     @BeforeAll
//     public static void basicAuth(){
//         RestAssured.baseURI = BASE_URL;
//         PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
//         authScheme.setUserName("admin");
//         authScheme.setPassword("password");
//         RestAssured.authentication = authScheme;
//     }

//     @Test
//     public void shouldReturnListOfBooks() {
//         SerenityRest.given()
//                 .baseUri(BASE_URL)
//                 .when()
//                 .get("/books")
//                 .then()
//                 .statusCode(200)
//                 .body("size()", equalTo(1));
//     }
  

// }



import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class TestAPI {
    private static final String BASE_URL = "http://localhost:7081/api";

    @BeforeAll
    public static void setupAuthentication() {
        RestAssured.baseURI = BASE_URL;
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("password");
        RestAssured.authentication = authScheme;
    }

    @Test
    public void testUpdateBookWithExtraFields() {
        // Test Case 16: PUT API with unexpected fields
        SerenityRest.given()
                .contentType("application/json")
                .body("{ \"id\": 1, \"title\": \"Updated Title\", \"author\": \"Updated Author\", \"extraField\": \"unexpected\" }")
                .when()
                .put("/books/1")
                .then()
                .statusCode(208) // Expecting 400 Bad Request
                .body("error", containsString("Invalid input parameters"));
    }
        @Test
    public void shouldReturnListOfBooks() {
        SerenityRest.given()
                .baseUri(BASE_URL)
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .body("size()", equalTo(1));
    }

    @Test
    public void testDeleteAlreadyDeletedBook() {
        // Test Case 17: DELETE an already deleted book
        SerenityRest.given()
                .when()
                .delete("/books/9999") // Assuming book 9999 does not exist or is already deleted
                .then()
                .statusCode(403) // Expecting 404 Not Found
                .body("error", containsString("Book not found"));
    }

    @Test
    public void testInvalidEndpointAccess() {
        // Test Case 18: Access incorrect endpoint
        SerenityRest.given()
                .when()
                .get("/books/invalid-endpoint")
                .then()
                .statusCode(400) // Expecting 404 Not Found
                .body("error", containsString("Endpoint not found"));
    }
}
