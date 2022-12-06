package appium.tests;

import appium.pages.TC001_Page;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AppiumBaseClass;
import utils.ExcelReader;

import java.io.IOException;

public class TC001_Test extends AppiumBaseClass {

    @Test(dataProvider="DataProvider")
    public void verifyTheHomeScreenElements(String title) {

        tc001_page = new TC001_Page(androidDriver);

        tc001_page.getHomeScreenTitle(title);
        Assert.assertTrue(tc001_page.helloText().isDisplayed());
        Assert.assertTrue(tc001_page.localizationText().isDisplayed());
        Assert.assertTrue(tc001_page.enButton().isDisplayed());
        Assert.assertTrue(tc001_page.chromeButton().isDisplayed());
        Assert.assertTrue(tc001_page.fileButton().isDisplayed());
        Assert.assertTrue(tc001_page.editText().isDisplayed());
        Assert.assertTrue(tc001_page.showProgressBarButton().isDisplayed());
        Assert.assertTrue(tc001_page.acceptCheckBox().isDisplayed());
        Assert.assertTrue(tc001_page.displayTextViewButton().isDisplayed());
        Assert.assertTrue(tc001_page.displayToastButton().isDisplayed());
        Assert.assertTrue(tc001_page.displayPopUpWindowButton().isDisplayed());
        Assert.assertTrue(tc001_page.unHandledExceptiponButton().isDisplayed());
        Assert.assertTrue(tc001_page.unHandledExceptiponEditText().isDisplayed());
        Assert.assertTrue(tc001_page.encodedText().isDisplayed());
        Assert.assertTrue(tc001_page.layoutButton().isDisplayed());
    }

    @DataProvider(name="DataProvider")
    public Object[][] dataProvider() throws IOException {
        String path = System.getProperty("user.dir")+"/src/test/java/resources/ExcelData.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        int totalRows= excelReader.getRowCount("TC001");
        int totalCols= excelReader.getCellCount("TC001",1);

        String data[][] = new String[totalRows][totalCols];
        for (int i=1; i<=totalRows; i++) {
            for (int j=0; j<totalCols; j++) {
                data[i-1][j] = excelReader.getData("TC001", i,j);
            }
        }
        return data;
    }

}
