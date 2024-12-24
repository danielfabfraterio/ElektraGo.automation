package com.elektrago.stepDefinitions;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

import com.elektrago.pages.paymentmethod.PaymentMethodPage;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

public class PaymentmethodStepDefinitions {
    AppiumDriver driver;
    PaymentMethodPage paymentMethodPage;

    @Given("the user taps on wallet button")
    public void theUserTapsOnWalletButton() {
        driver = getDriver("iOS");
        paymentMethodPage = new PaymentMethodPage();
        paymentMethodPage.validatePaymentMethodPage();
        paymentMethodPage.tapsOnWalletButton();
    }
}
