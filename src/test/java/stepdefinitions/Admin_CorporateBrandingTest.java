package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CommonOptions;
import pageobjects.LoginPage;
import pageobjects.adminModule.AdminPage;
import pageobjects.adminModule.Admin_CorporateBrandingPage;


public class Admin_CorporateBrandingTest {
	public WebDriver driver;
	LoginPage loginPage =LoginTest.loginPage;
	CommonOptions commonOptions=LoginTest.commonOptions;
	AdminPage adminPage = Admin_UserManagementTest.adminPage;
	Admin_CorporateBrandingPage corpBrandingPage;


	@When("^focus is in (.+) module$")
	public void focus_is_in_corporate_branding_module(String options){
		corpBrandingPage = (Admin_CorporateBrandingPage)adminPage.selectOptions(options);
		Assert.assertEquals(true, corpBrandingPage.checkFocus());
	}

	@Then("^verify default color$")
	public void verify_default_color()   {
		Assert.assertEquals(true, corpBrandingPage.verifyDefaultColor());
	}

	@And("^modify colors and verify color change in preview$")
	public void modify_colors_and_verify_color_change_in_preview() throws InterruptedException   {
		Assert.assertEquals(true, corpBrandingPage.modifyColorsAndVerifyPreview());
	}

	@Then("^reset the colors and verify colors after reset$")
	public void reset_the_colors_and_verify_colors_after_reset(){
		Assert.assertEquals(true, corpBrandingPage.modifyColorsAndVerifyReset());
	}

}
