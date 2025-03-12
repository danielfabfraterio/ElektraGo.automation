package com.elektrago.stepDefinitions;

import com.elektrago.pages.youarenowready.YouAreNowReadyPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class YouAreNowReadyStepDefinitions {
  private AppiumDriver driver;
  private YouAreNowReadyPage youAreNowReadyPage;

  @Given("The user is on {string} the you are now ready page")
  public void theUserIsOnTheYouAreNowReadyPage(String device) {
    driver = getDriver(device);
    youAreNowReadyPage = new YouAreNowReadyPage();
    youAreNowReadyPage.validateYouAreNowReadyPage();
  }

  @When("the user taps on Let's Go!")
  public void theUserTapsOnLetsGo() {
    youAreNowReadyPage.clickLetsGo();
  }
}
