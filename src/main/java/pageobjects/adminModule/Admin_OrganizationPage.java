package pageobjects.adminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Admin_OrganizationPage implements IAdmin {
	WebDriver driver;



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
