package com.elektrago.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`]")
    public WebElement btnEnter;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_email")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`name == \"usernameTextfield\"`]")
    public WebElement inputEmail;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/switch_option_text")
    @iOSXCUITFindBy(accessibility = "Use mobile number instead")
    public WebElement btnUseMobileNumberInstead;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_password")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
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

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Continue\"`]")
    public WebElement btnContinue;

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateLoginPage() {
        BaseUtils.waitUntilElementisPresent(inputEmail);
        Assert.isTrue(inputEmail.isDisplayed(), "Element is not present");
        BaseUtils.waitUntilElementisPresent(btnUseMobileNumberInstead);
        Assert.isTrue(btnUseMobileNumberInstead.isDisplayed(), "Element is not present");
    }

    public void selectMobileCode(String mobileCode) {
        if (mobileCode.equals("+52")) {
            BaseUtils.clickOnElement(mexicanCodeNumber);
        } else {
            BaseUtils.clickOnElement(americanCodeNumber);
        }
    }

    public boolean validateIfPreviouslySignedUp() {
        BaseUtils.clickOnElement(LoginPage.btnDoneKeyboard);
        try {
            return btnUseMobileNumberInstead.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void tapsOnContinue() {
        BaseUtils.clickOnElement(btnContinue);
    }

}
