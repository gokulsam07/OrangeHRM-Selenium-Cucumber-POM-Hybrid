package pageobjects.adminModule;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin_CorporateBrandingPage implements IAdmin{

	WebDriver driver;




	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']/h6[1]") 
	private WebElement moduleName;
	@FindBy(css=".oxd-topbar-header") 
	private WebElement headerColor;
	@FindBy(css=".oxd-topbar-body-nav-tab.--visited") 
	private WebElement corpBrandingOption;


	//Color related #3703f4 -blue
	@FindBy(css="div[class='oxd-grid-item oxd-grid-item--gutters'] div[class='oxd-color-input-preview']") 
	private WebElement primaryColorPreview;
	@FindBy(css="div[class='oxd-grid-item oxd-grid-item--gutters --offset-row-2'] div[class='oxd-color-input-preview']") 
	private WebElement primaryFontColor;
	@FindBy(css="div[type='color'] div[class='oxd-color-input-preview']") 
	private WebElement primaryGradientColor1;
	@FindBy(css="div[class='oxd-grid-item oxd-grid-item--gutters --offset-row-3 --offset-column-3'] div[class='oxd-color-input-preview']") 
	private WebElement primaryGradientColor2;
	@FindBy(css="div[class='oxd-grid-item oxd-grid-item--gutters --offset-column-3'] div[class='oxd-color-input-preview']") 
	private WebElement secColorPreview;
	@FindBy(css="div[class='oxd-grid-item oxd-grid-item--gutters --offset-row-2 --offset-column-3'] div[class='oxd-color-input-preview']") 
	private WebElement secFontColor;


	@FindBy(css="div[role='alert'] input[class='oxd-input oxd-input--active']") 
	private WebElement colorInputActive;
	@FindBy(css="div[role='alert'] input[class='oxd-input oxd-input--focus']") 
	private WebElement colorInputFocus;


	//Buttons

	@FindBy(xpath="//button[normalize-space()='Reset to Default']") 
	private WebElement resetDefault;
	@FindBy(xpath="//button[normalize-space()='Preview']") 
	private WebElement preview;
	@FindBy(xpath="//button[normalize-space()='Publish']") 
	private WebElement publish;

	public Admin_CorporateBrandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	public boolean verifyDefaultColor() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(primaryColorPreview));
	
		if(headerColor.getCssValue("background-image").contains("linear-gradient(90deg, rgb(255, 146, 11), rgb(243, 92, 23) 90%)")) {
			return true;
		}
		return false;
	}

	public boolean modifyColorsAndVerifyPreview() throws InterruptedException {

		primaryColorPreview.click();
		colorInputActive.sendKeys("A");
		colorInputFocus.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.chord(Keys.CONTROL, "x")); 
		colorInputFocus.sendKeys("#021bf8",Keys.ENTER); //blue 
		Thread.sleep(1000);


		secColorPreview.click();
		colorInputActive.sendKeys("A");
		colorInputFocus.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.chord(Keys.CONTROL, "x"));
		colorInputFocus.sendKeys("#aaf605",Keys.ENTER);  //luminescent green
		Thread.sleep(1000);

		primaryFontColor.click();
		colorInputActive.sendKeys("A");
		colorInputFocus.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.chord(Keys.CONTROL, "x"));
		colorInputFocus.sendKeys("#070707",Keys.ENTER); //black
		Thread.sleep(1000);

		secFontColor.click();
		colorInputActive.sendKeys("A");
		colorInputFocus.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.chord(Keys.CONTROL, "x"));
		colorInputFocus.sendKeys("#fe0101",Keys.ENTER); //red
		Thread.sleep(1000);

		preview.click();

		if(headerColor.getCssValue("background-image").contains("linear-gradient(90deg, rgb(255, 146, 11), rgb(243, 92, 23) 90%)")
				&&moduleName.getCssValue("color").contains("rgba(255, 255, 255, 1)")
				&&corpBrandingOption.getCssValue("color").contains("rgba(255, 123, 29, 1)")
				&&publish.getCssValue("color").contains("rgba(255, 255, 255, 1)")
				&&publish.getCssValue("background-color").contains("rgba(118, 188, 33, 1)")) {
			return true; 
		}
		return false;
	}



	public boolean modifyColorsAndVerifyReset(){
		resetDefault.click();
		if(verifyDefaultColor()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkFocus() {
		return moduleName.isDisplayed();
	}

}
