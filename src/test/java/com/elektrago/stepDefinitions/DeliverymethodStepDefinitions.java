package com.elektrago.stepDefinitions;

import com.elektrago.pages.deliverymethod.DeliveryMethodPage;
import static com.elektrago.utils.AppiumDriverFactory.getDriver;
import com.elektrago.utils.BaseUtils;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeliverymethodStepDefinitions {
    AppiumDriver driver;
    DeliveryMethodPage deliveryMethodPage;

    @Given("the user taps on Cash Pickup")
    public void theUserTapsOnCashPickup() {
        driver = getDriver("iOS");
        deliveryMethodPage = new DeliveryMethodPage();
        deliveryMethodPage.validateDeliveryMethodPage();
        deliveryMethodPage.btnCashPickup.click();
    }

    @Given("the user taps on Direct to bank")
    public void theUserTapsOnDirectToBank() {
        driver = getDriver("iOS");
        deliveryMethodPage = new DeliveryMethodPage();
        deliveryMethodPage.validateDeliveryMethodPage();
        deliveryMethodPage.btnDirectToBank.click();
    }

    @Given("the user taps on Direct to App")
    public void theUserTapsOnDirectToApp() {
        driver = getDriver("iOS");
        deliveryMethodPage = new DeliveryMethodPage();
        deliveryMethodPage.validateDeliveryMethodPage();
        deliveryMethodPage.btnDirectToApp.click();
    }

    @Given("the user taps on Home Delivery")
    public void theUserTapsOnHomeDelivery() {
        driver = getDriver("iOS");
        deliveryMethodPage = new DeliveryMethodPage();
        deliveryMethodPage.validateDeliveryMethodPage();
        deliveryMethodPage.btnHomeDelivery.click();
    }

    @When("the user taps on Recipient's state")
    public void theUserTapsOnRecipientsState() {
        deliveryMethodPage.userTapsOnRecipientsState();
    }

    @When("the user fills up the state {string}")
    public void theUserFillsUpTheState(String state) {
        deliveryMethodPage.inputState.clear();
        BaseUtils.waitUntilElementisPresent(deliveryMethodPage.inputState);
        BaseUtils.clickOnElement(deliveryMethodPage.inputState);
        BaseUtils.fillUpField(deliveryMethodPage.inputState, state);
    }

    @Then("the user taps on filtered state")
    public void theUserTapsOnFilteredState() {
        BaseUtils.waitUntilElementIsClickable(deliveryMethodPage.btnState);
        BaseUtils.clickOnElement(deliveryMethodPage.btnState);
    }

    @Given("the user taps on select institution")
    public void theUserTapsOnSelectInstitution() {
        driver = getDriver("iOS");
        deliveryMethodPage = new DeliveryMethodPage();
        deliveryMethodPage.validateDeliveryMethodPage();
        deliveryMethodPage.userTapsOnSelectInstitution();
    }

    @Then("the user fills up the institution {string}")
    public void theUserFillsUpTheInstitution(String institution) {
        deliveryMethodPage.inputInstitution.clear();
        BaseUtils.waitUntilElementisPresent(deliveryMethodPage.inputInstitution);
        BaseUtils.fillUpField(deliveryMethodPage.inputInstitution, institution);
    }

    @When("the user taps on filtered institution")
    public void theUserTapsOnFilteredInstitution() {
        BaseUtils.waitUntilElementIsClickable(deliveryMethodPage.btnInstitution);
        BaseUtils.clickOnElement(deliveryMethodPage.btnInstitution);
    }

    @Then("the user taps on continue button")
    public void theUserTapsOnContinueButton() {
        deliveryMethodPage.tapsOnContinueButton();
    }
}
