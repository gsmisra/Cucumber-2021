package info.seleniumcucumber.userStepDefintions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import env.DriverUtil;

public class googleSteps extends DriverUtil{
	public Scenario scenario;
	public static WebDriver driver = DriverUtil.getDriver();
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@Given("^Launch google\\.com$")
	public void launch_google_com() throws Throwable {
	    driver.get("https://google.com");
	}

	@Then("^Enter the string \"([^\"]*)\" in the search box$")
	public void enter_the_string_in_the_search_box(String search_string) throws Throwable {
	    driver.findElement(By.xpath("*//input[@title='Search']")).sendKeys(search_string);
	    snap(scenario, "Google should be open");
	}

	@Then("^Click search$")
	public void click_search() throws Throwable {
	    //driver.findElement(By.xpath("*//input[1][@value='Google Search']")).click();
		driver.findElement(By.xpath("*//input[@title='Search']")).sendKeys(Keys.ENTER);
	}

	@Then("^Verify the output$")
	public void verify_the_output() throws Throwable {
		try {
			if(driver.findElement(By.xpath("*//div[@id=\"search\"]/div/div/div/div/div/div/div/div//div/span[1]/span[1]/b[contains(text(),'Cucumber')]")) != null) {
				System.out.println("Got search result!");
				snap(scenario, "Search results are displayed!");
			}
		}
		
		catch(NoSuchElementException e) {
			System.out.println("OOPSE...Could not get search result!");
		}
	}


	@Then("^Click on wikipedia link and take a snap$")
	public void click_on_wikipedia_link_and_take_a_snap() throws Throwable {
		driver.findElement(By.xpath("*//a[contains(text(),'Wikipedia')]")).click();
		snap(scenario,"Wikipedia page should be open.");
	}
	
	@Then("^Navigate to https://cucumber\\.io/$")
	public void navigate_to_https_cucumber_io() throws Throwable {
	    driver.navigate().to("https://cucumber.io");
	    snap(scenario,"cucumber.io should be open");
	}

	@Then("^Click on the link Automate with Cucumber$")
	public void click_on_the_link_Automate_with_Cucumber() throws Throwable {
		try {
			driver.findElement(By.linkText("Automate with Cucumber")).click();
		    snap(scenario,"Automate with Cucumber page should be open");
		}
	    	    
	    catch(NoSuchElementException e) {
	    	snap(scenario,"Unable to click Automate with cucumber link...");
	    }
	}

	@Then("^Click on the donate button$")
	public void click_on_the_donate_button() throws Throwable {
	    driver.findElement(By.xpath("*//img[@src='https://opencollective.com/cucumber/donate/button@2x.png?color=white']")).click();
	    snap(scenario,"Donate button should be clicked");
	}

	@Then("^Click on Join Free link$")
	public void click_on_Join_Free_link() throws Throwable {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    driver.findElement(By.xpath("*//span[contains(text(),'Join Free')]")).click();
	    snap(scenario,"Joining for free page should be open!");
	}
}
