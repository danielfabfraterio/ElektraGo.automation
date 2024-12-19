package com.elektrago.stepDefinitions;

import com.elektrago.pages.cover.CoverPage;
import com.elektrago.pages.login.LoginPage;
import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;

import java.net.MalformedURLException;

public class LoginStepDefinitions {
    AppiumDriver driver;
    CoverPage coverPage;
    LoginPage loginPage;

    @Given("the app on {string}")
    public void theAppon(String device){
        driver = AppiumDriverFactory.getDriver(device);
        coverPage = new CoverPage();
        coverPage.validationCoverPage();
    }
    @When("the user tap on Register or log in")
    public void theUserTapOnRegisterOrLogIn() {
        coverPage.tapOnSignupLogin();
    }
    @Then("the Login Page is shows on the app")
    public void theLoginPageIsShowsOnTheApp() {
        loginPage = new LoginPage();
        loginPage.validateLoginPage();
    }
    @When("the user fill up the email {string}")
    public void theUserFillUpTheEmail(String email) {
        BaseUtils.fillUpField(loginPage.inputEmail,email);
    }
    @And("the password {string}")
    public void thePassword(String password) {
        BaseUtils.fillUpField(loginPage.inputEmail, password);
    }
    @When("the user tap on the Log in button")
    public void theUserTapOnTheLogInButton() {
        BaseUtils.clickOnElement(loginPage.btnLogin);
    }
    @Then("the app shows the lite home page")
    public void theAppShowsTheLiteHomePage() {
    }
}
