package com.elektrago.stepDefinitions;

import com.elektrago.pages.directtobank.DirectToBankPage;
import com.elektrago.utils.BaseUtils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class DirecttobankStepDefinitions {
    AppiumDriver driver;
    DirectToBankPage directToBankPage;

    @Given("the user fills up the account number {string}")
    public void theUserFillsUpTheAccountNumber(String accountNumber) {
        driver = getDriver("iOS");
        directToBankPage = new DirectToBankPage();
        directToBankPage.validateDirectToBankPage();
        BaseUtils.fillUpField(directToBankPage.inputAccountNumber, accountNumber);
        directToBankPage.isBtnDoneDisplayed();
    }

    @When("the user taps on select sender id type")
    public void theUserTapsOnSelectSenderIdType() {
        BaseUtils.waitUntilElementIsClickable(directToBankPage.selectSenderIdType);
        BaseUtils.clickOnElement(directToBankPage.selectSenderIdType);
    }

    @When("the user taps on chosen sender id type")
    public void theUserTapsOnDRIVERSLICENSE() {
        BaseUtils.waitUntilElementIsClickable(directToBankPage.tapsOnFirstSenderAccountType);
        BaseUtils.clickOnElement(directToBankPage.tapsOnFirstSenderAccountType);
    }

    @When("the user fills up the sender id number {string}")
    public void theUserFillsUpTheSenderIdNumber(String senderIdNumber) {
        BaseUtils.fillUpField(directToBankPage.inputSenderIdNumber, senderIdNumber);
        directToBankPage.isBtnDoneDisplayed();
    }

    @Then("the user taps on continue button DTB")
    public void theUserTapOnContinueButtonDTB() {
        BaseUtils.waitUntilElementIsClickable(directToBankPage.btnContinue);
        BaseUtils.clickOnElement(directToBankPage.btnContinue);
    }
}
