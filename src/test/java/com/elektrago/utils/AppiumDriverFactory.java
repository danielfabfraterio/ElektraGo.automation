package com.elektrago.utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class AppiumDriverFactory {
    private static AppiumDriver androidDriver;
    private static AppiumDriver iosDriver;

    public static AppiumDriver getAndroidDriver() {
        if (androidDriver == null) {
            androidDriver = createAndroidDriver();
        }
        return androidDriver;
    }

    public static AppiumDriver createAndroidDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Configuración de capabilities para Android
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_5");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:noReset", true);

        return new AndroidDriver(capabilities);
    }

    public static AppiumDriver getiOSDriver(){
        if (iosDriver == null) {
            iosDriver = createiOSDriver();
        }
        return iosDriver;
    }

    public static AppiumDriver createiOSDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Configuración de capabilities para iOS
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 14");
        capabilities.setCapability("platformVersion", "16.0");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("appium:fullReset", false);
        capabilities.setCapability("appium:noReset", true);

        return new IOSDriver(capabilities);
    }

    public static void quitDriver() {
        if (androidDriver != null) {
            androidDriver.quit();
            androidDriver = null;
        }
        if (iosDriver != null) {
            iosDriver.quit();
            iosDriver = null;
        }
    }
}