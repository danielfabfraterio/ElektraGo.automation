package com.elektrago.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseUtils {
    protected static WebDriverWait explicitWait;

    public static void waitUntilElementisPresent(WebElement element){
        if(explicitWait == null){
            explicitWait = new WebDriverWait(AppiumDriverFactory.getDriver(), Duration.ofSeconds(30));
        }
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void fillUpField(WebElement element, String value){
        element.sendKeys(value);
    }

    public static void clickOnElement(WebElement element){
        waitUntilElementIsClickable(element);
        element.click();
    }

    public static void waitUntilElementIsClickable(WebElement element){
        if(explicitWait == null){
            explicitWait = new WebDriverWait(AppiumDriverFactory.getDriver(), Duration.ofSeconds(30));
        }
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
