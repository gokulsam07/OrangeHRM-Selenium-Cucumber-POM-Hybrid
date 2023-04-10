package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.DashboardPage;
import pageobjects.LoginPage;


public class LoginTest {
	public WebDriver driver;
	public static LoginPage loginPage;
	private DashboardPage dashboardPage;

	@Given("^user navigates to login page$")
	public  LoginPage user_navigates_to_login_page(){
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
		return loginPage;
	}

	@When("^user enters the username (.+)$")
	public void user_enters_the_username(String username){
		loginPage.enterUsername(username);;
	}

	@And("^user enters the password (.+)$")
	public void user_enters_the_password(String password)   {
		loginPage.enterPassword(password);
	}
	@And("^click login button$")
	public void click_login_button()   {
		dashboardPage = loginPage.clickLogin();
	}


	@Then("^it should login and display the dashboard or display appropriate warning (.+)$") 
	public void it_should_login_and_display_the_dashboard_or_display_appropriate_warning(String username)   {
		switch (username) {
		case "Admin":
			Assert.assertEquals(true, dashboardPage.isFocusInDasboard());
			break;
		case "gokulsam07":
			Assert.assertEquals("Invalid credentials", loginPage.isErrorDisplayedForWrongCreds());
			break;
		}
	}

	@And("^display appropriate warning$")
	public void display_appropriate_warning()   {
		Assert.assertEquals(true, loginPage.IsWarningDisplayed());
	}
}
