package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {

	WebDriver driver;
	
	@FindBy(name="username")
	private WebElement username;
	@FindBy(css="button[type='submit']")
	private WebElement reset;
	@FindBy(css="button[type='button']")
	private WebElement cancel;
	@FindBy(tagName="h6")
	private WebElement verify;
	@FindBy(css=".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message")
	private WebElement warning;
	

	
	public ResetPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyFocusInReset() {
		return username.isDisplayed();
	}
	
	public void resetPwd() {
		username.sendKeys("gokulsam07");
		reset.click();
	}
	
	public boolean verifyReset() {
		return verify.isDisplayed();
	}
	
	
	
	public boolean resetPwdWithoutUsername() {
		reset.click();
		return warning.isDisplayed();
	}
	
	public LoginPage verifyCancelInReset() {
		cancel.click();
		return new LoginPage(driver);
	}


}
