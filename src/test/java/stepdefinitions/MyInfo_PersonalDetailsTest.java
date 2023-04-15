package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CommonOptions;
import pageobjects.myInfoModule.ContactDetailsPage;
import pageobjects.myInfoModule.EmergencyContactsPage;
import pageobjects.myInfoModule.JobsPage;
import pageobjects.myInfoModule.PersonalDetailsPage;
import pageobjects.myInfoModule.myInfoCommons;


public class MyInfo_PersonalDetailsTest {
	public WebDriver driver;
	CommonOptions commonOptions= LoginTest.commonOptions;
	myInfoCommons myInfo ;
	PersonalDetailsPage personalDetailsPage ;
	public static ContactDetailsPage contactDetailsPage;
	public static EmergencyContactsPage emergencyContactsPage;
	public static JobsPage jobsPage;
	SoftAssert assertSoft =new SoftAssert();


	@When("^user selects myInfo module$")
	public void user_selects_myInfo_module(){
		myInfo = commonOptions.openMyInfoModule();
	}

	@Then("^focus should be in myInfo module$")
	public void focus_should_be_in_myInfo_module()   {
		assertSoft.assertEquals(true, myInfo.checkFocus());
	}


	@When("^user is in (.+) page$")
	public void user_is_in_something_page(String option){
		switch (option) {
		case "Personal details": {
			personalDetailsPage = (PersonalDetailsPage) myInfo.selectPage(option);
			assertSoft.assertEquals(true, personalDetailsPage.checkFocus());
			break;
		}
		case "Contact details": {
			contactDetailsPage = (ContactDetailsPage) myInfo.selectPage(option);
			assertSoft.assertEquals(true, contactDetailsPage.checkFocus());
			break;
		}
		
		case "Emergency contacts": {
			emergencyContactsPage = (EmergencyContactsPage) myInfo.selectPage(option);
			assertSoft.assertEquals(true, emergencyContactsPage.checkFocus());
			break;
		}
		
		case "Jobs": {
			jobsPage = (JobsPage) myInfo.selectPage(option);
			assertSoft.assertEquals(true, jobsPage.checkFocus());
			break;
		}

		}
	}

	@Then("^edit the details and save$")
	public void edit_the_details_and_save() throws InterruptedException   {
		personalDetailsPage.editAndSavePersonalDetails();
	}

	@And("verify the modified details")
	public void verify_the_modified_details()   {
		Assert.assertEquals(true, personalDetailsPage.verifyPersonalDetails());
	}
}
