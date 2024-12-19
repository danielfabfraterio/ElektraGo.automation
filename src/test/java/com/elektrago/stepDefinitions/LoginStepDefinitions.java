package com.elektrago.stepDefinitions;

import com.elektrago.pages.cover.CoverPage;
import com.elektrago.utils.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;

import java.net.MalformedURLException;

public class LoginStepDefinitions {
    AppiumDriver driver;
    CoverPage coverPage;

    @Given("the app on {string}")
    public void theAppon(String device){
        driver = AppiumDriverFactory.createDriver(device);
        System.out.println(driver);
        coverPage = new CoverPage(driver);
    }
    @When("the user tap on Register or log in")
    public void theUserTapOnRegisterOrLogIn() {
        coverPage.tapOnSignupLogin();
    }
    @Then("the Sign up Lite is shows on the app")
    public void theSignUpLiteIsShowsOnTheApp() {
    }
    @And("the user tap on the link log in here")
    public void theUserTapOnTheLinkLogInHere() {
    }
    @When("the user fill up the email {string}")
    public void theUserFillUpTheEmail(String email) {
    }
    @And("the password {string}")
    public void thePassword(String password) {
    }
    @When("the user tap on the Log in button")
    public void theUserTapOnTheLogInButton() {

    }
    @Then("the app shows the lite home page")
    public void theAppShowsTheLiteHomePage() {
    }
}
