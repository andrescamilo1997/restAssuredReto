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


public class RegisterNullGetListStepDefinition  extends servicesSetUp {
    public static final Logger LOGGER = Logger.getLogger(RegisterNullGetListStepDefinition.class);
    public static Response response;
    public static RequestSpecification request;

    //Do not register
    @Given("como administrador se ponen las credenciales del usuario, como el email {string} pero no password")
    public void comoAdministradorSePonenLasCredencialesDelUsuarioComoElEmailPeroNoPassword(String email) {
        try{
            generalSetUp();

            UseJsonFormatToString useJsonFormatToString  =
                    new UseJsonFormatToString(email, ARCH_JSON_REGISTER_UNSUCCESSFUL);

            request = given()
                    .contentType(ContentType.JSON)
                    .log()
                    .all()
                    .body(useJsonFormatToString.bodyNotSucceed());
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }

    }
    @When("cuando hace la peticion de registro")
    public void cuandoHaceLaPeticionDeRegistro() {
        try{
            response = request.when()
                    .post(BASE_TO_REGISTER);
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @Then("Recibe codigo y un mensaje de error, necesita password")
    public void recibeCodigoDeYUnMensajeDeErrorNecesitaPassword() {
        try{
            response.then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .log()
                    .all();

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }


    //get list
    @Given("como administrador me gustaria ver la lista de usuarios para verificar si el usuario esta registrado")
    public void comoAdministradorMeGustariaVerLaListaDeUsuariosParaVerificarSiElUsuarioEstaRegistrado() {
        try{
            generalSetUp();
            request.given();

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @When("cuando hace la peticion de ver lista")
    public void cuandoHaceLaPeticionDeVerLista() {
        try{
            response = request.with()
                    .get(BASE_TO_GET_LIST);

        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
    @Then("Recibe codigo y un mensaje, con todas las listas")
    public void recibeCodigoDeYUnMensajeConTodasLasListas() {
        try{
            response.then()
                    .statusCode(HttpStatus.SC_OK)
                    .log()
                    .all();
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }



}
