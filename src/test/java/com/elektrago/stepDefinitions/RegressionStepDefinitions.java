package com.elektrago.stepDefinitions;

import com.elektrago.pages.login.LoginPage;
import io.cucumber.java.en.Given;
import com.github.javafaker.Faker;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RegressionStepDefinitions {
    private final LoginStepDefinitions loginStepDefinitions = new LoginStepDefinitions();
    private final LoginOneTimeCodeStepDefinitions loginOneTimeCodeStepDefinitions = new LoginOneTimeCodeStepDefinitions();
    private final SignupStepDefinitions signupStepDefinitions = new SignupStepDefinitions();
    private final OffersandexclusivesStepDefinitions offersandexclusivesStepDefinitions = new OffersandexclusivesStepDefinitions();
    private final VerifyEmailStepDefinitions verifyEmailStepDefinitions = new VerifyEmailStepDefinitions();
    private final EnterYourInfoStepDefinitions enterYourInfoStepDefinitions = new EnterYourInfoStepDefinitions();
    private final YouAreNowReadyStepDefinitions youAreNowReadyStepDefinitions = new YouAreNowReadyStepDefinitions();
    private final HomeStepDefinitions homeStepDefinitions = new HomeStepDefinitions();
    private final ProfileStepDefinitions profileStepDefinitions = new ProfileStepDefinitions();
    private final RemittanceProcessStepDefinitions remittanceProcessStepDefinitions = new RemittanceProcessStepDefinitions();
    private final ForgotPasswordVerifyEmailStepDefinitions forgotPasswordVerifyEmailStepDefinitions = new ForgotPasswordVerifyEmailStepDefinitions();
    private final ChangePasswordStepDefinitions changePasswordStepDefinitions = new ChangePasswordStepDefinitions();
    private final ChangePasswordSuccessStepDefinitions changePasswordSuccessStepDefinitions = new ChangePasswordSuccessStepDefinitions();

    private JsonNode platformsData;
    private JsonNode onboardingData;
//    private JsonNode remittancesData;

    @Given("Run regression Case 1")
    public void theAppOnRunRegressionCase1() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFilePlatforms = new File("src/test/java/com/elektrago/testData/platforms.json");
        File jsonFileOnboarding = new File("src/test/java/com/elektrago/testData/onboarding.json");
//        File jsonFileRemittances = new File("src/test/java/com/elektrago/testData/remittances.json");

        platformsData = objectMapper.readTree(jsonFilePlatforms);
        onboardingData = objectMapper.readTree(jsonFileOnboarding);
//        remittancesData = objectMapper.readTree(jsonFileRemittances);

        JsonNode onboardingUserData = onboardingData.get("registerData");

        Faker faker = new Faker();
        String platform = platformsData.get("platforms").get(0).get("name").asText();
        String emailExisting = "a+2503051226@fraternitas.io";
        String phoneNumberExisting = "2503051226";
        String buildOrDept = onboardingUserData.get("address").get("buildOrDept").asText();
        String day = onboardingUserData.get("birthdate").get("day").asText();
        String email = onboardingUserData.get("login").get("email").asText();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String middleName = faker.name().firstName();
        String month = onboardingUserData.get("birthdate").get("month").asText();
        String otp = onboardingUserData.get("login").get("otp").asText();
//        String password = onboardingUserData.get("passwords").get("password").asText();
//        String passwordConfirm = onboardingUserData.get("passwords").get("passwordConfirm").asText();
        String mobileCode = "+1";
        String phoneNumber = onboardingUserData.get("login").get("phoneNumber").asText();
        String secondLastName = faker.name().lastName();
        String streetAndNumber = onboardingUserData.get("address").get("streetAndNumber").asText();
        String year = onboardingUserData.get("birthdate").get("year").asText();

        existingAccount(platform, emailExisting, mobileCode, phoneNumberExisting, email);

        //        New email and phoneNumber
        onboardingSetup(platform);
        signup(platform, email, mobileCode, phoneNumber);
        offersAndExclusives(platform);
        verifyEmail(platform, otp);
        enterInfo(platform, firstName, middleName, lastName, secondLastName, day, month, year, streetAndNumber, buildOrDept);
        letsGo(platform);
        home(platform);
        logout(platform);
    }

    @Given("Run Passwordless login")
    public void theAppOnRunPasswordlessLogin() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFilePlatforms = new File("src/test/java/com/elektrago/testData/platforms.json");
        File jsonFileOnboarding = new File("src/test/java/com/elektrago/testData/onboarding.json");

        platformsData = objectMapper.readTree(jsonFilePlatforms);
        onboardingData = objectMapper.readTree(jsonFileOnboarding);

        JsonNode onboardingUserData = onboardingData.get("registerData");

        String platform = platformsData.get("platforms").get(0).get("name").asText();
        String email = "a+2503051228@fraternitas.io";
        String phoneNumber = onboardingUserData.get("login").get("phoneNumber").asText();
        String otp = onboardingUserData.get("login").get("otp").asText();


        onboardingSetup(platform);
        loginStepDefinitions.theLoginPageIsShowsOnTheApp();
        loginStepDefinitions.theUserFillUpTheEmail(email);
