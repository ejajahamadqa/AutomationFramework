package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommonMethods {

	WebDriver driver;

	public SeleniumCommonMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForWebElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void action(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().keyDown(Keys.COMMAND).build().perform();
	}
	
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public void dragAndDrop(WebElement source, WebElement destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).perform();
	}
}
