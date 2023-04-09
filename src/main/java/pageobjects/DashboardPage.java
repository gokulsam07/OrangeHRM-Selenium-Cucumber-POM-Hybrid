package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	@FindBy(xpath="//h6[normalize-space()='Dashboard']")
	private WebElement dashboardFocus;


	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isFocusInDasboard() {
		return dashboardFocus.isDisplayed();
	}
}
