package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CommonOptions;
import pageobjects.LoginPage;
import pageobjects.adminModule.AdminPage;

public class Admin_UserManagementTest {
	public WebDriver driver;
	LoginPage loginPage =LoginTest.loginPage;
	CommonOptions commonOptions=LoginTest.commonOptions;
	AdminPage adminPage;
	
	@When("^user selects Admin module$")
	public void user_selects_Admin_module(){
		adminPage = commonOptions.openAdminModule();
	}

	@Then("^focus should be in Admin module$")
	public void focus_should_be_in_Admin_module()   {
		Assert.assertEquals(true, adminPage.checkFocus());
	}
	@And("^user enters username (.+) in the username field and clicks search to verify$")
	public void user_enters_username_something_in_the_username_field_and_clicks_search_to_verify(String username)   {
		Assert.assertEquals(true, adminPage.enterUsername_Search_Verify(username));
	}
	
	@Then("^user clicks on reset to verify reset$")
	public void user_clicks_on_reset_to_verify_reset()   {
		Assert.assertEquals(true, adminPage.clickReset());
	}
	

}
