import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetRequestTest {

    /**
     * Validates that a GET request to the BookStore API is successful.
     *
     * This test sends a GET request to the endpoint /BookStore/v1/Books
     * on the demoqa.com server. It verifies that the response has a
     * status code of 200 and prints the response body to the console.
     */
    @Test
    public void validateGetRequest() {
        RestAssured.baseURI = "https://demoqa.com";

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Response Body: " + response.asPrettyString());
    }
}
