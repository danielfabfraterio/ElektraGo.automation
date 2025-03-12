package com.elektrago.stepDefinitions;

import com.elektrago.pages.cover.CoverPage;
import com.elektrago.pages.home.HomeLitePage;
import com.elektrago.pages.login.LoginPage;
import com.elektrago.pages.onboarding.AddressInformationPage;
import com.elektrago.pages.onboarding.CreatePasswordPage;
import com.elektrago.pages.onboarding.GeneralInformationPage;
import com.elektrago.pages.signup.SignUpPage;
import com.elektrago.pages.verify.VerifyPage;
import com.elektrago.utils.AppiumDriverFactory;
import com.elektrago.utils.BaseUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;

public class OnboardingLiteStepDefinitions {
    AppiumDriver driver;
    CoverPage coverPage;
    LoginPage loginPage;
    HomeLitePage homeLitePage;
    SignUpPage signUpPage;
//    OffersAndExclusivesNodal offersAndExclusivesNodal;
    VerifyPage verifyPage;
    GeneralInformationPage generalInformationPage;
    AddressInformationPage addressInformationPage;
    CreatePasswordPage createPasswordPage;

//    @Given("the app on {string}")
//    public void theAppOn(String device){
//        driver = AppiumDriverFactory.getDriver(device);
//        AppiumDriverFactory.setDevice(device);
//        coverPage = new CoverPage();
//    }
//    @When("the user tap on Register or log in")
//    public void theUserTapOnRegisterOrLogInOnboardingLite() {
//        coverPage.tapOnSignupLogin();
//    }
//    @Then("the Login Page is shows on the app")
//    public void theLoginPageIsShowsOnTheApp() {
//        loginPage = new LoginPage();
//        loginPage.validateLoginPage();
//    }
//    @When("the user fill up the email {string}")
//    public void theUserFillUpTheEmail(String email) {
//        signUpPage.inputEmail.clear();
//        BaseUtils.fillUpField(signUpPage.inputEmail,email);
//    }
//    @When("the user tap on the Log in button")
//    public void theUserTapOnTheLogInButton() {
//        BaseUtils.clickOnElement(loginPage.btnLogin);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        AppiumDriverFactory.quitDriver();
//    }
//    @Then("the app shows the lite home page")
//    public void theAppShowsTheLiteHomePage() {
//        homeLitePage = new HomeLitePage();
//        homeLitePage.validateHomeLite();
//    }

//    @And("the user tap the link to use mobile number")
//    public void theUserTapTheLinkToUseMobileNumber() {
//        BaseUtils.clickOnElement(loginPage.btnNumberInstead);
//    }

//    @And("the user fill up the mobile field with {string}")
//    public void theUserFillUpTheMobileFieldWith(String number) {
//        loginPage.inputMobileNumber.sendKeys(number);
//    }

//    @When("the user select the mobile code {string}")
//    public void theUserSelectTheMobileCodeOnboardingLite(String code) {
//        BaseUtils.clickOnElement(loginPage.dropDownMobileCode);
//        loginPage.selectMobileCode(code);
//    }

    @When("the user tap on Sign up here")
    public void theUserTapOnSignUpHere() {
        BaseUtils.clickOnElement(loginPage.btnLogin);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AppiumDriverFactory.quitDriver();
    }

    @Then("the Sign Up Page it shows on the app")
    public void theSignUpPageItShowsOnTheApp() {
        signUpPage = new SignUpPage();
        signUpPage.validateSignupPage();
    }

    @When("the user tap on the Continue button")
    public void theUserTapOnTheContinueButton() {
        BaseUtils.clickOnElement(signUpPage.btnContinue);
    }

//    @Then("the Offers and exclusives Nodal it shows on the app")
//    public void theOffersAndExclusivesNodalItShowsOnTheApp() {
//        offersAndExclusivesNodal = new offersAndExclusivesNodal();
//        offersAndExclusivesNodal.validateOffersAndExclusivesNodal();
//    }

