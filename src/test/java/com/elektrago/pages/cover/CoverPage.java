package com.elektrago.pages.cover;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class CoverPage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/logo_img")
    @iOSXCUITFindBy(accessibility = "img_logo_elektrago_white")
    public WebElement logoElektraGo;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"img_logo_elektrago_white\"]/following-sibling::XCUIElementTypeStaticText")
    public WebElement txtTitle;

    @AndroidBy(xpath= "com.elektrago.elektrago:id/loginBtn")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Log in or Sign up\"`]")
    public WebElement btnSignUpLogIn;

    @AndroidBy(id = "com.elektrago.elektrago:id/explore_app_btn")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Explore the app\"`]")
    public WebElement btnExploreApp;

    public CoverPage(String platform){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validationCoverPage(){
        BaseUtils.waitUntilElementisPresent(logoElektraGo);
        Assert.isTrue(logoElektraGo.isDisplayed(), "Element is not present");
        BaseUtils.waitUntilElementisPresent(txtTitle);
        Assert.isTrue(txtTitle.isDisplayed(),"Element is not present");
        BaseUtils.waitUntilElementisPresent(btnSignUpLogIn);
        Assert.isTrue(btnSignUpLogIn.isDisplayed(),"Element is not present");
        BaseUtils.waitUntilElementisPresent(btnExploreApp);
        Assert.isTrue(btnExploreApp.isDisplayed(),"Element is not present");
    }

    public void tapOnSignupLogin(){
        btnSignUpLogIn.click();
    }
}
