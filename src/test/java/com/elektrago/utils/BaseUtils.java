package com.elektrago.utils;

import io.appium.java_client.AppiumDriver;
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

}
