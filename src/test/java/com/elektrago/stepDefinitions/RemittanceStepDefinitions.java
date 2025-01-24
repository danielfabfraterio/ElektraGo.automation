package com.elektrago.stepDefinitions;

import com.elektrago.pages.home.HomePage;

import com.elektrago.pages.login.LoginPage;
import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class RemittanceStepDefinitions {
    AppiumDriver driver;
    HomePage homePage;

    @Given("on {string} the user selects country {string}")
    public void theUserSelectsCountry(String device, String country) {
        driver = getDriver(device);
        homePage = new HomePage();
        homePage.validateHomePage();
        BaseUtils.clickOnElement(homePage.btnSelectCountry);
        BaseUtils.fillUpField(homePage.inputCountry, country);
        homePage.btnFilteredCountry.click();
    }

    @Given("the user fills up the amount to make the remittance for {string}")
    public void theUserFillsUpTheAmountToMakeTheRemittance(String amount) {
        BaseUtils.waitUntilElementisPresent(homePage.inputSendAmount);
        homePage.inputSendAmount.clear();
        BaseUtils.fillUpField(homePage.inputSendAmount, amount);
        if (AppiumDriverFactory.getDevice().equalsIgnoreCase("ios")) {
            BaseUtils.waitUntilElementIsClickable(homePage.btnDoneKeyboard);
            BaseUtils.clickOnElement(homePage.btnDoneKeyboard);
        }
    }

    @Then("the user taps on Let's Send")
    public void theUserTapsOnLetsSend() {
        homePage.tapsOnLetsSend();
    }
}
