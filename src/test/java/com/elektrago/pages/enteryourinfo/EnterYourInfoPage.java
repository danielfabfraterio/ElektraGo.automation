package com.elektrago.pages.enteryourinfo;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EnterYourInfoPage {
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"First name\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField")
    private WebElement inputFirstName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Middle name\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField")
    private WebElement inputMiddleName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"First last name\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField")
    private WebElement inputLastName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Second last name\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField")
    private WebElement inputSecondLastName;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Select date\"`]")
    private WebElement fieldDOB;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Street address\"`]")
    private WebElement inputStreetAddress;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"drop_down\"`]/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    private WebElement popupAddress;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Number\"`]")
    private WebElement inputAptOrSuite;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[11]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement inputCity;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Choose\"`]")
    private WebElement inputState;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[10]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private WebElement inputZipCode;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeDatePicker")
    private WebElement datePicker;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Done\"`]")
    private WebElement btnDone;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    private WebElement btnContinue;

    public EnterYourInfoPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateEnterYourInfoPage() {
        BaseUtils.waitUntilElementisPresent(inputFirstName);
        Assert.isTrue(inputFirstName.isDisplayed(), "Element is not present");
    }

    public void entersName(String firstName, String middleName, String lastName, String secondLastName) {
        BaseUtils.fillUpField(inputFirstName, firstName);
        BaseUtils.fillUpField(inputMiddleName, middleName);
        BaseUtils.fillUpField(inputLastName, lastName);
        BaseUtils.fillUpField(inputSecondLastName, secondLastName);
        BaseUtils.clickOnElement(btnDone);
    }

    public void entersDOB(String day, String month, String year) {
        BaseUtils.scrollToElement(fieldDOB);
        BaseUtils.clickOnElement(fieldDOB);
        BaseUtils.swipeToSelectDate(datePicker, day, month, year);
        BaseUtils.clickOnElement(btnDone);
    }

    public void entersAddress(String streetAndNumber, String buildOrDept) {
        BaseUtils.scrollToElement(inputStreetAddress);
        BaseUtils.fillUpField(inputStreetAddress, streetAndNumber);
        BaseUtils.waitUntilElementisPresent(popupAddress);
        BaseUtils.clickOnElement(popupAddress);
        BaseUtils.fillUpField(inputAptOrSuite, buildOrDept);
    }

    public void tapsOnContinue() {
        BaseUtils.clickOnElement(btnDone);
        BaseUtils.clickOnElement(btnContinue);
    }
}
