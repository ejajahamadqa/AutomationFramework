package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AppiumCommonMethods;

public class TC006_Page {

    public AppiumCommonMethods appiumCommonMethods = new AppiumCommonMethods();
    private AndroidDriver androidDriver;

    public TC006_Page(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(xpath = "//android.widget.Toast")
    WebElement toast_Message;


    public void toastMessage(String toastMessage) {
        Assert.assertEquals(toast_Message.getText(), toastMessage);
    }
}
