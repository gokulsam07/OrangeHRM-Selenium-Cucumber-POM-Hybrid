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
	private LoginPage loginPage;
	private DashboardPage dashboardPage;

	@Given("^user navigates to login page$")
	public void user_navigates_to_login_page()   {
		driver = DriverFactory.getDriver();
		loginPage = new LoginPage(driver);
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String username){
		loginPage.enterUsername(username);;
	}

	@And("user enters the password {string}")
	public void user_enters_the_password(String password)   {
		loginPage.enterPassword(password);
	}
	@And("^click login button$")
	public void click_login_button()   {
		dashboardPage = loginPage.clickLogin();
	}


	@Then("^it should login and display the dashboard$")
	public void it_should_login_and_display_the_dashboard()   {
		Assert.assertEquals(true, dashboardPage.isFocusInDasboard());

	}

}