    @Then("the Verify your email Page it shows on the app")
    public void theVerifyYourEmailPageItShowsOnTheApp() {
        verifyPage = new VerifyPage();
        verifyPage.validateVerifyPage();
    }

    @When("the user fill up the verification code with {string}")
    public void theUserFillUpTheVerificationCodeWith(String otpCode) {
        verifyPage.inputVerificationCode.clear();
        BaseUtils.fillUpField(verifyPage.inputVerificationCode, otpCode);
    }

    @Then("the Enter your information Page it shows on the app")
    public void theEnterYourInformationPageItShowsOnTheApp() {
        generalInformationPage = new GeneralInformationPage();
        generalInformationPage.validateGeneralInformationPage();
    }

    @When("the user fill up the First name with {string}")
    public void theUserFillUpTheFirstNameWith(String firstName) {
        generalInformationPage.inputFirstName.clear();
        BaseUtils.fillUpField(generalInformationPage.inputFirstName,firstName);
    }

    @When("the user fill up the First lastname with {string}")
    public void theUserFillUpTheFirstLastnameWith(String firstLastName) {
        generalInformationPage.inputFirstLastName.clear();
        BaseUtils.fillUpField(generalInformationPage.inputFirstLastName,firstLastName);
    }

    @When("the user fill up the Date of birth {string}")
    public void theUserFillUpTheDateOfBirth(String dateOfBirh) {
        generalInformationPage.btnDateOfBirth.clear();
        BaseUtils.fillUpField(generalInformationPage.btnDateOfBirth,dateOfBirh);
    }

    @Then("the Enter your address Page it shows on the app")
    public void theEnterYourAddressPageItShowsOnTheApp() {
        addressInformationPage = new AddressInformationPage();
        addressInformationPage.validate();
    }

    @When("the user fill up the Street address with {string}")
    public void theUserFillUpTheStreetAddress(String address) {
        addressInformationPage.inputStreetAddress.clear();
        BaseUtils.fillUpField(addressInformationPage.inputStreetAddress, address);
    }

    @Then("the Create password Page it shows on the app")
    public void theCreatePasswordPageItShowsOnTheApp() {
        createPasswordPage = new CreatePasswordPage();
        createPasswordPage.validate();
    }

    @When("the user fill up the Enter your password with {string}")
    public void theUserFillUpTheEnterYourPasswordWith(String password) {
        createPasswordPage.inputPassword.clear();
        BaseUtils.fillUpField(createPasswordPage.inputPassword,password); 
    }

    @And("the user fill up the Confirm password with {string}")
    public void theUserFillUpTheConfirmPasswordWith(String confirmPassword) {
        createPasswordPage.inputConfirmPassword.clear();
        BaseUtils.fillUpField(createPasswordPage.inputConfirmPassword,confirmPassword);     
    }

    @When("the user tap on the Create button")
    public void theUserTapOnTheCreateButton() {
        BaseUtils.clickOnElement(createPasswordPage.btnCreate);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AppiumDriverFactory.quitDriver();
    }

//    @Then("the Almost there! Page it shows on the app")
//    public void theAlmostTherePageItShowsOntheApp() {
//        almostTherePage = new AlmostTherePage();
//        almostTherePage.validateAlmostTherePage();
//    }

//    @When("the user tap on Take selfie button")
//    public void theUserTapOnTakeSelfieButton() {
//        BaseUtils.clickOnElement(almostTherePage.btnTakeSelfie);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        AppiumDriverFactory.quitDriver();
//    }

//    @Then("the Get Ready! Page it shows on the app")
//    public void theGetReadyPageItShowsOnTheApp() {
//        getReadyPage = new GetReadyPage();
//        getReadyPage.validateGetReadyPage();
//    }

//    @When("the user taps on the Im ready button")
//    public void theUserTapsOnTheImReadyButton() {
//        BaseUtils.clickOnElement(getReadyPage.btnImReady);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        AppiumDriverFactory.quitDriver();
//    }
}
