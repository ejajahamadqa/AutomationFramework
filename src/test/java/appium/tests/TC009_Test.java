package appium.tests;

import appium.pages.TC001_Page;
import org.testng.annotations.Test;
import utils.AppiumBaseClass;

public class TC009_Test extends AppiumBaseClass {

    @Test
    public void testCaseNine() {
            tc001_page = new TC001_Page(androidDriver);

            tc001_page.unHandledExceptiponEditText().sendKeys("type");

            tc001_page.getHomeScreenTitle("");

    }
}
