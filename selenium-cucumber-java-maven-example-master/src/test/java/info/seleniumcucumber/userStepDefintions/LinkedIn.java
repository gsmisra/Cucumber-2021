package info.seleniumcucumber.userStepDefintions;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import utils.DriverUtil;
import utils.ExtentReportUtil;
import java.io.IOException;


public class LinkedIn {

    public static WebDriver driver = DriverUtil.getDriver();
    public static ExtentReportUtil report = new ExtentReportUtil();
    public Scenario scenario = Hooks.scenario;


    @Given("^Launch linkedIn$")
    public void launchLinkedIn() throws IOException {
        report.logStep(scenario,
                "info",
                "Launching browser");
        driver.get("https://www.linkedin.com/");
        report.logStep(scenario,
                "Pass",
                "LinkedIn is open");
    }
}
