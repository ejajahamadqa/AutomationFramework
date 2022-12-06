package selenium.tests;

import org.testng.annotations.Test;
import selenium.pages.DroppablePage;
import utils.SeleniumBaseClass;

public class DroppableTest extends SeleniumBaseClass {
	
	DroppablePage dropablePage;
	
	@Test
	public void droppable() {

		dropablePage = new DroppablePage(driver);
		dropablePage.waitForDroppablePage();
		dropablePage.clickOnDroppableElement();
		dropablePage.verifyTitleOfPage("Droppable | jQuery UI");
		dropablePage.switchToFrame();
		dropablePage.dragAndDrop();
		dropablePage.verifyDropped();
		dropablePage.switchToDefaultContent();

	}
}
