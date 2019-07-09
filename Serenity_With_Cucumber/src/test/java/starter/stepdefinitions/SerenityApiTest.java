package starter.stepdefinitions;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.restassured.RestAssured;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.rest.SerenityRest;

/*@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		tags={"@phone"},
        plugin = {"pretty"},
        features = "src/test/resources/features/google/SerenityApi.feature",
        glue = "starter.stepdefinitions",
        monochrome = true
)*/
public class SerenityApiTest {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	}
	
	@Test
	public void getAllStudents() {
		System.out.println("API Test Started");
		SerenityRest.given()
			.when()
			.get("/Hyderabad")
			.then()
			.log()
			.all()
			.statusCode(200);
	}
}