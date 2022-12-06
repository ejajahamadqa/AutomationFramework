package appium.tests;

import appium.pages.TC001_Page;
import org.testng.annotations.Test;
import utils.AppiumBaseClass;

public class TC008_Test extends AppiumBaseClass {

    @Test
    public void testCaseEight() {

            tc001_page = new TC001_Page(androidDriver);

            tc001_page.unHandledExceptiponButton().click();

            tc001_page.getHomeScreenTitle("");
    }
}
