package appium.tests;

import appium.pages.TC001_Page;
import appium.pages.TC007_Page;
import org.testng.annotations.Test;
import utils.AppiumBaseClass;

public class TC007_Test extends AppiumBaseClass {

    @Test
    public void testCaseSeven() {

        tc001_page = new TC001_Page(androidDriver);
        tc007_page = new TC007_Page(androidDriver);

        tc001_page.displayPopUpWindowButton().click();
        tc007_page.closeAlert();

    }
}
