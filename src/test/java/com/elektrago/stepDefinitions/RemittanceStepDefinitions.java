package com.elektrago.stepDefinitions;

import com.elektrago.pages.home.HomePage;

import com.elektrago.utils.BaseUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class RemittanceStepDefinitions {
    AppiumDriver driver;
    HomePage homePage;

    @Given("the user fills up the amount to make the remittance on {string} for {string}")
    public void theUserFillsUpTheAmountToMakeTheRemittance(String device, String amount){
        driver = getDriver(device);
        homePage = new HomePage();
        homePage.validateHomePage();
        BaseUtils.fillUpField(homePage.inputSendAmount, amount);
    }

    @Then("the user taps on Let's Send")
    public void theUserTapsOnLetsSend() {
        homePage.tapsOnLetsSend();
    }
}
