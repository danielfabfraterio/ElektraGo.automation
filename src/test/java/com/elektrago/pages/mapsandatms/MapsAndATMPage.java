package com.elektrago.pages.mapsandatms;

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


public class MapsAndATMPage {

    @AndroidFindBy(id = "com.elektrago:id/search_location")
    @iOSXCUITFindBy(iOSClassChain = "name == \"Search location\"")
    public WebElement inputSearchLocation;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/filter")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Filter:\"]")
    public WebElement btnFilterBy;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/textSpinner")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Filter:\"]/following-sibling::XCUIElementTypeButton")
    public WebElement btnFilterSelected;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_qr")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Get barcode\"]")
    public WebElement btnGetBarCode;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_my_location")
    @iOSXCUITFindBy(accessibility = "ic my location")
    public WebElement btnICLocation;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/textSpinner")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[1]")
    public WebElement btnBestResult;

    @AndroidFindBy(id = "com.elektrago.elektrago:id/button_refresh")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Search this area\"]")
    public WebElement btnSearchThisArea;


    public MapsAndATMPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppiumDriverFactory.getDriver()), this);
    }

    public void validateMapsAndATMs(){
        BaseUtils.waitUntilElementisPresent(inputSearchLocation);
        BaseUtils.waitUntilElementisPresent(btnFilterBy);
        BaseUtils.waitUntilElementisPresent(btnGetBarCode);
        BaseUtils.waitUntilElementisPresent(btnICLocation);
    }

    public void verifyFilterSelected(String filterSelected){
        Assert.isTrue(btnFilterSelected.getText().toLowerCase().equals(filterSelected.toLowerCase()), "The elements is not equals each other");
    }

    public void selectFilter(String option){
        if (AppiumDriverFactory.getDevice().equalsIgnoreCase("ios")) {
            String customXpath = "//XCUIElementTypeStaticText[@name=\""+option+"\"]";
            WebDriver driver = AppiumDriverFactory.getDriver();
            driver.findElement(By.xpath(customXpath)).click();;
        }
    }

}
