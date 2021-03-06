package starter;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		tags={"@RunAll"},
        plugin = {"pretty"},
        //features = "src/test/resources/features"
        features = "src/test/resources/features/google/googleSearch.feature",
        glue = "starter.stepdefinitions",
        monochrome = true
)


public class TestRunner {


}

//mvn serenity:aggregate
//mvn serenity:reports -Dserenity.reports=email
