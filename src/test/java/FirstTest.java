import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static constants.Constants.Actions.REQRES_GET_USERS;
import static constants.Constants.Path.REQRES_PATH;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest extends TestConfig {
    @Test
    public void myFirstTest() {
        given().log().uri().
                when().get(REQRES_GET_USERS + "1").
                then().log().body().statusCode(200);
    }

    @Test
    public void getSomeFieldInResponseAssertion() {
        given().spec(requestSpecificationForReqres).log().uri().
                when().get(REQRES_PATH + REQRES_GET_USERS).
                then().body("page", equalTo(1)).log().body();
    }

    @Test
    public void getSomeFieldInResponseWithIndexAssertion() {
        given().spec(requestSpecificationForReqres).log().uri().
                when().get(REQRES_PATH + REQRES_GET_USERS).
                then().body("total", equalTo(12)).
                body("data.first_name[0]", equalTo("George")).
                log().body();

    }

    @Test
    public void getAllDataFromResponse() {
        Response response = given().spec(requestSpecificationForReqres).log().uri().
                when().get(REQRES_PATH + REQRES_GET_USERS).
                then().extract().response();

        String jsonResponseAsString = response.asString();
        System.out.println(jsonResponseAsString);
    }

    @Test
    public void getCookiesFromResponse() {
        Response response = given().spec(requestSpecificationForReqres).log().uri().
                when().get(REQRES_PATH + REQRES_GET_USERS).
                then().extract().response();
        Map<String, String> allCookies = response.getCookies();
        System.out.println("All cookies --> " + allCookies);

        String someCookie = response.getCookie("__cfduid");
        System.out.println("someCookie --> " + someCookie);
    }

    @Test
    public void getHeadersFromResponse() {
        Response response = given().spec(requestSpecificationForReqres).log().uri().
                when().get(REQRES_PATH + REQRES_GET_USERS).
                then().extract().response();

        Headers headers = response.getHeaders();
        System.out.println("Headers -->\n " + headers);

        String contentType = response.getContentType();
        System.out.println("contentType-->\n" + contentType);
    }
}
