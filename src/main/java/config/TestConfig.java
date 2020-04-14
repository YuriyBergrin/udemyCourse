package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Servers.*;

public class TestConfig {
    /**
     * request specifications
     * <p>
     * спецификация для XML
     */
    protected RequestSpecification requestSpecificationXML = new RequestSpecBuilder().
            addHeader("Content-Type", "application/xml").
            addCookie("testCookieXML").
            setBaseUri(REQUEST_BIN_URL).
            build();
    /**
     * спецификация для JSON
     */
    protected RequestSpecification requestSpecificationJSON = new RequestSpecBuilder().
            addHeader("Content-Type", "application/json").
            addCookie("testCookieJSON").
            build();

    protected RequestSpecification requestSpecificationForReqres = new RequestSpecBuilder().
            setBaseUri(REQRES_URL).
            build();

    /**
     * response specifications
     */
    protected ResponseSpecification responseSpecificationForGetRequest = new ResponseSpecBuilder().
            expectStatusCode(200).
            build();

    protected ResponseSpecification responseSpecificationForPostRequest = new ResponseSpecBuilder().
            expectStatusCode(201).
            build();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
    }
}
