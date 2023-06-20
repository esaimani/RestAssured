package Airline;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirlinePostAPI {

    String endPoint ="";
    String payload = "";

    @Test
    public void createNewAirline()
    {
        Response response = RestAssured.given().baseUri("https://api.instantwebtools.net/v1/airlines").contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": 987656789,\n" +
                        "    \"name\": \"Sri Lankan Airways\",\n" +
                        "    \"country\": \"Sri Lanka\",\n" +
                        "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                        "    \"slogan\": \"From Sri Lanka\",\n" +
                        "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                        "    \"website\": \"www.srilankaairways.com\",\n" +
                        "    \"established\": \"1990\"\n" +
                        "}").when().post().then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(),200);
    }
}
