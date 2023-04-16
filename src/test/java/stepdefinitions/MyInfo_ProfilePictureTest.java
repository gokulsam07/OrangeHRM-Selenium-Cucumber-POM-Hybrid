package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import pageobjects.myInfoModule.ProfilePicturePage;

public class MyInfo_ProfilePictureTest {
	public WebDriver driver;
	SoftAssert assertSoft =new SoftAssert();
	ProfilePicturePage profilePicturePage = MyInfo_PersonalDetailsTest.profilePicturePage;


	@Then("upload the {string} and verify")
	public void upload_the_something_and_verify(String file) throws InterruptedException   {
		System.out.println(file);
		switch (file) {
		case "valid file": {
			assertSoft.assertEquals(true, profilePicturePage.uploadAndVerify());
			break;
		}
		case "big file": {
			assertSoft.assertEquals(true, profilePicturePage.uploadInvalidFileTypesAndverify(file));
			break;
		}
		case "incompatible file": {
			assertSoft.assertEquals(true, profilePicturePage.uploadInvalidFileTypesAndverify(file));
			break;
		}
		case "no file": {
			assertSoft.assertEquals(true, profilePicturePage.uploadInvalidFileTypesAndverify(file));
			break;
		}
		
		}
	}
}
