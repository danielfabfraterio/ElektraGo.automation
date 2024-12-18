package com.elektrago.pages.cover;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class CoverPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/logo_img")
    public WebElement logoElektraGo;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/title")
    public WebElement txtTitle;

    @AndroidBy(id= "com.elektrago.elektrago:id/loginBtn")
    public WebElement btnSignUpLogIn;

    @AndroidBy(id = "com.elektrago.elektrago:id/explore_app_btn")
    public WebElement btnExploreApp;

    public CoverPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void validationCoverPage(){
        logoElektraGo.isDisplayed();
        txtTitle.isDisplayed();
        btnSignUpLogIn.isDisplayed();
        btnExploreApp.isDisplayed();
    }
}
