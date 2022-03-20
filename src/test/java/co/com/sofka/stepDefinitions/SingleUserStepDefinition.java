package co.com.sofka.stepDefinitions;

import co.com.sofka.stepDefinitions.SetUp.servicesSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.when;


public class SingleUserStepDefinition extends servicesSetUp {
    private static final Logger LOGGER = Logger.getLogger(SingleUserStepDefinition.class);
    private Response response;
    private RequestSpecification request;
    @Given("un usuario busca cuales son sus datos registrados")
    public void unUsuarioBuscaCualesSonSusDatosRegistrados() {

        try{
            generalSetUp();
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }

    }
    @When("hace clik para buscar sus datos")
    public void haceClikParaBuscarSusDatos() {
        try{
            response = when().get(BASE_TO_GET);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            Assertions.fail(e.getMessage());
        }


    }
    @Then("Recibe un codigo de estatus y sus credenciales")
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
