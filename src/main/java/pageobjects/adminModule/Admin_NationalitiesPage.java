package pageobjects.adminModule;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin_NationalitiesPage implements IAdmin {
	WebDriver driver;
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[1]") 
	private WebElement moduleName;
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[2]") 
	private WebElement optionName;
	@FindBy(css="span[class='oxd-text oxd-text--span']") 
	private WebElement recordCountry;
	@FindBy(xpath="(//div[@class='orangehrm-container']//div[@class='oxd-table-card']//div[@class='oxd-table-cell oxd-padding-cell'][2]/div)") 
	private List<WebElement> countryName;

	@FindBy(css=".oxd-icon.bi-chevron-right") 
	private WebElement pageNext;
	@FindBy(xpath="//div[@class='oxd-layout-container']//li//i[@class='oxd-icon bi-chevron-right']/ancestor::nav[@role='navigation']/descendant::li[last()-1]/button") 
	private WebElement extractLastPageNo;

	@FindBy(xpath="//button[normalize-space()='Add']") 
	private WebElement add;


	List<WebElement> finalList = new ArrayList<WebElement>();
	int size;

	public Admin_NationalitiesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@Override
	public boolean checkFocus() {
		return	moduleName.getText().contains("Admin");

	}

	public boolean checkIfAllCountriesArePresent() {
		//If page size is 1
		try {
			size = Integer.valueOf(extractLastPageNo.getText()).intValue();
		} catch (Exception e) {
			size=1;
		}


		while(size>1) {
			if(!(extractLastPageNo.getCssValue("background-color").equals("rgba(241 242 245 1)"))) {
				finalList.addAll(countryName);
				size--;
				pageNext.click();
			}
		}finalList.addAll(countryName);

		String str = recordCountry.getText();
		String sizeFinal = Integer.toString(finalList.size());

		if(str.substring(str.indexOf("(") + 1, str.indexOf(")")).trim().equals(sizeFinal)) {
			return true;
		}
		else return false;

	}

	public Admin_AddNationalityPage addCountry() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(add));
		add.click();
		return new Admin_AddNationalityPage(driver);
	}

	public boolean verifyAddedCountry() {
		for (WebElement country : countryName) {
			if(country.getText().equals("A")){
				return true;
			}
		}
		return false;
	}
}
