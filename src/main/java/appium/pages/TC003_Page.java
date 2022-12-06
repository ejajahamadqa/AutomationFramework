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

public class TC003_Page {

    private AndroidDriver androidDriver;
    public AppiumCommonMethods appiumCommonMethods = new AppiumCommonMethods();

    public TC003_Page(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(id = "android:id/title")
    WebElement title;

    @FindBy(xpath = "//android.widget.TextView[@text='Hello, can you please tell me your name?']")
    WebElement hello_Text;

    @FindBy(xpath="//android.widget.EditText[@resource-id='name_input']")
    WebElement textbox;

    @FindBy(xpath = "//android.view.View[@text='Volvo']")
    WebElement preferred_Car_DD;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    WebElement click_On_Mercedes;

    @FindBy(xpath = "//android.widget.Button[@text='Send me your name!']")
    WebElement send_Button;

    @FindBy(xpath = "//android.view.View[@text='This is my way of saying hello']")
    WebElement text;

    @FindBy(xpath = "//android.widget.TextView[@text='\"Ejaj\"']")
    WebElement verify_Name;

    @FindBy(xpath = "//android.widget.TextView[@text='\"mercedes\"']")
    WebElement verify_Car;

    @FindBy(xpath = "//android.widget.TextView[@text='here']")
    WebElement link;

    public void getTitle(String screenTitle) {
        appiumCommonMethods.explicitWait(androidDriver,title);
        Assert.assertEquals(title.getAttribute("text"),screenTitle);
    }

    public void helloText(String text) {
        appiumCommonMethods.explicitWait(androidDriver,hello_Text);
        Assert.assertEquals(hello_Text.getAttribute("text"),text);
    }

    public WebElement textBox() {
        appiumCommonMethods.explicitWait(androidDriver,textbox);
        return textbox;
    }

    public WebElement preferredCarDD() {
        appiumCommonMethods.explicitWait(androidDriver,preferred_Car_DD);
        return preferred_Car_DD;
    }

    public WebElement clickOnMercedes() {
        appiumCommonMethods.explicitWait(androidDriver,click_On_Mercedes);
        return click_On_Mercedes;
    }

    public WebElement sendButton() {
        appiumCommonMethods.explicitWait(androidDriver,send_Button);
        return send_Button;
    }

    public void textVerify(String expectedText) {
        appiumCommonMethods.explicitWait(androidDriver,text);
        Assert.assertEquals(text.getAttribute("text"), expectedText);
    }

    public void textVerifyNameAndCar(String name, String car) {
        appiumCommonMethods.explicitWait(androidDriver,verify_Name);
        Assert.assertEquals(verify_Name.getAttribute("text"), name);
        Assert.assertEquals(verify_Car.getAttribute("text"), car);
    }

    public WebElement link() {
        appiumCommonMethods.explicitWait(androidDriver,link);
        return link;
    }


}
