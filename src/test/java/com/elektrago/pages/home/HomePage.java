package com.elektrago.pages.home;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @AndroidFindBy(id = "com.elektrago.elektrago:id/send_container")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"$0.00\"`]")
    public WebElement inputSendAmount;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_continue")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Let's send!\"`]")
    public WebElement btnLetsSend;
  
    @AndroidFindBy(id = "com.elektrago.elektrago:id/action_map")
    @iOSXCUITFindBy(accessibility = "ic_tb_map_unselected")
    public WebElement mapsAtm;
  
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField")
    public WebElement btnSelectCountry;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSearchField[`name == \"Search country\"`]")
    public WebElement inputCountry;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell")
    public WebElement btnFilteredCountry;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateHomePage() {
        BaseUtils.waitUntilElementisPresent(inputSendAmount);
        Assert.isTrue(inputSendAmount.isDisplayed(), "Element is not present");
    }

    public void tapsOnLetsSend() {
        BaseUtils.waitUntilElementIsClickable(btnLetsSend);
        BaseUtils.clickOnElement(btnLetsSend);
    }
}
