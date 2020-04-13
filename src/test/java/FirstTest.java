import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.REQRES_GET_USERS;
import static io.restassured.RestAssured.*;

public class FirstTest extends TestConfig {
    @Test
    public void myFirstTest() {
    given().
            when().get(REQRES_GET_USERS + "1").
            then().statusCode(200);
    }
}
