package appium.tests;

import appium.pages.TC001_Page;
import appium.pages.TC004_Page;
import appium.pages.TC005_Page;
import org.testng.annotations.Test;
import utils.AppiumBaseClass;

public class TC005_Test extends AppiumBaseClass {

    @Test
    public void testCaseFive() {

        tc001_page = new TC001_Page(androidDriver);
        tc004_page = new TC004_Page(androidDriver);
        tc005_page = new TC005_Page(androidDriver);

        tc001_page.showProgressBarButton().click();

        tc005_page.loader();

        tc004_page.userName().isDisplayed();
        tc004_page.inputEmail().isDisplayed();
        tc004_page.inputPassword().isDisplayed();
        tc004_page.inputName().isDisplayed();
        tc004_page.inputPreferedProgrammingLanguage().isDisplayed();
        tc004_page.inputAdds().isDisplayed();
        tc004_page.btnRegisterUser().isDisplayed();

    }
}
