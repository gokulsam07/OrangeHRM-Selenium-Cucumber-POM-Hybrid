package pageobjects.myInfoModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobsPage implements IMyInfo {
	WebDriver driver;
	@FindBy(linkText="Job")
	private WebElement job;

	@FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
	private WebElement title;

	public JobsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}





	@Override
	public boolean checkFocus() {
		return job.getCssValue("background-color").equals("rgb(246 245 251)");
	}

	public boolean verifyNotInteractable() {
		if(title.isEnabled()) {
			if(title.getText().contains("HR Manager")) {
				return true;
			}

		}
		return false;
	}

}