//        loginOneTimeCodeStepDefinitions.theUserTapsOnBtnBack(platform);
//        loginStepDefinitions.theUserTapTheLinkToUseMobileNumber();
//        loginStepDefinitions.theUserSelectTheMobileCode("+1");
//        loginStepDefinitions.theUserFillUpTheMobileFieldWith(phoneNumber);
        loginOneTimeCodeStepDefinitions.theAppOnLOTC(platform);
        loginOneTimeCodeStepDefinitions.theUserEntersOneTimeCode(platform, otp);
        home(platform);
        logout(platform);
    }

    @Given("Run Password login")
    public void theAppOnRunPasswordLogin() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFilePlatforms = new File("src/test/java/com/elektrago/testData/platforms.json");
        File jsonFileOnboarding = new File("src/test/java/com/elektrago/testData/onboarding.json");

        platformsData = objectMapper.readTree(jsonFilePlatforms);
        onboardingData = objectMapper.readTree(jsonFileOnboarding);

//        JsonNode onboardingUserData = onboardingData.get("registerData");

        String platform = platformsData.get("platforms").get(0).get("name").asText();
        String email = "a+2503051207@fraternitas.io";
        String password = "Test2020!";
        String phoneNumber = "2503051207";

        onboardingSetup(platform);
        loginStepDefinitions.theLoginPageIsShowsOnTheApp();
        loginStepDefinitions.theUserFillUpTheEmail(email);
        loginStepDefinitions.thePassword(password);
//        loginStepDefinitions.theUserTapsOnBtnClose();
//        loginStepDefinitions.theUserTapTheLinkToUseMobileNumber();
//        loginStepDefinitions.theUserFillUpTheMobileFieldWith(phoneNumber);
//        loginStepDefinitions.thePassword(password);
        loginStepDefinitions.theUserTapOnTheLogInButton();
        home(platform);
        logout(platform);
    }

    @Given("Run Remittance Cash Pickup")
    public void theAppOnRunRemittanceCashPickup() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFilePlatforms = new File("src/test/java/com/elektrago/testData/platforms.json");
        File jsonFileOnboarding = new File("src/test/java/com/elektrago/testData/onboarding.json");

        platformsData = objectMapper.readTree(jsonFilePlatforms);
        onboardingData = objectMapper.readTree(jsonFileOnboarding);

        JsonNode onboardingUserData = onboardingData.get("registerData");

        String platform = platformsData.get("platforms").get(0).get("name").asText();
        String email = onboardingUserData.get("login").get("email").asText();
        String otp = onboardingUserData.get("login").get("otp").asText();

        onboardingSetup(platform);
        loginStepDefinitions.theLoginPageIsShowsOnTheApp();
        loginStepDefinitions.theUserFillUpTheEmail(email);
        loginOneTimeCodeStepDefinitions.theAppOnLOTC(platform);
        loginOneTimeCodeStepDefinitions.theUserEntersOneTimeCode(platform, otp);
        home(platform);
        remittanceProcessStepDefinitions.loadTestData();
        remittanceProcessStepDefinitions.runFirstTestRemittanceLite();
        home(platform);
        logout(platform);
    }

    @Given("Run Remittance Cancel Receipt")
    public void theAppOnRunRemittanceCancelReceipt() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFilePlatforms = new File("src/test/java/com/elektrago/testData/platforms.json");
        File jsonFileOnboarding = new File("src/test/java/com/elektrago/testData/onboarding.json");
//        File jsonFileRemittances = new File("src/test/java/com/elektrago/testData/remittances.json");

        platformsData = objectMapper.readTree(jsonFilePlatforms);
        onboardingData = objectMapper.readTree(jsonFileOnboarding);
//        remittancesData = objectMapper.readTree(jsonFileRemittances);

