package com.elektrago.pages.profile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilePage {
    
    //Elementos Menu Perfil

    @AndroidFindBy(id= "com.elektrago.elektrago:id/item_personal_info")
    public WebElement myprofileOptionbtn;

    @AndroidFindBy(id="com.elektrago.elektrago:id/item_payment_methods")
    public WebElement paymentMethodsbtn;

    @AndroidFindBy(id="com.elektrago.elektrago:id/item_settings")
    public WebElement settingsbtn;

    @AndroidFindBy(id="com.elektrago.elektrago:id/item_help")
    public WebElement helpbtn;
    
    @AndroidFindBy(id="com.elektrago.elektrago:id/item_disclosures")
    public WebElement disclosurebtn;

    //Elementos Menu Perfil

    //Informacion de Perfil

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.elektrago.elektrago:id/button_edit\").instance(0)")
    public WebElement editPhoneNumber;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.elektrago.elektrago:id/button_edit\").instance(1)")
    public WebElement editEmail;
    
    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_got_it")
    public WebElement btnCallNow;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_later")
    public WebElement btnLater;

    //Informacion de Perfil
    
    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }
    
}
