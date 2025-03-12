package com.elektrago.pages.offersandexclusives;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OffersAndExclusivesPage {

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Continue\"])[2]")
    public WebElement btnContinue;

    public OffersAndExclusivesPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateOffersAndExclusivesPage() {
        BaseUtils.waitUntilElementIsClickable(btnContinue);
        Assert.isTrue(btnContinue.isEnabled(), "Element is disabled");
    }

    public void tapsOnContinue() {
        btnContinue.click();
    }
}
