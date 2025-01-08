package com.elektrago.stepDefinitions;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

import com.elektrago.pages.paymentmethod.PaymentMethodPage;
import com.elektrago.utils.BaseUtils;

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

    @Given("the user taps on the first card available")
    public void theUserTapsOnTheFirstCardAvailable() {
        driver = getDriver("iOS");
        paymentMethodPage = new PaymentMethodPage();
        paymentMethodPage.validatePaymentMethodPage();
        BaseUtils.waitUntilElementIsClickable(paymentMethodPage.firstCardAvailable);
        paymentMethodPage.firstCardAvailable.click();
        ;
    }

    @Given("the user taps on new card button")
    public void theUserTapsOnNewCardButton() {
        driver = getDriver("iOS");
        paymentMethodPage = new PaymentMethodPage();
        paymentMethodPage.validatePaymentMethodPage();
        paymentMethodPage.btnNewCard.click();
    }

    @Given("the user taps on Apple Pay button")
    public void theUserTapsOnApplePayButton() {
        driver = getDriver("iOS");
        paymentMethodPage = new PaymentMethodPage();
        paymentMethodPage.validatePaymentMethodPage();
        paymentMethodPage.btnApplePay.click();
    }
}
