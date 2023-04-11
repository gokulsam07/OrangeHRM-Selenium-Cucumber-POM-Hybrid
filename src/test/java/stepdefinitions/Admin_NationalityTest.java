package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import pageobjects.adminModule.AdminPage;
import pageobjects.adminModule.Admin_NationalitiesPage;

public class Admin_NationalityTest {
	public WebDriver driver;

	AdminPage adminPage= Admin_UserManagementTest.adminPage;
	Admin_NationalitiesPage adminNationalitiesPage;


	@And("^click on (.+) and verify the count of countries$")
	public void click_on_something_and_verify_the_count_of_countries(String option)   {
		adminNationalitiesPage = (Admin_NationalitiesPage) adminPage.selectOptions(option);
		Assert.assertEquals(true, adminNationalitiesPage.checkIfAllCountriesArePresent());
	}

	@And("^add country and verify the addition$")
	public void add_country_and_verify_the_addition()   {
		Assert.assertEquals(true, adminNationalitiesPage.addCountry().addSaveCountry().verifyAddedCountry());
	}
}
