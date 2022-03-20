package co.com.sofka.stepDefinitions.SetUp;

import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class servicesSetUp {
    private static final String BASE_URI = "https://reqres.in";
    private static final String BASE_PATH = "/api";
    protected static final String BASE_TO_GET = "/users/2";

    protected void generalSetUp(){
        log4j2();
        setUpBases();

    }

    protected void log4j2(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/"
                                    +LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    protected void setUpBases(){
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = BASE_PATH;
    }


}
