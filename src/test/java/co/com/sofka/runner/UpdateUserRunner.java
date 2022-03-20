package co.com.sofka.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/put_user.feature"},
        glue = {"co.com.sofka.stepDefinitions"}
)

public class UpdateUserRunner {
}
