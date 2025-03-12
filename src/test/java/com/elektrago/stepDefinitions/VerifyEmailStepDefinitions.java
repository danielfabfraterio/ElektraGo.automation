package com.elektrago.stepDefinitions;

import com.elektrago.pages.verifyemail.VerifyEmailPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class VerifyEmailStepDefinitions {
    AppiumDriver driver;
    VerifyEmailPage verifyEmailPage;

    @Given("on {string} the user enters verification code {string}")
    public void theUserEntersVerificationCode(String device, String otp){
        driver = getDriver(device);
        verifyEmailPage = new VerifyEmailPage();
        verifyEmailPage.validateVerifyEmailPage();
        verifyEmailPage.enterVerificationCode(otp);
    }
}
