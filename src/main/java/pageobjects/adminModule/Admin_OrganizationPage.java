package pageobjects.adminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_OrganizationPage implements IAdmin {
	WebDriver driver;

	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[1]") 
	private WebElement moduleName;
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[2]") 
	private WebElement optionName;

	public Admin_OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	@Override
	public boolean checkFocus() {
		// TODO Auto-generated method stub
		return false;
	}
}
