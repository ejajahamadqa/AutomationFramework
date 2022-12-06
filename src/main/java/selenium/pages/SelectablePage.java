package selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.SeleniumCommonMethods;

public class SelectablePage extends SeleniumCommonMethods {

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Selectable']")
	WebElement selectable;

	@FindBy(xpath = "//li[@class='ui-widget-content ui-selectee']")
	List<WebElement> itemList;

	public SelectablePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void verifyTitleOfPage(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}

	public void waitForSelectablePage() {
		waitForWebElementToBeClickable(selectable);
	}

	public void switchToFrame() {
		driver.switchTo().frame(0);
	}

	public void clickOnSelectableElement() {
		selectable.click();
	}

	public void selectItems() {

		for (int i = 0; i <= itemList.size(); i++) {

			if (itemList.get(i).getText().equalsIgnoreCase("Item 1")
					|| itemList.get(i).getText().equalsIgnoreCase("Item 3")
					|| itemList.get(i).getText().equalsIgnoreCase("Item 7")) {

				action(itemList.get(i));
			}
		}

	}

	public void verifyItemsClicked() {
		Assert.assertEquals(
				driver.findElements(By.xpath("//li[@class='ui-widget-content ui-selectee ui-selected']")).size(), 3);
	}

	public void switchToDefault() {
		switchToDefaultContent();
	}

}
