package com.elektrago.stepDefinitions;

import com.elektrago.pages.login.LoginPage;
import com.elektrago.pages.signup.SignUpPage;
import com.elektrago.utils.BaseUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class SignupStepDefinitions {
    AppiumDriver driver;
    SignUpPage signUpPage;
    LoginPage loginPage;

    @Given("on {string} using email {string}")
    public void theUserFillsUpEmail(String device, String email) {
        driver = getDriver(device);
        loginPage = new LoginPage();
        if (loginPage.validateIfPreviouslySignedUp()) {
            BaseUtils.clickOnElement(loginPage.SignUpHere);
        }
        signUpPage = new SignUpPage();
        signUpPage.validateSignupPage();
        BaseUtils.fillUpField(signUpPage.inputEmail, email);
    }

    @Given("using phone number {string}")
    public void theUserFillsUpPhoneNumber(String phoneNumber) {
        BaseUtils.waitUntilElementisPresent(signUpPage.inputMobileNumber);
        BaseUtils.fillUpField(signUpPage.inputMobileNumber, phoneNumber);
    }

    @Then("the user taps on Continue")
    public void theUserTapsOnContinue() {
        signUpPage.tapsOnContinue();
    }
}
