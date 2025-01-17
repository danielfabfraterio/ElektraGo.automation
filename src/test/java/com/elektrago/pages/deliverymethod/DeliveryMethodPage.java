package com.elektrago.pages.deliverymethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DeliveryMethodPage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Cash Pickup\"`]")
    public WebElement btnCashPickup;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Direct to bank\"`]")
    public WebElement btnDirectToBank;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Direct to App\"`]")
    public WebElement btnDirectToApp;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Home delivery\"`]")
    public WebElement btnHomeDelivery;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrow down icon\"`][1]")
    public WebElement btnRecipientsState;

    @iOSXCUITFindBy(accessibility = "Search state")
    public WebElement inputState;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    public WebElement btnState;

    @iOSXCUITFindBy(accessibility = "Search payer")
    public WebElement inputInstitution;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrow down icon\"`][2]")
    public WebElement btnSelectInstitution;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell")
    public WebElement btnInstitution;

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
