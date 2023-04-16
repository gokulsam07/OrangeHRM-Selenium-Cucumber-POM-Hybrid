package pageobjects.myInfoModule;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilePicturePage implements IMyInfo {
	WebDriver driver;
	@FindBy(xpath="//div[@class='employee-image-wrapper']//img[@alt='profile picture']")
	private WebElement upload;
	@FindBy(xpath="//h6[normalize-space()='Change Profile Picture']")
	private WebElement focus;
	@FindBy(xpath="//button[normalize-space()='Save']")
	private WebElement save;
	@FindBy(xpath="//div[@id='oxd-toaster_1']//p[2]")
	private WebElement successToast;
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	private WebElement errorMsg;

	public ProfilePicturePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);


	}
	@Override
	public boolean checkFocus() {
		return focus.getText().contains("Change Profile Picture");
	}

	public boolean uploadAndVerify() throws InterruptedException {
		upload.click();

		try {
			Runtime.getRuntime().exec("F:\\script.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(2500);
		save.click();
		if(successToast.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean uploadInvalidFileTypesAndverify(String file) {

		upload.click();
		switch (file) {
		case "big file": {
			try {
				Runtime.getRuntime().exec("F:\\scriptbigfile.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}


			if(errorMsg.getText().contains("Attachment Size Exceeded")) {
				return true;
			}
			break;
		}

		case "incompatible file": {

			try {
				Runtime.getRuntime().exec("F:\\incompatiblescript.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}

			if(errorMsg.getText().contains("File type not allowed")) {
				return true;
			}
			break;
		}

		case "no file": {
			save.click();
			if(errorMsg.getText().contains("Required")) {
				return true;
			}
			break;
		}

		}
		return false;
	}
}
