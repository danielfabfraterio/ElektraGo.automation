package com.elektrago.pages.profile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProfilePage {
    
    //Elementos Menu Perfil

    @AndroidFindBy(id= "com.elektrago.elektrago:id/item_personal_info")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"ic_personal_info_red\"]/parent::XCUIElementTypeOther")
    public WebElement myprofileOptionbtn;

    @AndroidFindBy(id="com.elektrago.elektrago:id/item_payment_methods")
    @iOSXCUITFindBy(xpath="(//XCUIElementTypeImage[@name=\"ic_settings_red\"])[1]/parent::XCUIElementTypeOther")
    public WebElement paymentMethodsbtn;

    @AndroidFindBy(id="com.elektrago.elektrago:id/item_settings")
    @iOSXCUITFindBy(xpath="(//XCUIElementTypeImage[@name=\"ic_settings_red\"])[2]/parent::XCUIElementTypeOther")
    public WebElement settingsbtn;

    @AndroidFindBy(id="com.elektrago.elektrago:id/item_help")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"ic_help_red\"]/parent::XCUIElementTypeOther")
    public WebElement helpbtn;
    
    @AndroidFindBy(id="com.elektrago.elektrago:id/item_disclosures")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeImage[@name=\"ic_disclosures_red\"]/parent::XCUIElementTypeOther")
    public WebElement disclosurebtn;

    //Elementos Menu Perfil

    //Informacion de Perfil

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.elektrago.elektrago:id/button_edit\").instance(0)")
    @iOSXCUITFindBy(xpath="(//XCUIElementTypeButton[@name=\"Edit\"])[1]")
    public WebElement editPhoneNumber;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.elektrago.elektrago:id/button_edit\").instance(1)")
    @iOSXCUITFindBy(xpath="(//XCUIElementTypeButton[@name=\"Edit\"])[2]")
    public WebElement editEmail;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.elektrago.elektrago:id/button_edit\").instance(2)")
    @iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Password\"]/following-sibling::XCUIElementTypeButton")
    public WebElement editPasswd;
    
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_got_it")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Call now\"`]")
    public WebElement btnCallNow;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_later")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Later\"`]")
    public WebElement btnLater;

    //Informacion de Perfil
    
    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }
    
}
