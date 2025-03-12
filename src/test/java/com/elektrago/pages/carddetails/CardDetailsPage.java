package com.elektrago.pages.carddetails;

import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CardDetailsPage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Card details\"`]")
    public WebElement title;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"4000 0566 5566 5556\"`]")
    public WebElement inputCardNumberClear;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"16 digit number\"`]")
    public WebElement inputCardNumber;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"12/29\"`]")
    public WebElement inputExpirationClear;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"MM/YY\"`]")
    public WebElement inputExpiration;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"123\"`]")
    public WebElement inputCVVClear;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"3 digit code\"`]")
    public WebElement inputCVV;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`]")
    public WebElement btnDone;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    public WebElement btnContinue;

    public CardDetailsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateCardDetailsPage() {
        Assert.isTrue(title.isDisplayed(), "Element is not displayed");
    }

    public void setInputCardNumber(String cardNumber) {
        try {
            inputCardNumberClear.clear();
        } catch (Exception ignored) {
        }
        BaseUtils.fillUpField(inputCardNumber, cardNumber);
    }

    public void setInputExpiration(String expiration) {
        try {
            inputExpirationClear.clear();
        } catch (Exception ignored) {
        }
        BaseUtils.fillUpField(inputExpiration, expiration);
    }

    public void setInputCVV(String cvv) {
        try {
            inputCVVClear.clear();
        } catch (Exception ignored) {
        }
        BaseUtils.fillUpField(inputCVV, cvv);
        BaseUtils.clickOnElement(btnDone);
    }

    public void clickContinue() {
        BaseUtils.clickOnElement(btnContinue);
    }
}
