package com.elektrago.utils;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class BaseUtils {
    protected static WebDriverWait explicitWait;
    static final int SECONDS = 30;

    public static void waitUntilElementisPresent(WebElement element) {
        if (explicitWait == null) {
            explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(SECONDS));
        }
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void fillUpField(WebElement element, String value) {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        element.sendKeys(value);
    }

    public static void clickOnElement(WebElement element) {
        waitUntilElementIsClickable(element);
        element.click();
    }

    public static void waitUntilElementIsClickable(WebElement element) {
        if (explicitWait == null) {
            explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(SECONDS));
        }
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilElementIsSelected(WebElement element) {
        if (explicitWait == null) {
            explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(SECONDS));
        }
        explicitWait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void scrollToElement(WebElement element) {
        Actions actions = new Actions(getDriver());
        while (!element.isDisplayed()) {
            actions.scrollByAmount(0, 200) // Scroll down
                    .pause(Duration.ofMillis(500))
                    .perform();
        }
    }

}
