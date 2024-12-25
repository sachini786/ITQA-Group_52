package starter;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

public class TestAPI {
    private static final String BASE_URL = "http://localhost:7081/api";

    @BeforeAll
    public static void basicAuth(){
        RestAssured.baseURI = BASE_URL;
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("password");
        RestAssured.authentication = authScheme;
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
  

}


