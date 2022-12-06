package appium.tests;

import appium.pages.TC001_Page;
import appium.pages.TC004_Page;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AppiumBaseClass;
import utils.ExcelReader;

import java.io.IOException;

public class TC004_Test extends AppiumBaseClass {

    {
        tc004_page = new TC004_Page(androidDriver);
    }

    @Test(priority = 0)
    public void verifyTheElements() {

        tc001_page = new TC001_Page(androidDriver);
        tc004_page = new TC004_Page(androidDriver);

        tc001_page.fileButton().click();
        //tc004_page.verifyTitle();
        tc004_page.userName().isDisplayed();
        tc004_page.inputEmail().isDisplayed();
        tc004_page.inputPassword().isDisplayed();
        tc004_page.inputName().isDisplayed();
        tc004_page.inputPreferedProgrammingLanguage().isDisplayed();
        tc004_page.inputAdds().isDisplayed();
        tc004_page.btnRegisterUser().isDisplayed();

    }

    @Test(dataProvider = "DataProvider",priority = 1)
    public void verifyData(String inputName, String programmingLanguage, String userName, String email, String password) {
        Assert.assertEquals(tc004_page.inputName().getAttribute("text"), inputName);
        tc004_page.labelPreferedProgrammingLanguage(programmingLanguage);
    }

    @Test(dataProvider = "DataProvider",priority = 2)
    public void fillTheValues(String inputName, String programmingLanguage, String userName, String email, String password) {
        tc004_page.userName().sendKeys(userName);
        tc004_page.inputEmail().sendKeys(email);
        tc004_page.inputPassword().sendKeys(password);
        tc004_page.inputName().clear();
        tc004_page.inputName().sendKeys(inputName);
        tc004_page.inputPreferedProgrammingLanguage().click();
        tc004_page.dropDown().click();
    }

    @Test(priority = 3)
    public void clickOnCheckBox() {
        Assert.assertEquals(tc004_page.inputAdds().isSelected(), false);
        tc004_page.inputAdds().click();
    }

    @Test(priority = 4)
    public void clickOnRegister() {
        tc004_page.btnRegisterUser().click();
    }

    @Test(dataProvider = "DataProvider",priority = 5)
    public void verifyUserData(String inputName, String programmingLanguage, String userName, String email, String password) {
        tc004_page.lableUserName(userName);
        tc004_page.labelEmailData(email);
        tc004_page.labelPasswordData(password);
        tc004_page.labelPreferedProgrammingLanguageData(programmingLanguage);
        tc004_page.labelAcceptAddsData("true");
    }

    @Test(priority = 6)
    public void tapOnButtonRegister() {
        tc004_page.buttonRegisterUser().click();
    }

    @Test(priority = 7)
    public void verifyHomeScreen() {

    }

    @DataProvider(name="DataProvider")
    public Object[][] dataProvider() throws IOException {
        String path = System.getProperty("user.dir")+"/src/test/java/resources/ExcelData.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        int totalRows= excelReader.getRowCount("TC004");
        int totalCols= excelReader.getCellCount("TC004",1);

        String data[][] = new String[totalRows][totalCols];
        for (int i=1; i<=totalRows; i++) {
            for (int j=0; j<totalCols; j++) {
                data[i-1][j] = excelReader.getData("TC004", i,j);
            }
        }
        return data;
    }

}
