package co.com.sofka.stepDefinitions.SetUp;

import io.restassured.RestAssured;
import org.apache.log4j.PropertyConfigurator;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class servicesSetUp {
    private static final String BASE_URI = "https://reqres.in";
    private static final String BASE_PATH = "/api";
    protected static final String BASE_TO_GET = "/users/2";
    protected static final String BASE_LOGIN_RESOURCE = "/login";
    protected static final String BASE_TO_REGISTER ="/register";
    protected static final String BASE_TO_GET_NOT_FOUND ="/users/23";
    protected static final String BASE_TO_GET_LIST = "/users?page=2";
    //Location files Json
    protected static final String ARCH_JSON_LOGIN
            ="src/test/resources/files/login.json";
    protected static final String ARCH_JSON_LOGIN_UNSUCCESSFUL
            ="src/test/resources/files/login_unsuccessful.json";
    protected static final String ARCH_JSON_REGISTER
            ="src/test/resources/files/register.json";
    protected static final String ARCH_JSON_REGISTER_UNSUCCESSFUL
            ="src/test/resources/files/register_unsuccessful.json";
    protected static final String ARCH_JSON_PUT
            ="src/test/resources/files/put.json";


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
