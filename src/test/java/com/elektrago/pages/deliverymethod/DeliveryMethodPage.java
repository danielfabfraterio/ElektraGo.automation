package com.elektrago.pages.deliverymethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DeliveryMethodPage {

    @AndroidFindBy(uiAutomator= "new UiSelector().text(\"Cash Pickup\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Cash Pickup\"`]")
    public WebElement btnCashPickup;

    @AndroidFindBy(uiAutomator= "new UiSelector().text(\"Direct to bank\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Direct to bank\"`]")
    public WebElement btnDirectToBank;

    @AndroidFindBy(uiAutomator= "new UiSelector().text(\"Direct to App\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Direct to App\"`]")
    public WebElement btnDirectToApp;

    @AndroidFindBy(uiAutomator= "new UiSelector().text(\"Home delivery\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Home delivery\"`]")
    public WebElement btnHomeDelivery;

    @AndroidFindBy(id="com.elektrago.elektrago:id/icon_spinner")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrow down icon\"`][1]")
    public WebElement btnRecipientsState;

    @AndroidFindBy(id="com.elektrago.elektrago:id/searchViewText")
    @iOSXCUITFindBy(accessibility = "Search state")
    public WebElement inputState;

    @AndroidFindBy(id="com.elektrago.elektrago:id/text_title")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    public WebElement btnState;

    @AndroidFindBy(id="com.elektrago.elektrago:id/searchViewText")
    @iOSXCUITFindBy(accessibility = "Search payer")
    public WebElement inputInstitution;

    @AndroidFindBy(id="com.elektrago.elektrago:id/icon_payer_spinner")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrow down icon\"`][2]")
    public WebElement btnSelectInstitution;

    @AndroidFindBy(id="com.elektrago.elektrago:id/container")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    public WebElement btnInstitution;

    @AndroidFindBy(id="com.elektrago.elektrago:id/button_confirm")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    public WebElement btnContinue;

    public DeliveryMethodPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateDeliveryMethodPage() {
        BaseUtils.waitUntilElementIsClickable(btnContinue);
        Assert.isTrue(btnContinue.isEnabled(), "Element is disabled");
    }

    public void userTapsOnDirectToBank() {
        btnDirectToBank.click();
    }

    public void userTapsOnSelectInstitution() {
        btnSelectInstitution.click();
    }

    public void userTapsOnRecipientsState() {
        btnRecipientsState.click();
    }

    public void userSelectsAnInstitution() {
        btnInstitution.click();
    }

    public void tapsOnContinueButton() {
        btnContinue.click();
    }
}
