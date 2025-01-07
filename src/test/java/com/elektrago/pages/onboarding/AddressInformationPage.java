package com.elektrago.pages.onboarding;

import com.elektrago.utils.AppiumDriverFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class AddressInformationPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/auto_address")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Street address\"`]")
    public WebElement inputStreetAddress;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_apartment")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Apt. / Suite\"`]")
    public WebElement inputAptSuite;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_city")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"City\"`]")
    public WebElement inputCity;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_state")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"State\"`]")
    public WebElement inputState;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/input_zip")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Zip code\"`]")
    public WebElement inputZipCode;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    public WebElement btnContinuar;

    public AddressInformationPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()),this);
    }
}
