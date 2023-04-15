package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.adminModule.AdminPage;
import pageobjects.myInfoModule.myInfoCommons;


public class CommonOptions {
	WebDriver driver;

	@FindBy(css=".oxd-icon.bi-chevron-left")
	private WebElement toggleShrink;
	@FindBy(css=".oxd-icon.bi-chevron-right")
	private WebElement toggleExpand;

	@FindBy(css="input[placeholder='Search']")
	private WebElement search;

	@FindBy(xpath="//a[contains(@href, 'AdminModule')]")
	private WebElement admin;
	@FindBy(xpath="//a[contains(@href, 'PimModule')]")
	private WebElement PIM;
	@FindBy(xpath="//a[contains(@href, 'LeaveModule')]")
	private WebElement leave;
	@FindBy(xpath="//a[contains(@href, 'TimeModule')]")
	private WebElement time;
	@FindBy(xpath="//a[contains(@href, 'RecruitmentModule')]")
	private WebElement recruitment;
	@FindBy(xpath="//a[contains(@href, 'MyDetails')]")
	private WebElement myDetails;
	@FindBy(xpath="//a[contains(@href, 'PerformanceModule')]")
	private WebElement performance;
	@FindBy(xpath="//a[contains(@href, 'dashboard')]")
	private WebElement dashboard;
	@FindBy(xpath="//a[contains(@href, 'Directory')]")
	private WebElement directory;
	@FindBy(xpath="//a[contains(@href, 'MaintenanceModule')]")
	private WebElement maintenance;
	@FindBy(xpath="//a[contains(@href, 'Buzz')]")
	private WebElement buzz;

	@FindBy(xpath="//a[@class ='oxd-main-menu-item' and contains(@href, 'index')]")
	private List<WebElement> allList;
	@FindBy(xpath="//a[@class ='oxd-main-menu-item' and contains(@href, 'index')]//span")
	private List<WebElement> allListText;

	//ProfileOptions
	@FindBy(className="oxd-userdropdown-tab")
	private WebElement profileOptions;
	@FindBy(linkText="About")
	private WebElement about;
	@FindBy(linkText="Support")
	private WebElement support;
	@FindBy(linkText="Change Password")
	private WebElement changePassword;
	@FindBy(linkText="Logout")
	private WebElement logout;
	@FindBy(xpath="//button[normalize-space()='×']")
	private WebElement closeAbout;





	public CommonOptions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Toggle actions

	public boolean toggleCheck(String command) {

		if(command.equalsIgnoreCase("shrink")) {
			toggleShrink.click();
			if(time.getAttribute("class").contains("toggle")) {
				return true;
			}

		}
		else if(command.equalsIgnoreCase("expand")) {
			toggleShrink.click();
			toggleExpand.click();
			if(!(time.getAttribute("class").contains("toggle"))) {
				return true;
			}
		}
		return false;
	}



	public AdminPage openAdminModule() {
		admin.click();
		return new AdminPage(driver);
	}

	public myInfoCommons openMyInfoModule() {
		myDetails.click();
		return new myInfoCommons(driver);
	}
	
	public DashboardPage openDashboardModule() {
		dashboard.click();
		return new DashboardPage(driver);
	}
	public boolean searchSidePanel(String keyword){
		search.sendKeys(keyword);
		for (WebElement visibleOptions : allListText) {
			if(visibleOptions.getText().contains(keyword)) {
				return true;
			}	
		}
		return false;
	}

	//Focus 

	public boolean checkFocus(String option) {
		switch (option) {
		case "Dashboard": {
			if(dashboard.getCssValue("background-color").equalsIgnoreCase("rgba(255, 123, 29, 1)")) {
				return true;
			}
		}
		case "MyInfo": {
			if(myDetails.getCssValue("background-color").equalsIgnoreCase("rgba(255, 123, 29, 1)")) {
				return true;
			}
		}

		case "Admin": {
			if(admin.getCssValue("background-color").equalsIgnoreCase("rgba(255, 123, 29, 1)")) {
				return true;
			}
		}

		case "Leave": {
			if(leave.getCssValue("background-color").equalsIgnoreCase("rgba(255, 123, 29, 1)")) {
				return true;
			}
		}
		}
		return false;	
	}

	public boolean isAllSideModulesDisplayed() {
		if(allList.size()==10) {
			return true;
		}
		return false;
	}


	//ProfileOption Actions
	public boolean profileOptions(String option) {
		profileOptions.click();
		switch (option) {
		case "about": {
			about.click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(closeAbout));
			if(closeAbout.isDisplayed()) {
				return true;
			}
			break;
		}

		case "support": {
			if(support.isDisplayed()) {
				support.click();
				return true;
			}
			break;
		}

		case "Change Password": {
			changePassword.click();
			break;
		}

		case "logout": {
			logout.click();
			if(driver.getCurrentUrl().contains("login")) {
				return true;
			}
			break;
		}

		}
		return false;	
	}

	public boolean checkIfAboutCardIsClosed() {
		return closeAbout.isDisplayed();
	}
	public boolean closeAbout() {
		if(closeAbout.isDisplayed()) {
			closeAbout.click();
			return true;
		}
		return false;
	}
}
