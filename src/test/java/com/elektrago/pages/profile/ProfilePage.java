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

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Log out\"`]")
    private WebElement btnLogout;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Log out\"`][2]")
    private WebElement btnLogoutConfirmation;

    public ProfilePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateProfilePage() {
        BaseUtils.waitUntilElementisPresent(btnLogout);
        Assert.isTrue(btnLogout.isDisplayed(), "Element is not present");
    }

    public void tapOnLogout() {
        BaseUtils.clickOnElement(btnLogout);
    }

    public void tapOnLogoutConfirmation() {
        BaseUtils.clickOnElement(btnLogoutConfirmation);
    }
}
