package com.elektrago.pages.changepasswd;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ChangePassword {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_current_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField[1]")
    public WebElement inputCurrentPasswd;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField[2]")
    public WebElement inputNewPasswd;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_confirm")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField[3]")
    public WebElement inputConfirmPasswd;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/change_button")
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`name == \"Change\"`]")
    public WebElement btnChange;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/pass_text")
    @iOSXCUITFindBy(accessibility="**/XCUIElementTypeStaticText[`name == \"this password has already been used\"`]")
    public WebElement txtPasswdUsed;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_login")
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`name == \"Try again\"`]")
    public WebElement btnTryAgain;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/error_indicator")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"ic_alert_info_red\"]/following-sibling::XCUIElementTypeStaticText")
    public WebElement lblPasswdsNotMatch;

    //Success password Updated
    
    @AndroidFindBy(id = "com.elektrago.elektrago:id/image_pass")
    @iOSXCUITFindBy(accessibility="img_password_updated")
    public WebElement imgUpdated;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_login")
    @iOSXCUITFindBy(className = "XCUIElementTypeButton")
    public WebElement btnGotoMyProfile;

    public ChangePassword() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }
}
