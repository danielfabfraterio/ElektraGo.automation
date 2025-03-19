package com.elektrago.stepDefinitions;

import com.elektrago.pages.changepassword.ChangePasswordPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class ChangePasswordStepDefinitions {
    AppiumDriver driver;
    ChangePasswordPage changePasswordPage;

    @Given("on {string} the user enters ChangePassword password: {string}")
    public void theUserInputsPassword(String device, String password) {
        driver = getDriver(device);
        changePasswordPage = new ChangePasswordPage();
        changePasswordPage.validateChangePassword();
        changePasswordPage.fillPassword(password);
    }

    @And("the user enters ChangePassword password confirm: {string}")
    public void theUserInputsConfirmPassword(String confirmPassword) {
        changePasswordPage.fillPasswordConfirm(confirmPassword);

    }

    @Then("the user taps on Change ChangePassword")
    public void theUserTapOnTheChangeButton() {
        changePasswordPage.tapChange();
    }
}
