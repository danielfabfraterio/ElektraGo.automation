package com.elektrago.stepDefinitions;

import com.elektrago.pages.onboarding.CreatePasswordPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class CreatePasswordStepDefinitions {
    AppiumDriver driver;
    CreatePasswordPage createPasswordPage;

    @Given("on {string} the user enters password: {string}")
    public void theUserInputsPassword(String device, String password) {
        driver = getDriver(device);
        createPasswordPage = new CreatePasswordPage();
        createPasswordPage.validate();
        createPasswordPage.fillPassword(password);
    }

    @And("the user enters password confirm: {string}")
    public void theUserInputsConfirmPassword(String confirmPassword) {
        createPasswordPage.fillPasswordConfirm(confirmPassword);
    }

    @Then("the user taps on Continue CP")
    public void theUserTapOnTheContinueButton() {
        createPasswordPage.tapContinue();
    }
}
