package info.seleniumcucumber.userStepDefintions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverUtil;
import org.openqa.selenium.WebDriver;
import utils.ExtentReportUtil;


public class Hooks {

    public static WebDriver driver = DriverUtil.getDriver();
    public static ExtentReportUtil report = new ExtentReportUtil();
    public static Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        Hooks.scenario = scenario;
        report.initializeReport(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario){
        try{
            report.flushReport();
            driver.quit();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
