package com.elektrago.pages.signup;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class SignUpPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_email")
    @iOSXCUITFindBy(accessibility = "Registration")
    public WebElement inputEmail;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/relativeLayout")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"+1\"`]")
    private WebElement optionMobileCode;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_phone")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"123 456 7890\"`]")
    public WebElement inputMobileNumber;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/accept_terms_text_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"uniteller_powered_logo\"]/preceding-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton")
    private WebElement linkLegalDocuments;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    public WebElement btnContinue;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/sign_in_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"uniteller_powered_logo\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeButton")
    private WebElement linkLoginHere;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"You already have an Elektrago account\"]")
    private WebElement textAccountExists;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Later\"]")
    private WebElement btnLater;

    public SignUpPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateSignupPage() {
        BaseUtils.waitUntilElementisPresent(inputEmail);
        Assert.isTrue(inputEmail.isDisplayed(), "Element is not present");
    }

    public void tapsOnContinue() {
        btnContinue.click();
    }

    public void validateAccountExists() {
        BaseUtils.waitUntilElementisPresent(textAccountExists);
        Assert.isTrue(textAccountExists.isDisplayed(), "Element is not present");
    }

    public void tapsOnLater() {
        BaseUtils.waitUntilElementisPresent(btnLater);
        BaseUtils.clickOnElement(btnLater);
    }
}
