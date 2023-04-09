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

	public boolean isErrorDisplayedForWrongCreds() {
		return loginError.isDisplayed();
	}
	
}
