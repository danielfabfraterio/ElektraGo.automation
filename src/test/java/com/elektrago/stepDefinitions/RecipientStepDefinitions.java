package com.elektrago.stepDefinitions;

import com.elektrago.pages.recipient.RecipientPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class RecipientStepDefinitions {
  AppiumDriver driver;
  RecipientPage recipientPage;

  @Given("on {string} the user taps on added recipient")
  public void theUserTapsOnAddedRecipient(String platform) {
    driver = getDriver(platform);
    recipientPage = new RecipientPage();
    recipientPage.validateRecipientPage();
    recipientPage.tapsOnAddedRecipient();
  }
}
