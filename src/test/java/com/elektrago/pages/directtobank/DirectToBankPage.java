package com.elektrago.pages.directtobank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DirectToBankPage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`]")
    public WebElement btnDone;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"The Account Number must be 10 to 20 digits, or enter your associated account phone number.\"`]")
    public WebElement inputAccountNumber;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Choose one\"`]")
    public WebElement selectSenderIdType;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"DRIVERS LICENSE\"`]")
    public WebElement tapOnSelectSenderIdTypeDL;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"drop_down\"`]/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public WebElement tapsOnFirstSenderAccountType;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeTextField")
    public WebElement inputSenderIdNumber;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    public WebElement btnContinue;

    public DirectToBankPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateDirectToBankPage() {
        BaseUtils.waitUntilElementisPresent(inputAccountNumber);
        Assert.isTrue(inputAccountNumber.isDisplayed(), "Element is not present");
    }

    public void isBtnDoneDisplayed() {
        BaseUtils.waitUntilElementisPresent(btnDone);
        Assert.isTrue(btnDone.isDisplayed(), "Element is not present");
        btnDone.click();
    }
}
