package com.elektrago.stepDefinitions;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

import com.elektrago.pages.deliverymethod.DeliveryMethodPage;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeliverymethodStepDefinitions {
    AppiumDriver driver;
    DeliveryMethodPage deliveryMethodPage;
    
    @Given("the user taps on select institution")
    public void theUserTapsOnSelectInstitution() {
        driver = getDriver("iOS");
        deliveryMethodPage = new DeliveryMethodPage();
        deliveryMethodPage.validateDeliveryMethodPage();
        deliveryMethodPage.userTapsOnSelectInstitution();
    }

    @Then("the user selects an institution")
    public void theUserSelectsAnInstitution() {
        deliveryMethodPage.userSelectsAnInstitution();
    }

    @Then("the user taps on continue button")
    public void theUserTapsOnContinueButton() {
        deliveryMethodPage.tapsOnContinueButton();
    }
}
