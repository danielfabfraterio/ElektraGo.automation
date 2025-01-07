package com.elektrago.stepDefinitions;

import com.elektrago.pages.carddetails.CardDetailsPage;
import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

public class CarddetailsStepDefinitions {
    AppiumDriver driver;
    CardDetailsPage cardDetailsPage;

    @Given("the user taps on continue button CD")
    public void theUserTapsOnContinueButtonCD() {
        driver = AppiumDriverFactory.getDriver("iOS");
        cardDetailsPage = new CardDetailsPage();
        cardDetailsPage.validateCardDetailsPage();
        cardDetailsPage.btnContinue.click();
        ;
    }
}
