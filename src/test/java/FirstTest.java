import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static constants.Constants.Actions.REQRES_GET_USERS;
import static constants.Constants.Path.REQRES_PATH;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


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

    @Test
    public void validateXMLSchema() {
        given().log().uri()
                .when().get("https://maps.googleapis.com/maps/api/place/findplacefromtext/xml?key=AIzaSyBKR2FPrHDyJJRr_Al4oCoc1j9R9ZK0FBc&input=New York&inputtype=textquery&language=ru&fields=formatted_address,geometry,icon,name,permanently_closed,photos,place_id,plus_code,types")
                .then().body(matchesXsdInClasspath("xmlSchema.xsd")).log().body();
    }

    @Test
    public void validateJSONSchema() {
        given().log().uri()
                .when().get("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?key=AIzaSyBKR2FPrHDyJJRr_Al4oCoc1j9R9ZK0FBc&input=New York&inputtype=textquery&language=ru&fields=formatted_address,geometry,icon,name,permanently_closed,photos,place_id,plus_code,types")
                .then().body(matchesJsonSchemaInClasspath("jsonSchema.json")).log().body();
    }

    @Test
    public void getMapOfElementsWithSomeKey() {
        Response response = given().spec(requestSpecificationForReqres).log().uri().
                when().get(REQRES_PATH + REQRES_GET_USERS);
        //System.out.println("response: " + response.asString());
        Map<String, ?> someObject =
                response.path("data.find{it.first_name=='George'}");
        System.out.println("someObject == " + someObject);
    }

    @Test
    public void getSingleElementWithSomeKey() {
        Response response = given().spec(requestSpecificationForReqres).log().uri().
                when().get(REQRES_PATH + REQRES_GET_USERS);
        String lastName = response.path("data.find{it.first_name=='George'}.last_name");
        System.out.println("George lastName is " + lastName);
    }

    @Test
    public void getAllElementsWithSomeKey() {
        Response response = given().spec(requestSpecificationForReqres).log().uri().
                when().get(REQRES_PATH + REQRES_GET_USERS);
        List emails = response.
                path("data.findAll{it.email}.email");
        System.out.println(response.asString()+"\n\n");
        System.out.println("emails are " + emails);
    }
}
