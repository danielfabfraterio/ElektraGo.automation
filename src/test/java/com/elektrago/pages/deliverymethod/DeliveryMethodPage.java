package com.elektrago.pages.deliverymethod;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DeliveryMethodPage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"arrow down icon\"`][2]")
    public WebElement btnSelectInstitution;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]")
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


    public void userTapsOnSelectInstitution() {
        btnSelectInstitution.click();
    }

    public void userSelectsAnInstitution() {
        btnInstitution.click();
    }

    public void tapsOnContinueButton() {
        btnContinue.click();
    }
}
