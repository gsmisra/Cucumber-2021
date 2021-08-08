package info.seleniumcucumber.userStepDefintions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.DriverUtil;
import utils.ExtentReportUtil;


public class googleSteps extends DriverUtil{

	public static WebDriver driver = DriverUtil.getDriver();
	public static ExtentReportUtil report = new ExtentReportUtil();
	public Scenario scenario = Hooks.scenario;

	@Given("^Launch google\\.com$")
	public void launch_google_com() throws Throwable {
		report.logStep(scenario,
				"info",
				"Launching browser!");
	    driver.get("https://google.com");
		report.logStep(scenario,
				"Pass",
				"Browser launched");
	}

	@Then("^Enter the string \"([^\"]*)\" in the search box$")
	public void enter_the_string_in_the_search_box(String search_string) throws Throwable {
	    driver.findElement(By.xpath("*//input[@title='Search']")).sendKeys(search_string);
		report.logStep(scenario,
				"Pass",
				"Search string is entered");
	}

	@Then("^Click search$")
	public void click_search() throws Throwable {
		try{
			driver.findElement(By.xpath("*//input[@title='Search']")).sendKeys(Keys.ENTER);
			report.logStep(scenario,
					"pass",
					"Search button is clicked");
		}catch(Exception e){
			report.logStep(scenario,
					"fail",
					"Unable to click search button");
		}
	}

	@Then("^Verify the output$")
	public void verify_the_output() throws Throwable {
		try {
			if(driver.findElement(By.xpath("//h3[contains(text(),'Cucumber: BDD Testing & Collaboration Tools for Teams')]")).isDisplayed()) {
				System.out.println("Got search result!");
				report.logStep(scenario,
						"pass",
						"Search result is displayed as expected");
			}else{
				report.logStep(scenario,
						"fail",
						"Unable to get search result");
			}
		} catch(NoSuchElementException e) {
			report.logStep(scenario,"fail",e.toString());
		}
	}


	@Then("^Click on wikipedia link and take a snap$")
	public void click_on_wikipedia_link_and_take_a_snap() throws Throwable {
		try {
			driver.findElement(By.xpath("*//a[contains(text(),'Wikipedia')]")).click();
			report.logStep(scenario,
					"pass",
					"Wiki link is clicked");
		} catch (Exception e){
			report.logStep(scenario,"fail", "Wiki link could not be clicked");
		}
	}

}
