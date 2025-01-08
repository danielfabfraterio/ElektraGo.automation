package com.elektrago.pages.addcashstore;

import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCashStore{

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
    public WebElement btnClose;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Generate barcode\"]")
    public WebElement btnGenerateBarCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Create barcode\"]")
    public WebElement btnCreateCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
    public WebElement btnCancel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[6]/XCUIElementTypeOther/XCUIElementTypeImage")
    public WebElement imgBarCode;
    
    public AddCashStore(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void SelectStore(String store){
        if (AppiumDriverFactory.getDevice().equalsIgnoreCase("ios")) {
            String customXpath = "//XCUIElementTypeStaticText[@name=\""+store+"\"]";
            WebDriver driver = AppiumDriverFactory.getDriver();
            driver.findElement(By.xpath(customXpath)).click();;
        }
    }

    public void validateCustomBarcode(){
        BaseUtils.waitUntilElementisPresent(btnCancel);
        BaseUtils.waitUntilElementisPresent(btnCreateCode);
    }

}