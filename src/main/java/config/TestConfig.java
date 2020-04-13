package config;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;

public class TestConfig {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;
    }
}
