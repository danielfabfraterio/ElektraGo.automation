package com.elektrago.stepDefinitions;

import com.elektrago.pages.loginonetimecode.LoginOneTimeCodePage;
import io.appium.java_client.AppiumDriver;
import com.elektrago.utils.AppiumDriverFactory;
import io.cucumber.java.en.Given;
import com.elektrago.utils.BaseUtils;
import dev.failsafe.internal.util.Assert;

public class LoginOneTimeCodeStepDefinitions {
    AppiumDriver driver;
    LoginOneTimeCodePage loginOneTimeCodePage;

    @Given("the app on {string} LOTC")
    public void theAppOnLOTC(String device) {
        driver = AppiumDriverFactory.getDriver(device);
        loginOneTimeCodePage = new LoginOneTimeCodePage();
        loginOneTimeCodePage.validateLoginOneTimeCodePage();
    }

    @Given("on {string} the user enters one-time code {string}")
    public void theUserEntersOneTimeCode(String device, String otp){
        loginOneTimeCodePage.enterOTP(otp);
    }

    @Given("the user taps on Back button {string}")
    public void theUserTapsOnBtnBack(String device) {
        loginOneTimeCodePage.theUserTapsOnBtnBack();
    }
}
