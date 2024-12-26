package com.elektrago.pages.choosearecipient;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ChoosearecipientPage {

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public WebElement firstRecipientAvailable;

    public ChoosearecipientPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateChooseARecipientPage() {
        BaseUtils.waitUntilElementisPresent(firstRecipientAvailable);
        Assert.isTrue(firstRecipientAvailable.isDisplayed(), "Element is not present");
    }

    public void tapsOnFirstRecipientAvailable() {
        firstRecipientAvailable.click();
    }
}
