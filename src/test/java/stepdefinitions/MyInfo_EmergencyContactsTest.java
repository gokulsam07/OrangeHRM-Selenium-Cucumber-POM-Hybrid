package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.myInfoModule.EmergencyContactsPage;

public class MyInfo_EmergencyContactsTest {
	public WebDriver driver;
	EmergencyContactsPage emergencyContactsPage = MyInfo_PersonalDetailsTest.emergencyContactsPage;
	SoftAssert assertSoft =new SoftAssert();

	@And("verify there is no record")
	public void verify_there_is_no_record()   {
		assertSoft.assertEquals(true, emergencyContactsPage.verifyNoRecord());
	}

	@Then("^add emergency contact and verify$")
	public void add_emergency_contact_andverify() {
		assertSoft.assertEquals(true,emergencyContactsPage.addverifyEmergencyContacts());
	}
	@And("delete and reverify")
	public void delete_and_reverify() throws InterruptedException   {
		assertSoft.assertEquals(true, emergencyContactsPage.deleteReverify());
	}



}
