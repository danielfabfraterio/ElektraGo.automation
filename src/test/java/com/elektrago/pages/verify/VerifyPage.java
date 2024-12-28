package com.elektrago.pages.verify;

import com.elektrago.utils.AppiumDriverFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class VerifyPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_confirmation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Verify your email\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther")
    public WebElement inputVerificationCode;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/resendButton")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Resend\"`]")
    public WebElement btnResendCode;

    public VerifyPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }


}
