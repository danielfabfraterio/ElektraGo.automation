package com.elektrago.pages.addrecipient;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddRecipientPage {
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeTextField[2]")
    private WebElement inputMobilePhoneNumber;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    private WebElement inputFirstName;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[12]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement inputMiddleName;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")
    private WebElement inputLastName;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[3]")
    private WebElement inputSecondLastName;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Add\"`]")
    private WebElement btnAdd;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`]")
    private WebElement btnDone;

    public AddRecipientPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateAddRecipientPage() {
        BaseUtils.waitUntilElementisPresent(inputMobilePhoneNumber);
        Assert.isTrue(inputMobilePhoneNumber.isDisplayed(), "Element is not present");
    }

    public void inputMobilePhoneNumber(String mobilePhoneNumber) {
        BaseUtils.fillUpField(inputMobilePhoneNumber, mobilePhoneNumber);
    }

    public void inputFirstName(String firstName) {
        BaseUtils.fillUpField(inputFirstName, firstName);
        btnDone();
    }

    public void inputMiddleName(String middleName) {
        BaseUtils.fillUpField(inputMiddleName, middleName);
        btnDone();
    }

    public void inputLastName(String lastName) {
        BaseUtils.fillUpField(inputLastName, lastName);
        btnDone();
    }

    public void inputSecondLastName(String secondLastName) {
        BaseUtils.fillUpField(inputSecondLastName, secondLastName);
        btnDone();
    }

    public void btnAdd() {
      BaseUtils.clickOnElement(btnAdd);
    }

    public void btnDone() {
      BaseUtils.clickOnElement(btnDone);
    }
}
