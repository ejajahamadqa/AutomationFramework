package utils;

import appium.pages.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class AppiumBaseClass {

    public Properties prop;
    public FileInputStream fis;
    public AndroidDriver androidDriver;
    protected TC001_Page tc001_page;
    protected TC002_Page tc002_page;
    protected TC003_Page tc003_page;
    protected TC004_Page tc004_page;
    protected TC005_Page tc005_page;
    protected TC006_Page tc006_page;
    protected TC007_Page tc007_page;
    protected Common_Page common_page;

    @BeforeClass
    public void initializer() throws IOException {

        prop = new Properties();
        fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/appium.properties");
        prop.load(fis);

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("deviceName", prop.getProperty("deviceName"));
            capabilities.setCapability("platformName", prop.getProperty("platformName"));
            capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
            capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
            capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
            capabilities.setCapability("automationName", prop.getProperty("automationName"));
            capabilities.setCapability("app", System.getProperty("user.dir")+prop.getProperty("applicationpath"));

            androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723"), capabilities);

            if (androidDriver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).isDisplayed()) {

                AppiumCommonMethods.explicitWait(androidDriver,androidDriver.findElement(By.id("com.android.permissioncontroller:id/continue_button")));
                androidDriver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();

                AppiumCommonMethods.explicitWait(androidDriver);
                androidDriver.switchTo().alert().accept();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getScreenShot(String testCaseName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot)androidDriver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
        FileUtils.copyFile(source,file);
        return System.getProperty(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
    }

    @AfterClass
    public void teardown() {
        if (androidDriver != null) {
            tc001_page = null;
            tc002_page = null;
            tc003_page = null;
            tc004_page = null;
            tc005_page = null;
            tc006_page = null;
            tc007_page = null;
            common_page = null;
            androidDriver.quit();
        }
    }
}
