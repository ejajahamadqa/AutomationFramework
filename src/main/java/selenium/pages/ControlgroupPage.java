package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.SeleniumCommonMethods;


public class ControlgroupPage extends SeleniumCommonMethods {

	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Controlgroup']")
	WebElement controlgroup;
	
	@FindBy(xpath = "//label[@for='transmission-automatic']")
	WebElement transmission_automatic;
	
	@FindBy(xpath = "//label[@for='insurance']")
	WebElement insurance;
	
	@FindBy(xpath = "//label[@for='transmission-standard-v']")
	WebElement transmission_standard;
	
	@FindBy(xpath = "//label[@for='insurance-v']")
	WebElement insurance_v;

	@FindBy(xpath = "//label[@for='vertical-spinner']//following-sibling::span/a[contains(@class,'ui-spinner-up')]")
	WebElement spinner_up;
	
	@FindBy(xpath = "//button[@id='book']")
	WebElement book_button;

	public ControlgroupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void verifyTitleOfPage(String title) {
		Assert.assertEquals(driver.getTitle(),title);
	}

	public void waitForControlPage() {
		waitForWebElementToBeClickable(controlgroup);
	}
	
	public void switchToFrame() {
		driver.switchTo().frame(0);
	}
	
	public void clickOnControlGroupElement() {
		controlgroup.click();
	}
	
	public void clickElements() {
		transmission_automatic.click();
		insurance.click();
		transmission_standard.click();
		insurance_v.click();
		spinner_up.click();
		book_button.click();
	}
	
	public void waitForElement() {
		waitForWebElementToBeClickable(transmission_automatic);
	}
	

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
			
	
}
