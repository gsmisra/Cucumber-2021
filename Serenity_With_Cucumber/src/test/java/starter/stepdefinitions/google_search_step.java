package starter.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.pages.PageObject;

public class google_search_step extends PageObject {
	
	@Given("Launch google.com")
	public void launch_google_com() {
	   getDriver().get("https://google.com");
	}

	@Then("Enter the string {string} in the search box")
	public void enter_the_string_in_the_search_box(String search_string) {
		getDriver().findElement(By.xpath("*//input[@title='Search']")).sendKeys(search_string);
	}

	@Then("Click search")
	public void click_search() {
		getDriver().findElement(By.xpath("*//input[@title='Search']")).sendKeys(Keys.ENTER);
	}

	@Then("Verify the output")
	public void verify_the_output() {
		try {
			if(getDriver().findElement(By.xpath("*//div[@class=\"DRolee\"][contains(text(),'Serenity-Cucumber')]")) != null) {
				System.out.println("Got search result!");
			}
		}
		
		catch(NoSuchElementException e) {
			System.out.println("OOPSE...Could not get search result!");
		}
	}

	@Then("Click on wikipedia link and take a snapa")
	public void Click_OnLink() {
		getDriver().findElement(By.xpath("*//a/h3[contains(text(),'An Introduction to BDD')]")).click();
	}
	
	@Then("Click on Github link")
	public void click_on_Github_link() {
		getDriver().findElement(By.linkText("on GitHub")).click();
	}

	@Then("Click on pom xml link")
	public void click_on_pom_xml_link() {
		getDriver().findElement(By.linkText("pom.xml")).click();
	}

	@Then("Get content of the pom")
	public void get_content_of_the_pom() {
		int pom_size=getDriver().findElements(By.xpath("*//div[@itemprop='text']/table/tbody/tr")).size();
		for(int i=0;i<=pom_size-1;i++){
			String pomcontent=getDriver().findElements(By.xpath("*//div[@itemprop='text']/table/tbody/tr")).get(i).getText().trim();
			System.out.println(pomcontent);
		}
	}
}
