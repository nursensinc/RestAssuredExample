import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequestTest {

    /**
     * Verifies that a POST request to create a new booking is successful.
     *
     * This test sends a POST request to
     * https://restful-booker.herokuapp.com/booking with a JSON body that
     * includes the booking details. The response is then verified to have a
     * 200 status code. The response body is also printed to the console.
     */
    @Test
    public void postRequest() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", "Jim");
        requestBody.put("lastname", "Brown");
        requestBody.put("totalprice", 111);
        requestBody.put("depositpaid", true);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        requestBody.put("bookingdates", bookingDates);
        requestBody.put("additionalneeds", "Breakfast");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Response Body: " + response.asPrettyString());
    }
}
