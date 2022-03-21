package co.com.sofka.stepDefinitions;

import co.com.sofka.stepDefinitions.SetUp.servicesSetUp;
import co.com.sofka.util.UseJsonFormatToString;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.notNullValue;

public class LoginSingleUserStepDefinition extends servicesSetUp {
    private static final Logger LOGGER = Logger.getLogger(LoginSingleUserStepDefinition.class);
    private Response response;
    private RequestSpecification request;

    //Login
    @Given(":  El usuario ingresa su {string} y {string}")
    public void elUsuarioIngresaSuY(String email, String password) {
        try{
            generalSetUp();

            UseJsonFormatToString useJsonFormatToString =
                    new UseJsonFormatToString(email, password, ARCH_JSON_LOGIN);

            request = given()
                    .contentType(ContentType.JSON)
                    .log()
                    .all()
                    .body(useJsonFormatToString.body());

        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @When(":  clickea para ingresar")
    public void clickeaParaIngresar() {
        try{
            response = request.when()
                    .post(BASE_LOGIN_RESOURCE);

        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }
    @Then(":  Le sale un codigo de respuesta y un token de acceso")
    public void leSaleUnCodigoDeRespuestaYUnTokenDeAcceso() {
        try{
            response.then()
                    .statusCode(HttpStatus.SC_OK)
                    .log()
                    .all()
                    .body("token", notNullValue());

        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    //Single User
    @Given(": un usuario busca cuales son sus datos registrados")
    public void unUsuarioBuscaCualesSonSusDatosRegistrados() {
        try{
            generalSetUp();
            request = given();
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @When(": hace clik para buscar sus datos")
    public void haceClikParaBuscarSusDatos() {
        try{
            response = when().get(BASE_TO_GET);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @Then(": Recibe un codigo de estatus y sus credenciales")
    public void recibeUnCodigoDeEstatusYSusCredenciales() {
        try{
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }

    }
}
