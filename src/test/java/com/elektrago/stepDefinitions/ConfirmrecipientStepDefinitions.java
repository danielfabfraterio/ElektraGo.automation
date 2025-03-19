package com.elektrago.stepDefinitions;

import com.elektrago.pages.confirmrecipient.ConfirmrecipientPage;
import com.elektrago.utils.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class ConfirmrecipientStepDefinitions {
    AppiumDriver driver;
    ConfirmrecipientPage confirmrecipientPage;

    @Given("the user taps on confirm button")
    public void theUserTapsOnConfirmButton() {
        if (AppiumDriverFactory.getDevice().equalsIgnoreCase("iOS")) {
            driver = getDriver("iOS");
            confirmrecipientPage = new ConfirmrecipientPage();
            confirmrecipientPage.tapsOnConfirmButton();
        }
    }
}
