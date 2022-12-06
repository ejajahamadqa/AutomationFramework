package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC002_Page {

    private AndroidDriver androidDriver;

    public TC002_Page(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
    WebElement no_Button;


    public WebElement noButton() {
        WebDriverWait wait = new WebDriverWait(androidDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(no_Button));
        return no_Button;
    }


}
