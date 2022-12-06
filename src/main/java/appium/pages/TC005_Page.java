package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AppiumCommonMethods;

public class TC005_Page {

    public AppiumCommonMethods appiumCommonMethods = new AppiumCommonMethods();
    private AndroidDriver androidDriver;

    public TC005_Page(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(id = "android:id/progress")
    WebElement loader;


    public WebElement loader() {
        appiumCommonMethods.explicitWait(androidDriver,loader);
        return loader;
    }

}
