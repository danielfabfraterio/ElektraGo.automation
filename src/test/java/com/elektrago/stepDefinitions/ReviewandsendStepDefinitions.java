package com.elektrago.stepDefinitions;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

import com.elektrago.pages.reviewandsend.ReviewAndSendPage;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ReviewandsendStepDefinitions {
    AppiumDriver driver;
    ReviewAndSendPage reviewAndSendPage;

    @Given("the user fills promo code {string} {string}")
    public void theUserFillsPromoCode(String country, String promoCode) {
        driver = getDriver("iOS");
        reviewAndSendPage = new ReviewAndSendPage();
        reviewAndSendPage.validateReviewAndSendPage();
        reviewAndSendPage.btnPromoCode.click();
        reviewAndSendPage.fillPromoCode(country, promoCode);
    }

    @Given("the user taps on send now button")
    public void theUserTapsOnSendNowButton() {
        reviewAndSendPage.tapsOnSendNowButton();
    }

    @Then("the user taps on Got it button")
    public void theUserTapsOnGotIt() {
        reviewAndSendPage.btnGotIt.click();
    }

    @Then("the user taps on Cancel button")
    public void theUserTapsOnCancel() {
        reviewAndSendPage.btnCancel.click();
    }
}
