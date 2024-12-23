package com.elektrago.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseUtils {
    protected static WebDriverWait explicitWait;
    static final int SECONDS = 30;

    public static void waitUntilElementisPresent(WebElement element){
        if(explicitWait == null){
            explicitWait = new WebDriverWait(AppiumDriverFactory.getDriver(), Duration.ofSeconds(SECONDS));
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
            explicitWait = new WebDriverWait(AppiumDriverFactory.getDriver(), Duration.ofSeconds(SECONDS));
        }
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilElementIsSelected(WebElement element){
        if(explicitWait == null){
            explicitWait = new WebDriverWait(AppiumDriverFactory.getDriver(), Duration.ofSeconds(SECONDS));
        }
        explicitWait.until(ExpectedConditions.elementToBeSelected(element));
    }



}
