package com.elektrago.stepDefinitions;

import com.elektrago.pages.forgotpasswordverifyemail.ForgotPasswordVerifyEmailPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class ForgotPasswordVerifyEmailStepDefinitions {
    AppiumDriver driver;
    ForgotPasswordVerifyEmailPage forgotPasswordVerifyEmailPage;

    @Given("on {string} FPVE the user enters verification code {string}")
    public void theUserEntersVerificationCode(String device, String otp){
        driver = getDriver(device);
        forgotPasswordVerifyEmailPage = new ForgotPasswordVerifyEmailPage();
        forgotPasswordVerifyEmailPage.validateForgotPasswordVerifyEmailPage();
        forgotPasswordVerifyEmailPage.enterVerificationCode(otp);
    }
}
