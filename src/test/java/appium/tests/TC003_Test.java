package appium.tests;

import appium.pages.Common_Page;
import appium.pages.TC001_Page;
import appium.pages.TC003_Page;
import listeners.RetryTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AppiumBaseClass;
import utils.ExcelReader;

import java.io.IOException;

public class TC003_Test extends AppiumBaseClass {

    @Test(dataProvider = "DataProvider",retryAnalyzer = RetryTest.class)
    public void testCaseThree(String ScreenTitle, String helloText, String textBox,
                              String textToVerify, String textBoxVerify	, String carNameVerify,
                              String expectedCarName) {
        tc001_page = new TC001_Page(androidDriver);
        tc003_page = new TC003_Page(androidDriver);
        common_page = new Common_Page(androidDriver);

        tc001_page.chromeButton().click();
        //tc001_page.getHomeScreenTitle(ScreenTitle);
        tc003_page.helloText(helloText);
        tc003_page.textBox().clear();
        tc003_page.textBox().sendKeys(textBox);
        tc003_page.preferredCarDD().click();
        tc003_page.clickOnMercedes().click();
        tc003_page.sendButton().click();
        tc003_page.textVerify(textToVerify);
        tc003_page.textVerifyNameAndCar(textBoxVerify,carNameVerify);
        tc003_page.link().click();
        Assert.assertEquals(tc003_page.preferredCarDD().getAttribute("text"),expectedCarName);
    }

    @DataProvider(name="DataProvider")
    public Object[][] dataProvider() throws IOException {
        String path = System.getProperty("user.dir")+"/src/test/java/resources/ExcelData.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        int totalRows= excelReader.getRowCount("TC003");
        int totalCols= excelReader.getCellCount("TC003",1);

        String data[][] = new String[totalRows][totalCols];
        for (int i=1; i<=totalRows; i++) {
            for (int j=0; j<totalCols; j++) {
                data[i-1][j] = excelReader.getData("TC003", i,j);
            }
        }
        return data;
    }
}
