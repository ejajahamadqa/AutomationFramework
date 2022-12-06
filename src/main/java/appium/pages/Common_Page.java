package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AppiumCommonMethods;

public class Common_Page {

    private AndroidDriver androidDriver;
    public AppiumCommonMethods appiumCommonMethods = new AppiumCommonMethods();

    public Common_Page(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='selendroid-test-app']")
    //@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.TextView")
    WebElement home_Screen_Title;

    public void getScreenTitle(String title) {
        appiumCommonMethods.explicitWait(androidDriver,home_Screen_Title);
        Assert.assertEquals(home_Screen_Title.getAttribute("id"),title);
    }

}
