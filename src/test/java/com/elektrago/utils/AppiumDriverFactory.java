package com.elektrago.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.elektrago.pages.DeviceCapabilities;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;

public class AppiumDriverFactory {
    private static AppiumDriver driver;
    private static String device;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static AppiumDriver getDriver(String platform) {
        if (driver == null) {
            driver = createDriver(platform);
        }
        return driver;
    }

    public static AppiumDriver createDriver(String platform) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Se obtiene JSON de los capabilities
        File jsonFile = new File("src/test/resources/capabilities/" + platform + ".json");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            DeviceCapabilities deviceCapabilities = objectMapper.readValue(jsonFile, DeviceCapabilities.class);
            capabilities.setCapability("platformName", deviceCapabilities.getPlatformName());
            capabilities.setCapability("appium:deviceName", deviceCapabilities.getDeviceName());
            capabilities.setCapability("appium:udid", deviceCapabilities.getUdid());
            capabilities.setCapability("appium:automationName", deviceCapabilities.getAutomationName());
            capabilities.setCapability("appium:fullReset", deviceCapabilities.getFullReset());
            capabilities.setCapability("appium:noReset", deviceCapabilities.getNoReset());
            if (platform.equalsIgnoreCase("android")) {
                capabilities.setCapability("appium:appPackage", deviceCapabilities.getAppPackage());
                capabilities.setCapability("appium:appActivity", deviceCapabilities.getAppActivity());
            } else {
                capabilities.setCapability("appium:bundleId", deviceCapabilities.getBundleId());
                capabilities.setCapability("appium:usePrebuiltWDA", true);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de capabilities: " + e.getMessage());
        }
        try {
            return new AppiumDriver(URI.create("http://127.0.0.1:4723/").toURL(), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error al crear el driver: " + e.getMessage());
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static String getDevice() {
        return device;
    }

    public static void setDevice(String device) {
        AppiumDriverFactory.device = device;
    }
}