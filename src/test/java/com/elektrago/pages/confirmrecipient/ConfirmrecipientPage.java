package com.elektrago.pages.confirmrecipient;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ConfirmrecipientPage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Confirm\"`]")
    public WebElement btnConfirm;

    public ConfirmrecipientPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateConfirmRecipientPage(){
    }

    public void tapsOnConfirmButton() {
        BaseUtils.waitUntilElementIsClickable(btnConfirm);
        btnConfirm.click();
    }
}
