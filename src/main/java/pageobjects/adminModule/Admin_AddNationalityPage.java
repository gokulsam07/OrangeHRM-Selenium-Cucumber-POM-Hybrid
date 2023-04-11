package pageobjects.adminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_AddNationalityPage implements IAdmin {
	
	WebDriver driver;
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[1]") 
	private WebElement moduleName;
	@FindBy(css="div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']") 
	private WebElement addCountry;
	@FindBy(css="button[type='submit']") 
	private WebElement saveCountry;
	
	public Admin_AddNationalityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	public boolean checkFocus() {
		return moduleName.getText().contains("Admin");
	}
	
	public Admin_NationalitiesPage addSaveCountry() {
		addCountry.sendKeys("A");
		saveCountry.click();
		return new Admin_NationalitiesPage(driver);
	}

}
