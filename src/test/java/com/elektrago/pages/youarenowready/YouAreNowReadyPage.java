package com.elektrago.pages.youarenowready;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class YouAreNowReadyPage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Your are now ready\"`]")

    private WebElement title;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Let's go!\"`]")
    private WebElement btnLetsGo;

    public YouAreNowReadyPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateYouAreNowReadyPage() {
//        BaseUtils.waitUntilElementisPresent(title);
//        Assert.isTrue(title.isDisplayed(), "Element is not displayed");
    }

    public void clickLetsGo() {
        BaseUtils.clickOnElement(btnLetsGo);
    }
}
