package com.elektrago.pages.paymentmethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PaymentMethodPage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Payment method\"`]")
    public WebElement title;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Elektra Go Card\"`]")
    public WebElement btnWallet;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]")
    public WebElement firstCardAvailable;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.ViewGroup\").instance(7)")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public WebElement firstCardAvailableLite;

    @AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.ViewGroup\").instance(9)")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    public WebElement btnNewCard;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Apple Pay\"`]")
    public WebElement btnApplePay;

    public PaymentMethodPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validatePaymentMethodPage() {
        Assert.isTrue(title.isDisplayed(), "Element is disabled");
    }

    public void tapsOnWalletButton() {
        btnWallet.click();
    }

    public void tapsOnAddNewCard() {
        BaseUtils.clickOnElement(btnNewCard);
    }
}
