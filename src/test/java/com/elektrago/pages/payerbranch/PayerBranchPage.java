package com.elektrago.pages.payerbranch;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PayerBranchPage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public WebElement btnPayerBranch;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    public WebElement btnContinue;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Confirm\"`]")
    public WebElement btnConfirm;

    public PayerBranchPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validatePayerBranchPage() {
        BaseUtils.waitUntilElementisPresent(btnPayerBranch);
        Assert.isTrue(btnPayerBranch.isDisplayed(), "Element is not present");
    }

    public void tapOnPayerBranch() {
        BaseUtils.waitUntilElementIsClickable(btnPayerBranch);
        btnPayerBranch.click();
    }

    public void tapOnContinue() {
        BaseUtils.waitUntilElementIsClickable(btnContinue);
        btnContinue.click();
    }

    public void tapOnConfirm() {
        BaseUtils.waitUntilElementIsClickable(btnConfirm);
        btnConfirm.click();
    }
}
