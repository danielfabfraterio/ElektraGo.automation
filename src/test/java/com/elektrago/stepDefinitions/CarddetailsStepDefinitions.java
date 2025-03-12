package com.elektrago.stepDefinitions;

import com.elektrago.pages.carddetails.CardDetailsPage;
import com.elektrago.utils.AppiumDriverFactory;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

public class CarddetailsStepDefinitions {
    AppiumDriver driver;
    CardDetailsPage cardDetailsPage;

    @Given("on {string} the user enters card number: {string}")
    public void theUserEntersCardNumber(String platform, String cardNumber) {
        driver = AppiumDriverFactory.getDriver(platform);
        cardDetailsPage = new CardDetailsPage();
        cardDetailsPage.validateCardDetailsPage();
        cardDetailsPage.setInputCardNumber(cardNumber);
    }

    @Given("the user enters expiration date: {string}")
    public void theUserEntersExpirationDate(String expiration) {
        cardDetailsPage.setInputExpiration(expiration);
    }

    @Given("the user enters CVV: {string}")
    public void theUserEntersCVV(String cvv) {
        cardDetailsPage.setInputCVV(cvv);
    }

    @Given("the user taps on continue button CD")
    public void theUserTapsOnContinueButtonCD() {
        cardDetailsPage.clickContinue();
    }
}
