package pageobjects.myInfoModule;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myInfoCommons implements IMyInfo {
	WebDriver driver;
	

	@FindBy(xpath="//h6[normalize-space()='PIM']")
	private WebElement moduleName;

	//Commons
	@FindBy(linkText="Personal Details")
	private WebElement personalDetails;
	@FindBy(linkText="Contact Details")
	private WebElement contactDetails;
	@FindBy(linkText="Emergency Contacts")
	private WebElement emergencyContacts;
	@FindBy(linkText="Dependents")
	private WebElement dependents;
	@FindBy(linkText="Job")
	private WebElement job;

	public myInfoCommons(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@Override
	public boolean checkFocus() {
		return moduleName.getText().contains("My Info");
	}

	public IMyInfo selectPage(String pageName) {
		switch (pageName) {
		case "Personal details": {
			personalDetails.click();
			return new PersonalDetailsPage(driver);
		}
		
		}
		return null;
	}
}
