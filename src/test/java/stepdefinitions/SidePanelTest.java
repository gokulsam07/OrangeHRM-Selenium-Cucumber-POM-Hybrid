package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.CommonOptions;


public class SidePanelTest {

	public WebDriver driver;
	private CommonOptions commonOptions = LoginTest.commonOptions;
	
	
	@And("^all the options should be displayed in sidepanel$")
	public void all_the_options_should_be_displayed_in_sidepanel()   {
		Assert.assertEquals(true, commonOptions.isAllSideModulesDisplayed());
	}
	
	@And("^click on the shrink toggle and verify behavaior$")
	public void click_on_the_shrink_toggle_and_verify_behavaior()   {
		Assert.assertEquals(true, commonOptions.toggleCheck("shrink"));
	}
	
	@And("^click on the expand toggle and verify behavaior$")
	public void click_on_the_expand_toggle_and_verify_behavaior()   {
		Assert.assertEquals(true, commonOptions.toggleCheck("expand"));
	}
	
	@Then("enter {string} and verify the options list")
	public void enter_something_and_verify_the_options_list(String keyword){
		Assert.assertEquals(true, commonOptions.searchSidePanel(keyword));
	}
	
}
