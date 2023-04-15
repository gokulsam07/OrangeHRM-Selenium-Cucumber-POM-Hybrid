package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import pageobjects.myInfoModule.JobsPage;

public class MyInfo_JobsTest {


	public WebDriver driver;
	SoftAssert assertSoft =new SoftAssert();
	JobsPage jobsPage = MyInfo_PersonalDetailsTest.jobsPage;

	@And("verify all data and user is not able to interact with any fields")
	public void verify_all_data_and_user_is_not_able_to_interact_with_any_fields(){
		Assert.assertEquals(true, jobsPage.verifyNotInteractable());
	}

}
