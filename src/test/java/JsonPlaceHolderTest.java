import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.*;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends TestConfig {

    @Test
    public void GET() {
        given().queryParam("postId", 1).log().uri().
                when().get(JSON_PLACEHOLDER_GET_POSTS).
                then().log().body().statusCode(200);
    }

    @Test
    public void PUT() {
        String putBodyJson = "{\n" +
                "\"title\": \"foo\",\n" +
                "\"body\": \"bar\",\n" +
                "\"userId\": 1\n" +
                "}";

        given().body(putBodyJson).log().uri().
                when().put(JSON_PLACEHOLDER_PUT_POST).
                then().log().body().statusCode(200);
    }

    @Test
    public void DELETE() {
        given().log().uri().
                when().delete(JSON_PLACEHOLDER_POST_DELETE).
                then().log().body().statusCode(200);
    }

    @Test
    public void postWithJson() {
        String postBodyJson = "{\n" +
                "\"title\": \"foo\",\n" +
                "\"body\": \"bar\",\n" +
                "\"userId\": 1\n" +
                "}";
        given().body(postBodyJson).log().all().
                when().post(JSON_PLACEHOLDER_POST_POST).
                then().spec(responseSpecificationForPostRequest).log().body();
    }

    @Test
    public void postWithXML() {
        String postXMLBody = "<?xml version=\"1.0\"?>\n" +
                "<Company>\n" +
                "  <Employee>\n" +
                "      <FirstName>Tanmay</FirstName>\n" +
                "      <LastName>Patil</LastName>\n" +
                "      <ContactNo>1234567890</ContactNo>\n" +
                "      <Email>tanmaypatil@xyz.com</Email>\n" +
                "      <Address>\n" +
                "           <City>Bangalore</City>\n" +
                "           <State>Karnataka</State>\n" +
                "           <Zip>560212</Zip>\n" +
                "      </Address>\n" +
                "  </Employee>\n" +
                "</Company>";
        given().spec(requestSpecificationXML).body(postXMLBody).log().all().
                when().post("").
                then().spec(responseSpecificationForGetRequest).log().body();
    }
}
