package com.elektrago.stepDefinitions;

import com.elektrago.pages.profile.ProfilePage;
import com.elektrago.utils.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProfileStepDefinitions {
    private AppiumDriver driver;
    private ProfilePage profilePage;

    @Given("on {string} in Profile")
    public void onPlatform(String device) {
        driver = AppiumDriverFactory.getDriver(device);
        profilePage = new ProfilePage();
        profilePage.validateProfilePage();
    }

    @Then("the user taps on Logout")
    public void tapOnLogout() {
        profilePage.tapOnLogout();
    }
}
