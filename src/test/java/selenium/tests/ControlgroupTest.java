package selenium.tests;

import org.testng.annotations.Test;
import selenium.pages.ControlgroupPage;
import utils.SeleniumBaseClass;

public class ControlgroupTest extends SeleniumBaseClass {

	ControlgroupPage controlPage;

	@Test
	public void controlGroup() {

		controlPage = new ControlgroupPage(driver);
		controlPage.waitForControlPage();
		controlPage.clickOnControlGroupElement();
		controlPage.verifyTitleOfPage("Controlgroup | jQuery UI");
		controlPage.switchToFrame();
		controlPage.waitForElement();
		controlPage.clickElements();
		controlPage.switchToDefaultContent();

	}
}
