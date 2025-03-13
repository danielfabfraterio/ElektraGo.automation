package com.elektrago.pages.profile;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`value == \"First name\"]`]")
    private WebElement textFirstName;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Logout\"]`")
    private WebElement btnLogout;

    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateProfilePage() {
        BaseUtils.waitUntilElementisPresent(textFirstName);
        Assert.isTrue(textFirstName.isDisplayed(), "Element is not present");
    }

    public void tapOnLogout() {
        BaseUtils.clickOnElement(btnLogout);
    }
}
