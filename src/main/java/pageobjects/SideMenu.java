package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenu {
	WebDriver driver;

	@FindBy(css="input[placeholder='Search']")
	private WebElement search;

	@FindBy(css="button[role='none']")
	private WebElement toggle;

	@FindBy(xpath="//a[contains(@href, 'admin')]")
	private WebElement admin;

	@FindBy(css="//a[contains(@href, 'MyDetails')]")
	private WebElement myInfo;

	@FindBy(css="//a[contains(@href, 'dashboard')]")
	private WebElement dashboard;

	@FindBy(css="//a[contains(@href, 'RecruitmentModule')]")
	private WebElement recruitmentModule;


	public  SideMenu(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
