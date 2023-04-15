package pageobjects.myInfoModule;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PersonalDetailsPage implements IMyInfo{
	WebDriver driver;


	@FindBy(linkText="Personal Details")
	private WebElement personalDetails;
	@FindBy(xpath="(//h6)[2]")
	private WebElement name;


	//fields
	@FindBy(name="firstName")
	private WebElement firstName;
	@FindBy(name="lastName")
	private WebElement lastName;
	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[2]")
	private WebElement dob;
	@FindBy(xpath="//input[@value='1']")
	private WebElement male;
	@FindBy(xpath="//input[@value='2']")
	private WebElement female;
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")
	private WebElement maritalStatus;
	@FindBy(xpath="//div[@role='listbox']//div[2]")
	private WebElement singleStatus;
	@FindBy(xpath="//div[@role='listbox']//div[3]")
	private WebElement marriedStatus;
	@FindBy(xpath="//div[@id='oxd-toaster_1']//p[2]")
	private WebElement successToast;



	@FindBy(xpath="(//button[@type='submit'])[1]")
	private WebElement save;


	public PersonalDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	@Override
	public boolean checkFocus() {
		return personalDetails.getCssValue("background-color").equals("rgb(246 245 251)");
	}

	public boolean editAndSavePersonalDetails() throws InterruptedException {

		firstName.click();
		firstName.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"x"));
		System.out.println(firstName.getCssValue("border"));
		if(firstName.getCssValue("border").contains("1px solid rgb(235, 9, 16)")) {
			firstName.sendKeys("Paule");
		}

		lastName.click();
		lastName.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"x"));
		if(lastName.getCssValue("border").contains("1px solid rgb(235, 9, 16)")) {
			lastName.sendKeys("Collingse");
		}

		dob.click();
		dob.sendKeys("a",Keys.ENTER);
		if(dob.getCssValue("border").contains("1px solid rgb(235, 9, 16)")) {
			dob.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.chord(Keys.CONTROL,"x"));
			dob.sendKeys("1978-10-15");
		}

		Actions action = new Actions(driver);
		if(male.isSelected()) {
			action.moveToElement(female).click().build().perform();
		}
		else
		{
			action.moveToElement(male).click().build().perform();
		}

		Thread.sleep(4000);
		action.moveToElement(maritalStatus).click().perform();
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(singleStatus));

		if(singleStatus.isSelected()) {
			marriedStatus.click();
		}
		singleStatus.click();

		save.click();
		if(successToast.getText().contentEquals("Successfully Updated")) {
			return true;
		}
		return false;
	}



	public boolean verifyPersonalDetails() {
		if(name.getText().contentEquals("Paule Collingse")) {
			return true;
		}
		return false;
	}
}
