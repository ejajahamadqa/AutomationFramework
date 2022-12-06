package utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RestAssuredBaseClass {

    Properties prop;

    @BeforeClass
    public void initializeRest() throws IOException {
        prop = new Properties();
        prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "//src//test//java//resources//restassured.properties")));
        RestAssured.baseURI = prop.getProperty("server") + prop.getProperty("resources") + "/";
    }
}
