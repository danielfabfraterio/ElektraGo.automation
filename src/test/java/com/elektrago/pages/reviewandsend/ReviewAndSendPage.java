package com.elektrago.pages.reviewandsend;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ReviewAndSendPage {

    @AndroidFindBy(id="com.elektrago.elektrago:id/viewPromocode")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage[`name == \"ic_chevron_down\"`][1]")
    public WebElement btnPromoCode;

    @AndroidFindBy(id="com.elektrago.elektrago:id/input_promo_code")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement inputPromoCodeMX;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement inputPromoCodeGT;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`]")
    public WebElement btnEnter;

    @AndroidFindBy(id="com.elektrago.elektrago:id/button_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Send Now\"`]")
    public WebElement btnSendNow;

    @AndroidFindBy(id="com.elektrago.elektrago:id/button_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    public WebElement btnContinue;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Got it\"`]")
    public WebElement btnGotIt;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Cancel\"`]")
    public WebElement btnCancel;

    public ReviewAndSendPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateReviewAndSendPage() {
        BaseUtils.waitUntilElementIsClickable(btnPromoCode);
        Assert.isTrue(btnPromoCode.isEnabled(), "Element is disabled");
    }

    public void fillPromoCode(String country, String promoCode) {
        if (country.equals("Mexico")) {
            BaseUtils.waitUntilElementisPresent(inputPromoCodeMX);
            inputPromoCodeMX.click();
            inputPromoCodeMX.sendKeys(promoCode);
        }
        if (country.equals("Guatemala")) {
            BaseUtils.waitUntilElementisPresent(inputPromoCodeGT);
            inputPromoCodeGT.click();
            inputPromoCodeGT.sendKeys(promoCode);
        }
        try{
            btnEnter.click();
        } catch (Exception ignored) {}
    }

    public void tapsOnSendNowButton() {
        btnSendNow.click();
    }

    public void tapsOnContinueButton() {
        btnContinue.click();
    }
}
