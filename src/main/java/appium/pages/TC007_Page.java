package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AppiumCommonMethods;

public class TC007_Page {

    private AndroidDriver androidDriver;
    public AppiumCommonMethods appiumCommonMethods = new AppiumCommonMethods();

    public TC007_Page(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    public void closeAlert() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 20);
        wait.until(ExpectedConditions.alertIsPresent());
        androidDriver.switchTo().alert().dismiss();
    }

}
