package com.elektrago.stepDefinitions;

import com.elektrago.pages.home.HomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class HomeStepDefinitions {
  AppiumDriver driver;
  HomePage homePage;

  @Given("the user is on {string} the home page")
  public void theUserIsOnTheHomePage(String device) {
    driver = getDriver(device);
    homePage = new HomePage();
    homePage.validateFirstName();
  }
}