package com.elektrago.pages.reviewandsend;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ReviewAndSendPage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Send Now\"`]")
    public WebElement btnSendNow;

    public ReviewAndSendPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateReviewAndSendPage() {
        BaseUtils.waitUntilElementIsClickable(btnSendNow);
        Assert.isTrue(btnSendNow.isEnabled(), "Element is disabled");
    }

    public void tapsOnSendNowButton() {
        btnSendNow.click();
    }
}