//        JsonNode onboardingUserData = onboardingData.get("registerData");

        String platform = platformsData.get("platforms").get(0).get("name").asText();
        String email = "a+2503051207@fraternitas.io";
        String password = "Test2019!";
//        String phoneNumber = "2503051207";

        onboardingSetup(platform);
        loginStepDefinitions.theUserFillUpTheEmail(email);
        loginStepDefinitions.thePassword(password);
        loginStepDefinitions.theUserTapOnTheLogInButton();
        home(platform);
        remittanceProcessStepDefinitions.loadTestData();
        remittanceProcessStepDefinitions.runFirstTestRemittanceLite();
        home(platform);
        logout(platform);
    }

    @Given("the app on {string} run Forgot password")
    public void theAppOnRunForgotPassword(String device) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFilePlatforms = new File("src/test/java/com/elektrago/testData/platforms.json");
        File jsonFileOnboarding = new File("src/test/java/com/elektrago/testData/onboarding.json");
//        File jsonFileRemittances = new File("src/test/java/com/elektrago/testData/remittances.json");

        platformsData = objectMapper.readTree(jsonFilePlatforms);
        onboardingData = objectMapper.readTree(jsonFileOnboarding);
//        remittancesData = objectMapper.readTree(jsonFileRemittances);

//        JsonNode onboardingUserData = onboardingData.get("registerData");

        String platform = platformsData.get("platforms").get(0).get("name").asText();
        String email = "a+2503051207@fraternitas.io";
        String password = "Test2019!";
        String newPassword = "Test2018!";
//        String phoneNumber = "2503051207";
        String otp = "000000";

        onboardingSetup(platform);
        loginStepDefinitions.theUserFillUpTheEmail(email);
        loginStepDefinitions.theUserTapOnTheForgotPasswordButton();
        forgotPasswordVerifyEmailStepDefinitions.theUserEntersVerificationCode(device, otp);
        changePasswordStepDefinitions.theUserInputsPassword(device, password);
        changePasswordStepDefinitions.theUserInputsConfirmPassword(password);
        changePasswordStepDefinitions.theUserTapOnTheChangeButton();
        changePasswordSuccessStepDefinitions.theUserSeesTheChangePasswordSuccessPage(device);
        changePasswordSuccessStepDefinitions.theUserTapsOnBackToLogin();
        loginStepDefinitions.thePassword(newPassword);
        loginStepDefinitions.theUserTapOnTheLogInButton();
        home(platform);
        logout(platform);
    }

    private void logout(String platform) {
        homeStepDefinitions.theUserTapsOnProfile();
        profileStepDefinitions.onPlatform(platform);
        profileStepDefinitions.tapOnLogout();
        profileStepDefinitions.tapsOnLogoutConfirmation();
    }

    private void home(String platform) {
        homeStepDefinitions.theUserIsOnTheHomePage(platform);
    }

    private void letsGo(String platform) {
        youAreNowReadyStepDefinitions.theUserIsOnTheYouAreNowReadyPage(platform);
        youAreNowReadyStepDefinitions.theUserTapsOnLetsGo();
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

    private void existingAccount(String platform, String emailExisting, String mobileCode, String phoneNumberExisting, String email) {
        //        Existing email and phoneNumber
        onboardingSetup(platform);
        signup(platform, emailExisting, mobileCode, phoneNumberExisting);
        offersAndExclusives(platform);
        tapOnLater();

        //          New email and existing phoneNumber
        onboardingSetup(platform);
        signup(platform, email, mobileCode, phoneNumberExisting);
        offersAndExclusives(platform);
        tapOnLater();
    }

    private void tapOnLater() {
        signupStepDefinitions.theUserTapsOnLater();
    }

    private void offersAndExclusives(String platform) {
        offersandexclusivesStepDefinitions.theUserTapsOnContinue(platform);
    }

    private void signup(String platform, String emailExisting, String mobileCode, String phoneNumberExisting) {
        signupStepDefinitions.theUserFillsUpEmail(platform, emailExisting);
//        signupStepDefinitions.theUserSelectsMobileCode(mobileCode);
        signupStepDefinitions.theUserFillsUpPhoneNumber(phoneNumberExisting);
        signupStepDefinitions.theUserTapsOnContinue();
    }

    private void onboardingSetup(String platform) {
        loginStepDefinitions.theAppon(platform);
        loginStepDefinitions.theUserTapOnRegisterOrLogIn();
    }
}
