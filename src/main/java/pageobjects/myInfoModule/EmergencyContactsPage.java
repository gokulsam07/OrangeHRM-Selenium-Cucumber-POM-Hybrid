package pageobjects.myInfoModule;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EmergencyContactsPage implements IMyInfo{
	WebDriver driver;
	@FindBy(linkText="Emergency Contacts")
	private WebElement emergencyContacts;
	@FindBy(xpath="(//span[text()='No Records Found'])[1]")
	private WebElement noRecord;
	@FindBy(xpath="//div[contains(text(),'Frank')]")
	private WebElement recordFound;
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement add;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement name;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")
	private WebElement relationship;
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement num1;
	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement save;
	@FindBy(xpath="//div[@id='oxd-toaster_1']//p[2]")
	private WebElement successToast;

	@FindBy(xpath="//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-container']/div[@role='table']/div[@role='rowgroup']/div[@role='row']/div[@role='columnheader']/div[@class='oxd-checkbox-wrapper']/label/span[1]")
	private WebElement selectAllRecords;
	@FindBy(xpath="//button[normalize-space()='Delete Selected']")
	private WebElement deleteBtn;
	@FindBy(xpath="//div[@role='document']")
	private WebElement deletePopup;
	@FindBy(xpath="//button[normalize-space()='Yes, Delete']")
	private WebElement deleteAgree;
	@FindBy(xpath="//div[@id='oxd-toaster_1']//p[2]")
	private WebElement deleteToast;
	@FindBy(xpath="//div[@class='oxd-loading-spinner-container']")
	private WebElement spinner;

	

	public EmergencyContactsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@Override
	public boolean checkFocus() {
		return emergencyContacts.getCssValue("background-color").equals("rgb(246 245 251)");
	}

	public boolean verifyNoRecord() {
		return noRecord.isDisplayed();
	}

	public boolean addverifyEmergencyContacts() {
		add.click();
		name.sendKeys("A", Keys.chord(Keys.CONTROL,"a"), Keys.chord(Keys.CONTROL,"x"),
				Keys.TAB, "B",
				Keys.chord(Keys.CONTROL,"a"), Keys.chord(Keys.CONTROL,"x"),
				Keys.TAB, "9",
				Keys.chord(Keys.CONTROL,"a"), Keys.chord(Keys.CONTROL,"x"));

		
		if(name.getCssValue("border").contains("solid rgb(235, 9, 16)")
				&&relationship.getCssValue("border").contains("solid rgb(235, 9, 16)")
				&&num1.getCssValue("border").contains("solid rgb(235, 9, 16)")) {
			name.sendKeys("Frank",Keys.TAB, "Father",Keys.TAB, "98765432");
			save.click();
		}
		if(successToast.getText().contentEquals("Successfully Updated")) {
			return true;
		}
		return false;
	}

	public boolean deleteReverify() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(selectAllRecords).click(selectAllRecords).build().perform();
		deleteBtn.click();
		deleteAgree.click();
		if(deleteToast.getText().contentEquals("Successfully deleted")) {
			return true;
		}
		return false;

	}
}
