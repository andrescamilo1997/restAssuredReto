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
import static org.hamcrest.CoreMatchers.notNullValue;

public class LoginUnsuccessPutStepDefinition extends servicesSetUp {
    private static final Logger LOGGER = Logger.getLogger(LoginUnsuccessPutStepDefinition.class);
    private Response response;
    private RequestSpecification request;

    //Login UnsuccessFull
    @Given("El usuario ingresa su {string} pero no su contracenia")
    public void elUsuarioIngresaSuPeroNoSuContracenia(String correo) {
        try{
            generalSetUp();

            UseJsonFormatToString useJsonFormatToString = new
                    UseJsonFormatToString(correo, UBI_ARCH_JSON_LOGIN_UNSUCCES);

            request = given()
                    .contentType(ContentType.JSON)
                    .log()
                    .all()
                    .body(useJsonFormatToString.bodyNotSucced());

        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
    @When("El usuario hace la peticion")
    public void elUsuarioHaceLaPeticion() {
        response = request.when()
                .post(BASE_LOGIN_RESOURCE);
    }
    @Then("El usuario recibe un codigo y un mensaje de falta passwor")
    public void elUsuarioRecibeUnCodigoYUnMensajeDeFaltaPasswor() {
        response.then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    //put
    @Given("el cliente pide editar alguno de sus datos {string} y {string}")
    public void elClientePideEditarAlgunoDeSusDatosY(String identificacion, String trabajo) {
        try{
            generalSetUp();
            request = given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "    \"name\": \""+identificacion+"\",\n" +
                            "    \"job\": \""+trabajo+"\"\n" +
                            "}");
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @When("hace la peticion")
    public void haceLaPeticion() {
        try{
            response = request.when()
                    .put(BASE_TO_GET);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @Then("recibe un codigo de respuesta exitoso y su identificacion, trabajo y fecha")
    public void recibeUnCodigoDeRespuestaExitosoYSuIdentificacionTrabajoYFecha() {
        try{
            response.then()
                    .statusCode(HttpStatus.SC_OK)
                    .log()
                    .all()
                    .body("name", notNullValue())
            /*.body("name", equalTo("identificacion"))*/;

        }catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
}
