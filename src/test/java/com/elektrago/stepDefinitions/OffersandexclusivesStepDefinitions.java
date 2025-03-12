package com.elektrago.stepDefinitions;

import com.elektrago.pages.offersandexclusives.OffersAndExclusivesPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class OffersandexclusivesStepDefinitions
{
    AppiumDriver driver;
    OffersAndExclusivesPage offersAndExclusivesPage;

    @Given("on {string} the user taps on Continue")
    public void theUserTapsOnContinue(String device) {
        driver = getDriver(device);
        offersAndExclusivesPage = new OffersAndExclusivesPage();
        offersAndExclusivesPage.validateOffersAndExclusivesPage();
        offersAndExclusivesPage.tapsOnContinue();
    }
}
