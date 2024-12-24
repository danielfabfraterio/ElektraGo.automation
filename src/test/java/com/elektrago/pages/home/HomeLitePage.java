package com.elektrago.pages.home;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class HomeLitePage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Welcome Francisco!\"`]")
    private WebElement txtWelcomeUser;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeImage")
    private WebElement imgProfile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"card_contactless\"]/parent::XCUIElementTypeOther")
    private WebElement imgBannerGetElektraGo;

    public HomeLitePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()),this);
    }

    public void validateHomeLite(){
        BaseUtils.waitUntilElementisPresent(txtWelcomeUser);
        Assert.isTrue(txtWelcomeUser.isDisplayed(),"Element is not present");
        BaseUtils.waitUntilElementisPresent(imgProfile);
        Assert.isTrue(imgProfile.isDisplayed(),"Element is not present");
        BaseUtils.waitUntilElementisPresent(imgBannerGetElektraGo);
        Assert.isTrue(imgBannerGetElektraGo.isDisplayed(),"Element is not present");
    }

}
