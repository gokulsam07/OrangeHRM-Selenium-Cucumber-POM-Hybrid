package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(name="username")
	private WebElement username;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(tagName="button")
	private WebElement submit;
	@FindBy(css=".oxd-text.oxd-text--p.oxd-alert-content-text")
	private WebElement loginError;
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active oxd-input--error' and @name='username']")
	private WebElement usernameWarning;
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active oxd-input--error' and @name='password']")
	private WebElement passwordWarning;
	@FindBy(css=".oxd-text.oxd-text--p.orangehrm-login-forgot-header")
	private WebElement forgotPassword;





	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String email) {
		username.sendKeys(email);
	}
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	public DashboardPage clickLogin() {
		submit.click();
		return new DashboardPage(driver);
	}

	public String isErrorDisplayedForWrongCreds() {
		return loginError.getText();
	}

	public boolean IsWarningDisplayed() {
		if(usernameWarning.isDisplayed()) {
			return passwordWarning.isDisplayed();
		}
		return false;
	}

	public ResetPasswordPage verifyForgotPassword() {
		forgotPassword.click();
		return new ResetPasswordPage(driver);
	}

	public boolean verifyForgotPasswordIsDsiplayed() {
		return forgotPassword.isDisplayed();
	}

}
