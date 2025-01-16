package com.elektrago.stepDefinitions;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

import com.elektrago.pages.payerbranch.PayerBranchPage;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PayerBranchStepDefinitions {
    AppiumDriver driver;
    PayerBranchPage payerBranchPage;

    @Given("the user taps on payer branch")
    public void theUserTapsOnPayerBranch() {
        driver = getDriver("iOS");
        payerBranchPage = new PayerBranchPage();
        payerBranchPage.validatePayerBranchPage();
        payerBranchPage.tapOnPayerBranch();
    }

    @Then("the user taps on continue button PB")
    public void theUserTapsOnContinueButton() {
        payerBranchPage.tapOnContinue();
    }

    @Then("the user taps on confirm button PB")
    public void theUserTapsOnConfirmButton() {
        payerBranchPage.tapOnConfirm();
    }
}
