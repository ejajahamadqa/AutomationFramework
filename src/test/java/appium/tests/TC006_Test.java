package appium.tests;

import appium.pages.TC001_Page;
import appium.pages.TC006_Page;
import org.testng.annotations.Test;
import utils.AppiumBaseClass;

public class TC006_Test extends AppiumBaseClass {

    @Test
    public void testCaseSix() throws InterruptedException {

        tc001_page = new TC001_Page(androidDriver);
        tc006_page = new TC006_Page(androidDriver);

        tc001_page.displayToastButton().click();
        tc006_page.toastMessage("Hello selendroid toast!");

    }
}
