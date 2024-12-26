package com.elektrago.pages.paymentmethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PaymentMethodPage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Elektra Go Card\"`]")
    public WebElement btnWallet;

    public PaymentMethodPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validatePaymentMethodPage() {
        BaseUtils.waitUntilElementIsClickable(btnWallet);
        Assert.isTrue(btnWallet.isEnabled(), "Element is disabled");
    }

    public void tapsOnWalletButton() {
        btnWallet.click();
    }
}
