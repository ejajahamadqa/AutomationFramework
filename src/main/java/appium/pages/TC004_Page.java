package appium.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.AppiumCommonMethods;

public class TC004_Page {

    private AndroidDriver androidDriver;
    public AppiumCommonMethods appiumCommonMethods = new AppiumCommonMethods();

    public TC004_Page(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(androidDriver, this);
    }

    @FindBy(xpath = "//*[@class='android.widget.TextView']")
    WebElement verify_Title;

    @FindBy(id = "inputUsername")
    WebElement user_Name;

    @FindBy(id = "inputEmail")
    WebElement input_Email;

    @FindBy(id = "inputPassword")
    WebElement input_Password;

    @FindBy(id = "inputName")
    WebElement input_Name;

    @FindBy(id = "input_preferedProgrammingLanguage")
    WebElement input_Prefered_Programming_Language;

    @FindBy(id = "input_adds")
    WebElement input_Adds;

    @FindBy(id = "btnRegisterUser")
    WebElement btn_Register_User;

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Ruby']")
    WebElement drop_Down;

    @FindBy(id="label_username_data")
    WebElement lable_UserName;

    @FindBy(id="label_email_data")
    WebElement label_Email_Data;

    @FindBy(id="label_password_data")
    WebElement label_Password_Data;

    @FindBy(id="label_name_data")
    WebElement label_Name_Data;

    @FindBy(id="label_preferedProgrammingLanguage_data")
    WebElement label_Prefered_Programming_Language_Data;

    @FindBy(id="label_acceptAdds_data")
    WebElement label_AcceptAdds_Data;

    @FindBy(id="buttonRegisterUser")
    WebElement button_Register_User;

    public void verifyTitle() {
        appiumCommonMethods.explicitWait(androidDriver,verify_Title);
        Assert.assertEquals(verify_Title.getText(),"");
    }

    public WebElement userName() {
        appiumCommonMethods.explicitWait(androidDriver,user_Name);
        return user_Name;
    }

    public WebElement inputEmail() {
        return input_Email;
    }

    public WebElement inputPassword() {
        return input_Password;
    }

    public WebElement inputName() {
        return input_Name;
    }

    public WebElement inputPreferedProgrammingLanguage() {
        return input_Prefered_Programming_Language;
    }

    public WebElement inputAdds() {
        return input_Adds;
    }

    public WebElement btnRegisterUser() {
        androidDriver.hideKeyboard();
        appiumCommonMethods.explicitWait(androidDriver,btn_Register_User);
        return btn_Register_User;
    }

    public WebElement dropDown() {
        appiumCommonMethods.explicitWait(androidDriver,drop_Down);
        return drop_Down;
    }

    public void lableUserName(String name) {
        appiumCommonMethods.explicitWait(androidDriver,lable_UserName);
        Assert.assertEquals(lable_UserName.getText(),name);
    }

    public void labelEmailData(String email) {
        appiumCommonMethods.explicitWait(androidDriver,label_Email_Data);
        Assert.assertEquals(label_Email_Data.getText(),email);
    }

    public void labelPasswordData(String password) {
        Assert.assertEquals(label_Password_Data.getText(),password);
    }

    public void labelPreferedProgrammingLanguage(String value) {
        Assert.assertEquals(label_Prefered_Programming_Language_Data.getText(),value);
    }

    public void labelPreferedProgrammingLanguageData(String value) {
        System.out.println("Language:- "+label_Prefered_Programming_Language_Data.getText());
                Assert.assertEquals(label_Prefered_Programming_Language_Data.getText(),value);
    }

    public void labelAcceptAddsData(String value) {
        Assert.assertEquals(label_AcceptAdds_Data.getText(),value);
    }

    public WebElement buttonRegisterUser() {
        return button_Register_User;
    }

}
