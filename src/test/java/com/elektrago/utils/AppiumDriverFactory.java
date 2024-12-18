package com.elektrago.utils;
import com.elektrago.pages.DeviceCapabilities;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class AppiumDriverFactory {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver(String platform) {
                if (driver== null){
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
            if (platform.equalsIgnoreCase("android")){
                // Configuración de capabilities para Android
                capabilities.setCapability("platformName", deviceCapabilities.getPlatformName());
                capabilities.setCapability("deviceName", deviceCapabilities.getDeviceName());
                capabilities.setCapability("automationName", deviceCapabilities.getAutomationName());
                capabilities.setCapability("appium:fullReset", deviceCapabilities.getFullReset());
                capabilities.setCapability("appium:noReset", deviceCapabilities.getNoReset());
            } else if (platform.equalsIgnoreCase("ios")) {
                // Configuración de capabilities para iOS
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("deviceName", "iPhone 14");
                capabilities.setCapability("platformVersion", "16.0");
                capabilities.setCapability("automationName", "XCUITest");
                capabilities.setCapability("appium:bundleId", "");

                capabilities.setCapability("appium:fullReset", false);
                capabilities.setCapability("appium:noReset", true);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return new AppiumDriver(capabilities);
    }

    public static void quitDriver() {
       if (driver != null) {
            driver.quit();
        }
    }
}