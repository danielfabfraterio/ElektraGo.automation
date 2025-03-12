package com.elektrago.stepDefinitions;

import com.elektrago.pages.enteryourinfo.EnterYourInfoPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class EnterYourInfoStepDefinitions {
    private AppiumDriver driver;
    private EnterYourInfoPage enterYourInfoPage;

    @Given("on {string}")
    public void onPlatform(String device){
        driver = getDriver(device);
        enterYourInfoPage = new EnterYourInfoPage();
        enterYourInfoPage.validateEnterYourInfoPage();
    }

    @Given("the user enters FirstName: {string}, MiddleName: {string}, LastName: {string}, SecondLastName: {string}")
    public void enterFirstName(String firstName, String middleName, String lastName, String secondLastName) {
        enterYourInfoPage.entersName(firstName, middleName, lastName, secondLastName);
    }

    @Given("the user enters DOB: {string} {string} {string}" )
    public void enterDOB(String day, String month, String year){
        enterYourInfoPage.entersDOB(day, month, year);
    }

    @Given("the user enters address: Street and number {string}, Building or apartment {string}")
    public void enterAddress(String streetAndNumber, String buildOrDept) {
        enterYourInfoPage.entersAddress(streetAndNumber, buildOrDept);
    }

    @Then("the user taps on Continue EYI")
    public void tapsOnContinueEYI() {
        enterYourInfoPage.tapsOnContinue();
    }
}
