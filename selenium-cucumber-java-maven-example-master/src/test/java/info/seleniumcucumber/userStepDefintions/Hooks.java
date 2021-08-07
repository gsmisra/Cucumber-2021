package info.seleniumcucumber.userStepDefintions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import env.DriverUtil;
import org.openqa.selenium.WebDriver;


public class Hooks {

    public static WebDriver driver = DriverUtil.getDriver();

    @Before
	public String beforeScenario(Scenario scenario){
        System.out.println("Running before hook");

        return "";
    }

    @After
    public void afterScenario(Scenario scenario){
        try{
           driver.quit();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
