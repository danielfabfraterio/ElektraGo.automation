package com.elektrago.stepDefinitions;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

import com.elektrago.pages.reviewandsend.ReviewAndSendPage;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

public class ReviewandsendStepDefinitions {
    AppiumDriver driver;
    ReviewAndSendPage reviewAndSendPage;

    @Given("the user taps on send now button")
    public void theUserTapsOnSendNowButton() {
        driver = getDriver("iOS");
        reviewAndSendPage = new ReviewAndSendPage();
        reviewAndSendPage.validateReviewAndSendPage();
        reviewAndSendPage.tapsOnSendNowButton();
    }
}
