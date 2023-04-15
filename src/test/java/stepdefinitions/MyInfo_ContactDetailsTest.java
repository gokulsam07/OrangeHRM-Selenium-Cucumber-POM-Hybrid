package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import pageobjects.myInfoModule.ContactDetailsPage;

public class MyInfo_ContactDetailsTest {

	public WebDriver driver;
	ContactDetailsPage contactDetailsPage=MyInfo_PersonalDetailsTest.contactDetailsPage;
	SoftAssert assertSoft =new SoftAssert();

	@Then("^fill the details save and verify$")
	public void fill_the_details_save_and_verify() throws InterruptedException   {
		assertSoft.assertEquals(true, contactDetailsPage.changeAddress());
	}
}
