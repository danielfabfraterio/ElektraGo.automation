package com.elektrago.utils;

import com.elektrago.pages.login.LoginPage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        AppiumDriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        hideKeybord();
        element.sendKeys(value);
    }

    private static void hideKeybord() {
        final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point tapPoint = new Point(347, 488);
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        AppiumDriverFactory.getDriver().perform(Arrays.asList(tap));

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
