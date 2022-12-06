package selenium.tests;

import org.testng.annotations.Test;
import selenium.pages.SelectablePage;
import utils.SeleniumBaseClass;

public class SelectableTest extends SeleniumBaseClass {

	SelectablePage  selectable;
	
	@Test
	public void selectable() {
		
		selectable = new SelectablePage(driver);
		selectable.waitForSelectablePage();
		selectable.clickOnSelectableElement();
		selectable.verifyTitleOfPage("Selectable | jQuery UI");
		selectable.switchToFrame();
		selectable.selectItems();
		selectable.verifyItemsClicked();
		selectable.switchToDefaultContent();
		
	}
}
