package com.elektrago.utils;
import com.elektrago.pages.DeviceCapabilities;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static AppiumDriver getDriver(String platform) {
        if(driver == null){
            driver = createDriver(platform);
        }
        return driver;
    }

    public static AppiumDriver createDriver(String platform){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Se obtiene JSON de los capabilities
        File jsonFile = new File("src/test/resources/capabilities/"+platform+".json");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            DeviceCapabilities deviceCapabilities = objectMapper.readValue(jsonFile,DeviceCapabilities.class);
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
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            return new AppiumDriver(new URL("http://127.0.0.1:4723/"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void quitDriver() {
       if (driver != null) {
            driver.quit();
        }
    }
}