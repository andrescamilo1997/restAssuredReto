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


public class RegisterSuccessFullGetUserNotFoundStepDefinition extends servicesSetUp {

    private static final Logger LOGGER = Logger.getLogger(RegisterSuccessFullGetUserNotFoundStepDefinition.class);
    private Response response;
    private RequestSpecification request;

    //Register
    @Given("se le piden al usuario unas credenciales de correo {string} y contrasenia {string} para registrarlo")
    public void seLePidenAlUsuarioUnasCredencialesDeCorreoYContraseniaParaRegistrarlo(String email, String password) {
        try{
            generalSetUp();
            UseJsonFormatToString useJsonFormatToString
                    = new UseJsonFormatToString(email,password, ARCH_JSON_REGISTER);

            request = given()
                    .contentType(ContentType.JSON)
                    .log()
                    .all()
                    .body(useJsonFormatToString.body());
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @When("Hace la peticion de registro")
    public void haceLaPeticionDeRegistro() {
        try{
            response = request.when()
                    .post(BASE_TO_REGISTER);

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @Then("le sale un mensaje de ok, y se le asigna un id, junto con un accesToken")
    public void leSaleUnMensajeDeOkYSeLeAsignaUnIdJuntoConUnAccesToken() {
        try{

            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_OK);

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }


    //Get User Not Found
    @Given("El usuario se registro quiere ver su informacion pero no busco de la forma correcta")
    public void elUsuarioSeRegistroQuiereVerSuInformacionPeroNoBuscoDeLaFormaCorrecta() {
        try{

            generalSetUp();
            request = given()
                    .log()
                    .all();

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @When("El usuario hace la peticion para el registro")
    public void elUsuarioHaceLaPeticionParaElRegistro() {
        try{
            response = request
                    .get(BASE_TO_GET_NOT_FOUND);

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @Then("Le sale al usuario un codigo que no encuentra resultados")
    public void leSaleAlUsuarioUnCodigoQueNoEncuentraResultados() {
        try{
            response.then()
                    .log()
                    .all()
                    .statusCode(HttpStatus.SC_NOT_FOUND);

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
}
