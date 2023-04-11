package pageobjects.adminModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_JobPage implements IAdmin {
	WebDriver driver;

	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[1]") 
	private WebElement moduleName;
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[2]") 
	private WebElement optionName;

	@FindBy(xpath="//a[normalize-space()='Job Titles']") 
	private WebElement jobTitle;
	@FindBy(xpath="//a[normalize-space()='Pay Grades']") 
	private WebElement payGrade;
	@FindBy(xpath="//a[normalize-space()='Employment Status']") 
	private WebElement empStatus;
	@FindBy(xpath="//a[normalize-space()='Job Categories']") 
	private WebElement jobCategory;
	@FindBy(xpath="//a[normalize-space()='Work Shifts']") 
	private WebElement workShift;



	public Admin_JobPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	@Override
	public boolean checkFocus() {

		return false;
	}
}
