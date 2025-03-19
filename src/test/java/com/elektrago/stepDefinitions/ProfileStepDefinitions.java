package com.elektrago.stepDefinitions;

import com.elektrago.pages.profile.ProfilePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class ProfileStepDefinitions {
    private AppiumDriver driver;
    private ProfilePage profilePage;

    @Given("on {string} in Profile")
    public void onPlatform(String device) {
        driver = getDriver(device);
        profilePage = new ProfilePage();
        profilePage.validateProfilePage();
    }

    @Then("the user taps on Logout")
    public void tapOnLogout() {
        profilePage.tapOnLogout();
    }

    @Then("the user taps on Logout confirmation")
    public void tapsOnLogoutConfirmation() {
        profilePage.tapOnLogoutConfirmation();
    }
}
