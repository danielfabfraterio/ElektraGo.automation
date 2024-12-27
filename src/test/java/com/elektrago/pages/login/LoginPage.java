package com.elektrago.pages.login;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class LoginPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_email")
    @iOSXCUITFindBy(accessibility = "usernameTextfield")
    public WebElement inputEmail;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/switch_option_text")
    @iOSXCUITFindBy(accessibility = "Use mobile number instead")
    public WebElement btnNumberInstead;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_password")
    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    public WebElement inputPasswd;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/text_forgot_password")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Forgot password\"`]")
    public WebElement btnForgotPasswd;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/relativeLayout")
    @iOSXCUITFindBy(accessibility = "arrow down icon")
    public WebElement dropDownMobileCode;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.elektrago.elektrago:id/tvLada\" and @text=\"+52\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"+52\")]")
    public WebElement mexicanCodeNumber;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.elektrago.elektrago:id/tvLada\" and @text=\"+1\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"+1\")]")
    public WebElement americanCodeNumber;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_phone")
    @iOSXCUITFindBy(accessibility = "usernameTextfield")
    public WebElement inputMobileNumber;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/textError")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"info_red_Icon\"]/following-sibling::XCUIElementTypeStaticText")
    public WebElement msgIncorrectuserNameOrPassENG;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Login\"`]")
    public WebElement btnLogin;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`][1]")
    public static WebElement btnDoneKeyboard;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/walletOrNotLink")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Sign up here\"`]")
    public WebElement SignUpHere;

    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateLoginPage(){
        BaseUtils.waitUntilElementisPresent(inputEmail);
        Assert.isTrue(inputEmail.isDisplayed(),"Element is not present");
        BaseUtils.waitUntilElementisPresent(btnNumberInstead);
        Assert.isTrue(btnNumberInstead.isDisplayed(),"Element is not present");
        BaseUtils.waitUntilElementisPresent(inputPasswd);
        Assert.isTrue(inputPasswd.isDisplayed(),"Element is not present");
        BaseUtils.waitUntilElementisPresent(btnForgotPasswd);
        Assert.isTrue(btnForgotPasswd.isDisplayed(),"Element is not present");
        BaseUtils.waitUntilElementisPresent(btnLogin);
        Assert.isTrue(btnLogin.isDisplayed(),"Element is not present");
    }

    public void selectMobileCode(String mobileCode){
        if (mobileCode.equals("+52")) {
            BaseUtils.clickOnElement(mexicanCodeNumber);
        } else {
            BaseUtils.clickOnElement(americanCodeNumber);
        }
    }

}
