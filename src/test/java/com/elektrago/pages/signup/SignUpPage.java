package com.elektrago.pages.signup;

import com.elektrago.utils.AppiumDriverFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class SignUpPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_email")
    @iOSXCUITFindBy(accessibility = "Registration")
    private WebElement inputEmail;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/relativeLayout")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"+1\"`]")
    private WebElement optionMobileCode;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_phone")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"123 456 7890\"`]")
    private WebElement inputMobileNumber;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/accept_terms_text_view")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"uniteller_powered_logo\"]/preceding-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton")
    private WebElement linkLegalDocuments;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_continue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"uniteller_powered_logo\"]/following-sibling::XCUIElementTypeButton")
    private WebElement btnContinue;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/sign_in_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"uniteller_powered_logo\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeButton")
    private WebElement linkLoginHere;

    public SignUpPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }
}
