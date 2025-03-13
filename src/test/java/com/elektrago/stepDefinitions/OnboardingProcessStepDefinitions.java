package com.elektrago.stepDefinitions;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.FakeTimeLimiter;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import java.io.File;
import java.io.IOException;

public class OnboardingProcessStepDefinitions {
    LoginStepDefinitions loginStepDefinitions = new LoginStepDefinitions();
    SignupStepDefinitions signupStepDefinitions = new SignupStepDefinitions();
    OffersandexclusivesStepDefinitions offersandexclusivesStepDefinitions = new OffersandexclusivesStepDefinitions();
    VerifyEmailStepDefinitions verifyEmailStepDefinitions = new VerifyEmailStepDefinitions();
    EnterYourInfoStepDefinitions enterYourInfoStepDefinitions = new EnterYourInfoStepDefinitions();
    CreatePasswordStepDefinitions createPasswordStepDefinitions = new CreatePasswordStepDefinitions();
    YouAreNowReadyStepDefinitions youAreNowReadyStepDefinitions = new YouAreNowReadyStepDefinitions();
    HomeStepDefinitions homeStepDefinitions = new HomeStepDefinitions();
    RemittanceProcessStepDefinitions remittanceProcessStepDefinitions = new RemittanceProcessStepDefinitions();
    ProfileStepDefinitions profileStepDefinitions = new ProfileStepDefinitions();

    private JsonNode platformsData;
    private JsonNode onboardingData;
    private JsonNode remittancesData;

    @Given("onboarding test data is loaded from JSON data file")
    public void loadTestData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFilePlatforms = new File("src/test/java/com/elektrago/testData/platforms.json");
        File jsonFileOnboarding = new File("src/test/java/com/elektrago/testData/onboarding.json");
        File jsonFileRemittances = new File("src/test/java/com/elektrago/testData/remittances.json");

        platformsData = objectMapper.readTree(jsonFilePlatforms);
        onboardingData = objectMapper.readTree(jsonFileOnboarding);
        remittancesData = objectMapper.readTree(jsonFileRemittances);
    }

    @Then("run Onboarding tests")
    public void runOnboardingTests() throws IOException {
        Faker faker = new Faker();

        String platform = platformsData.get("platforms").get(0).get("name").asText();
        JsonNode onboardingCases = onboardingData.get("cases");
        JsonNode onboardingUserData = onboardingData.get("registerData");

        for (JsonNode testCase : onboardingCases) {
            String buildOrDept = onboardingUserData.get("address").get("buildOrDept").asText();
            String day = onboardingUserData.get("birthdate").get("day").asText();
            String email = onboardingUserData.get("login").get("email").asText();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String middleName = faker.name().firstName();
            String month = onboardingUserData.get("birthdate").get("month").asText();
            String otp = onboardingUserData.get("login").get("otp").asText();
            String password = onboardingUserData.get("passwords").get("password").asText();
            String passwordConfirm = onboardingUserData.get("passwords").get("passwordConfirm").asText();
            String phoneNumber = onboardingUserData.get("login").get("phoneNumber").asText();
            String secondLastName = faker.name().lastName();
            String streetAndNumber = onboardingUserData.get("address").get("streetAndNumber").asText();
            String year = onboardingUserData.get("birthdate").get("year").asText();

            onboardingSetup(platform);
            signupInfo(platform, email, phoneNumber);
            offersAndExclusives(platform);

            verifyEmail(platform, otp);
            enterInfo(platform, firstName, middleName, lastName, secondLastName, day, month, year, streetAndNumber, buildOrDept);
            letsGo(platform);
            home(platform);
            remittanceProcessStepDefinitions.loadTestData();
            remittanceProcessStepDefinitions.runFirstTestRemittanceLite();
            home(platform);
        }
    }

    private void logout() {
        homeStepDefinitions.theUserTapsOnProfile();
        profileStepDefinitions.tapOnLogout();
    }

    private void home(String platform) {
        homeStepDefinitions.theUserIsOnTheHomePage(platform);
    }

    private void letsGo(String platform) {
        youAreNowReadyStepDefinitions.theUserIsOnTheYouAreNowReadyPage(platform);
        youAreNowReadyStepDefinitions.theUserTapsOnLetsGo();
    }

    private void enterPassword(String platform, String password, String passwordConfirm) {
        createPasswordStepDefinitions.theUserInputsPassword(platform, password);
        createPasswordStepDefinitions.theUserInputsConfirmPassword(passwordConfirm);
        createPasswordStepDefinitions.theUserTapOnTheContinueButton();
    }

    private void enterInfo(String platform, String firstName, String middleName, String lastName, String secondLastName, String day, String month, String year, String streetAndNumber, String buildOrDept) {
        enterYourInfoStepDefinitions.onPlatform(platform);
        enterYourInfoStepDefinitions.enterFirstName(firstName, middleName, lastName, secondLastName);
        enterYourInfoStepDefinitions.enterDOB(day, month, year);
        enterYourInfoStepDefinitions.enterAddress(streetAndNumber, buildOrDept);
        enterYourInfoStepDefinitions.tapsOnContinueEYI();
    }

    private void verifyEmail(String platform, String otp) {
        verifyEmailStepDefinitions.theUserEntersVerificationCode(platform, otp);
    }

    private void offersAndExclusives(String platform) {
        offersandexclusivesStepDefinitions.theUserTapsOnContinue(platform);
    }

    private void signupInfo(String platform, String email, String phoneNumber) {
        signupStepDefinitions.theUserFillsUpEmail(platform, email);
        signupStepDefinitions.theUserFillsUpPhoneNumber(phoneNumber);
        signupStepDefinitions.theUserTapsOnContinue();
    }

    private void onboardingSetup(String platform) {
        loginStepDefinitions.theAppon(platform);
        loginStepDefinitions.theUserTapOnRegisterOrLogIn();
    }
}
