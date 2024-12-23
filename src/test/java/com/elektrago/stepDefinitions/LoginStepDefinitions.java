package com.elektrago.stepDefinitions;

import com.elektrago.pages.cover.CoverPage;
import com.elektrago.pages.home.HomeLitePage;
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
    HomeLitePage homeLitePage;

    @Given("the app on {string}")
    public void theAppon(String device){
        driver = AppiumDriverFactory.getDriver(device);
        coverPage = new CoverPage();
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
        BaseUtils.fillUpField(loginPage.inputPasswd, password);
    }
    @When("the user tap on the Log in button")
    public void theUserTapOnTheLogInButton() {
        BaseUtils.clickOnElement(loginPage.btnLogin);
    }
    @Then("the app shows the lite home page")
    public void theAppShowsTheLiteHomePage() {
        homeLitePage = new HomeLitePage();
        homeLitePage.validateHomeLite();
    }

    @And("the user tap the link to use mobile number")
    public void theUserTapTheLinkToUseMobileNumber() {
        BaseUtils.clickOnElement(loginPage.btnNumberInstead);
    }

    @And("the user fill up the mobile field with {string}")
    public void theUserFillUpTheMobileFieldWith(String number) {
        loginPage.inputMobileNumber.sendKeys(number);
    }

    @When("the user select the mobile code {string}")
    public void theUserSelectTheMobileCode(String code) {
        BaseUtils.clickOnElement(loginPage.dropDownMobileCode);
        loginPage.selectMobileCode(code);
    }
}
