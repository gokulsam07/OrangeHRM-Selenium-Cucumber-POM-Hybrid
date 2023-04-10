package stepdefinitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import pageobjects.ResetPasswordPage;

public class ForgotPasswordTest {
	public WebDriver driver;
	private LoginPage loginPage = LoginTest.loginPage;
	private ResetPasswordPage resetpasswordPage;


	@When("^user click forgot password link$")
	public void user_click_forgot_password_link(){
		resetpasswordPage = loginPage.verifyForgotPassword();
	}


	@Then("^user should be redirected to resetpage$") 
	public void user_should_be_redirected_to_resetpage()   {
		Assert.assertEquals(true,resetpasswordPage.verifyFocusInReset());
	}

	@And("the user should be able to enter username {string}")
	public void user_enters_the_password(String username)   {
		resetpasswordPage.resetPwd();
	}
	@And("^click reset and user should get proper message for reset passowrd$")
	public void click_reset_and_user_should_get_proper_message_for_reset_passowrd()   {
		Assert.assertEquals(true, resetpasswordPage.verifyReset());
	}



	@And("the user should be able to click cancel button and redirect to loginpage")
	public void the_user_should_be_able_to_click_cancel_button_and_redirect_to_loginpage()   {
		loginPage=resetpasswordPage.verifyCancelInReset();
		Assert.assertEquals(true, loginPage.verifyForgotPasswordIsDsiplayed());
	}
	
}
