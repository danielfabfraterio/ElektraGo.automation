package com.elektrago.stepDefinitions;

import com.elektrago.pages.confirmrecipient.ConfirmrecipientPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class ConfirmrecipientStepDefinitions {
    AppiumDriver driver;
    ConfirmrecipientPage confirmrecipientPage;

    @Given("the user taps on confirm button")
    public void theUserTapsOnConfirmButton() {
        driver = getDriver("iOS");
        confirmrecipientPage = new ConfirmrecipientPage();
        confirmrecipientPage.tapsOnConfirmButton();
    }
}
