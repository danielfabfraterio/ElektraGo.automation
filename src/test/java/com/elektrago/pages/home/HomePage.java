package com.elektrago.pages.home;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;



public class HomePage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"$0.00\"`]")
    public WebElement inputSendAmount;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Let's send!\"`]")
    public WebElement btnLetsSend;

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateHomePage() {
        BaseUtils.waitUntilElementisPresent(inputSendAmount);
        Assert.isTrue(inputSendAmount.isDisplayed(), "Element is not present");
    }

    public void tapsOnLetsSend(){
        BaseUtils.waitUntilElementIsClickable(btnLetsSend);
        btnLetsSend.click();
//        BaseUtils.clickOnElement(btnLetsSend);
    }
}
