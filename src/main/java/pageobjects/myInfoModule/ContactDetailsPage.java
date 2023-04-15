package pageobjects.myInfoModule;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonUtils;

public class ContactDetailsPage implements IMyInfo{
	WebDriver driver;


	@FindBy(linkText="Contact Details")
	private WebElement contactsDetails;
	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[1]//div[1]//div[1]//div[1]//div[2]//input[1]")
	private WebElement stAddress;
	@FindBy(css="div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] button[type='submit']")
	private WebElement save;
	@FindBy(xpath="//div[@id='oxd-toaster_1']//p[2]")
	private WebElement successToast;




	public ContactDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	public boolean checkFocus() {
		return contactsDetails.getCssValue("background-color").equals("rgb(246 245 251)");
	}

	public boolean changeAddress() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		stAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.chord(Keys.CONTROL, "x"));
		stAddress.sendKeys(CommonUtils.getNewEmail()+"2000 Mallory Ln #610", Keys.TAB, Keys.TAB,"Frankline", Keys.TAB,"Tennessee",Keys.TAB,"37067");
		Thread.sleep(2000);
		save.click();
		wait.until(ExpectedConditions.visibilityOf(successToast));
		if(successToast.getText().contentEquals("Successfully Updated")) {
			return true;
		}
		return false;
	}
}
