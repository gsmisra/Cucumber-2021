package info.seleniumcucumber.userStepDefintions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import env.DriverUtil;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver = DriverUtil.getDriver();

    @Before
	public void beforeScenario(){
        System.out.println("Running before hook");
    }

    @After
    public void afterScenario(){
        System.out.println("++++++++++++++++++++++++++  Closing driver from After hook! ++++++++++++++++++++++++++");

       try{
           driver.quit();
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
