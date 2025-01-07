package com.elektrago.pages.onboarding;

import com.elektrago.utils.AppiumDriverFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class GeneralInformationPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"First name\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField")
    public WebElement inputFirstName;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/middle_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Second name\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField")
    public WebElement inputSecondName;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_lastname")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"First last name\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField")
    public WebElement inputFirstLastName;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_second_lastname")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Second last name\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField")
    public WebElement inputSecondLastName;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_birth")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Date of birth\"`]")
    public WebElement btnDateOfBirth;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    public WebElement btnContinue;

    public GeneralInformationPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()),this);
    }
}
