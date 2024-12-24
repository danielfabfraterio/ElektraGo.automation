package com.elektrago.stepDefinitions;

import com.elektrago.pages.choosearecipient.ChoosearecipientPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class ChoosearecipientStepDefinitions {
    AppiumDriver driver;
    ChoosearecipientPage chooseARecipientPage;

    @Given("the user taps on the first recipient available on iOS")
    public void theUserTapsOnTheFirstRecipientAvailableOn() {
        driver = getDriver("iOS");
        chooseARecipientPage = new ChoosearecipientPage();
        chooseARecipientPage.validateChooseARecipientPage();
        chooseARecipientPage.tapsOnFirstRecipientAvailable();
    }
}
