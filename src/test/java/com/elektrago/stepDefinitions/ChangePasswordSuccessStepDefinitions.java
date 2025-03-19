package com.elektrago.stepDefinitions;

import com.elektrago.pages.changepasswordsuccess.ChangePasswordSuccessPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class ChangePasswordSuccessStepDefinitions {
    AppiumDriver driver;
    ChangePasswordSuccessPage changePasswordSuccessPage;

    @Given("on {string} the user sees the Change Password Success Page")
    public void theUserSeesTheChangePasswordSuccessPage(String device) {
        driver = getDriver(device);
        changePasswordSuccessPage = new ChangePasswordSuccessPage();
        changePasswordSuccessPage.validateChangePasswordSuccess();
    }

    @Then("the user taps on Back to login")
    public void theUserTapsOnBackToLogin() {
        changePasswordSuccessPage.tapBackToLogin();
    }
}
