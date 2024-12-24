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

    @iOSXCUITFindBy(accessibility = "usernameTextfield")
    public WebElement inputEmail;

    @iOSXCUITFindBy(accessibility = "Use mobile number instead")
    public WebElement btnNumberInstead;

    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    public WebElement inputPasswd;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Forgot password\"`]")
    public WebElement btnForgotPasswd;

    @iOSXCUITFindBy(accessibility = "arrow down icon")
    public WebElement dropDownMobileCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"+52\")]")
    public WebElement mexicanCodeNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"+1\")]")
    public WebElement americanCodeNumber;

    @iOSXCUITFindBy(accessibility = "usernameTextfield")
    public WebElement inputMobileNumber;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Login\"`]")
    public WebElement btnLogin;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`][1]")
    public static WebElement btnDoneKeyboard;

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
