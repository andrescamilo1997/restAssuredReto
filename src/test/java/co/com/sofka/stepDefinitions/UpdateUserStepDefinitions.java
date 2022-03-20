package co.com.sofka.stepDefinitions;

import co.com.sofka.stepDefinitions.SetUp.servicesSetUp;
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



public class UpdateUserStepDefinitions extends servicesSetUp {
    private static final Logger LOGGER = Logger.getLogger(UpdateUserStepDefinitions.class);
    private Response response;
    private RequestSpecification request;
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
                    .all();


        }catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }
    }
}
