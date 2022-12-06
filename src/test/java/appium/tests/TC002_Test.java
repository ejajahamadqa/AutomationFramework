package appium.tests;

import appium.pages.TC001_Page;
import appium.pages.TC002_Page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AppiumBaseClass;
import utils.ExcelReader;

import java.io.IOException;

public class TC002_Test extends AppiumBaseClass {

    @Test(dataProvider="DataProvider")
    public void testCaseTwo(String title) {
        tc001_page = new TC001_Page(androidDriver);
        tc002_page = new TC002_Page(androidDriver);

        tc001_page.enButton().click();

        tc002_page.noButton().click();

        tc001_page.getHomeScreenTitle(title);
    }

    @DataProvider(name="DataProvider")
    public Object[][] dataProvider() throws IOException {
        String path = System.getProperty("user.dir")+"/src/test/java/resources/ExcelData.xlsx";
        ExcelReader excelReader = new ExcelReader(path);
        int totalRows= excelReader.getRowCount("TC002");
        int totalCols= excelReader.getCellCount("TC002",1);

        String data[][] = new String[totalRows][totalCols];
        for (int i=1; i<=totalRows; i++) {
            for (int j=0; j<totalCols; j++) {
                data[i-1][j] = excelReader.getData("TC002", i,j);
            }
        }
        return data;
    }
}
