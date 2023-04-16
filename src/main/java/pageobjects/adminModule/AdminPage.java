package pageobjects.adminModule;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AdminPage implements IAdmin{

	WebDriver driver;

	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[1]") 
	private WebElement moduleName;
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[2]") 
	private WebElement optionName;

	//Admin Ribbon Options
	@FindBy(xpath="//span[normalize-space()='User Management']") 
	private WebElement userManagement;
	@FindBy(xpath="//span[normalize-space()='Job']") 
	private WebElement job;
	@FindBy(xpath="//span[normalize-space()='Organization']") 
	private WebElement organization;
	@FindBy(xpath="//a[normalize-space()='Nationalities']") 
	private WebElement nationality;
	@FindBy(linkText="Corporate Branding") 
	private WebElement corporateBranding;


	@FindBy(css="div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']") 
	private WebElement usernameField;
	@FindBy(css="button[type='submit']") 
	private WebElement search;
	@FindBy(xpath="//div[@class='oxd-table-card']//div[2]//div[1]") 
	private List<WebElement> searchEmp;
	@FindBy(css="button[class='oxd-button oxd-button--medium oxd-button--ghost']") 
	private WebElement reset;
	@FindBy(css="div[class='orangehrm-horizontal-padding orangehrm-vertical-padding'] span[class='oxd-text oxd-text--span']") 
	private WebElement recordCount;






	public AdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@Override
	public boolean checkFocus() {
		return moduleName.getText().contains("Admin");
	}


	//Select options in top ribbon

	public IAdmin selectOptions(String option) {
		switch (option) {
		case "organization": {
			job.click();
			return new Admin_OrganizationPage(driver);
		}
		case "nationalities": {
			nationality.click();
			return new Admin_NationalitiesPage(driver);
		}

		case "corporate branding": {
			corporateBranding.click();
			return new Admin_CorporateBrandingPage(driver);
		}
		}
		return null;
	}

	public boolean enterUsername_Search_Verify(String username) {
		usernameField.sendKeys(username);
		search.click();
		if(searchEmp.size()>0) {
			return searchEmp.get(0).getText().contains(username);
		}
		return false;
	}

	public boolean clickReset() {
		reset.click();

		String str = recordCount.getText();
		String count = Integer.toString(searchEmp.size());

		if(str.substring(str.indexOf("(") + 1, str.indexOf(")")).trim().equals(count)) {
			return true;
		}
		return false;
	}
}
