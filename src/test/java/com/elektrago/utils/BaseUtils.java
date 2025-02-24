package com.elektrago.utils;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    // Método para hacer scroll hasta que el elemento sea visible
    public static void scrollUntilElementIsPresent(WebElement element) {
        final int MAX_ATTEMPTS = 5;
        
        for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
            try {
                waitUntilElementisPresent(element);
                return;
            } catch (Exception e) {
                performVerticalScroll();
            }
        }
        throw new RuntimeException("Elemento no encontrado después de " + MAX_ATTEMPTS + " intentos de scroll");
    }

    // Método para realizar scroll vertical
    private static void performVerticalScroll() {
        Dimension size = getDriver().manage().window().getSize();
        
        int startX = size.getWidth() / 2;
        int startY = (int) (size.getHeight() * 0.8);
        int endY = (int) (size.getHeight() * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        
        scroll.addAction(finger.createPointerMove(Duration.ZERO, 
                        PointerInput.Origin.viewport(), 
                        startX, 
                        startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(600),
                        PointerInput.Origin.viewport(), 
                        startX, 
                        endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getDriver().perform(Collections.singletonList(scroll));
    }

}
