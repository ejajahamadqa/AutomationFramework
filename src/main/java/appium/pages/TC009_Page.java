package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC009_Page {

    private AndroidDriver androidDriver;

    public TC009_Page(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(xpath = "//*[@class='android.widget.Toast']")
    WebElement toast_Message;

    public void toastMessage(String toastMessage) {
        WebDriverWait wait = new WebDriverWait(androidDriver,20);
        wait.until(ExpectedConditions.visibilityOf(toast_Message));
        Assert.assertEquals(toast_Message.getText(), toastMessage);
    }

}
