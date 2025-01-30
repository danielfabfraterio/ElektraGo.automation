package com.elektrago.stepDefinitions;

import com.elektrago.pages.changepasswd.ChangePassword;
import com.elektrago.pages.home.HomePage;
import com.elektrago.pages.profile.ProfilePage;
import com.elektrago.utils.BaseUtils;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileStepDefinitions {
    HomePage homePage;
    ProfilePage profilePage;
    ChangePassword changePassword;


    @Then("the user taps on the icon profile button")
    public void theUserTapsOnIconProfile(){
        homePage.btnProfileImage.click();
    }

    @When("the user taps on the My profile option")
    public void theUserTapsOntheMyProfile() {
        profilePage = new ProfilePage();
        BaseUtils.clickOnElement(profilePage.myprofileOptionbtn);
    }

    @When("the user taps on the edit button next to the phone number")
    public void theUserTapsOnEditNexttoPhonNumber() {
        BaseUtils.clickOnElement(profilePage.editPhoneNumber);
    }

    @Then("the user taps on the call now button on the modal")
    public void theUserTapsOntheCallNowOntheModal() {
        BaseUtils.clickOnElement(profilePage.btnCallNow);
    }

    @Then("the user taps on the later button on the modal")
    public void theUserTapsOnTheLaterButtonOnTheModal() {
        BaseUtils.clickOnElement(profilePage.btnLater);
    }

    @When("the user taps on the edit button next to the email")
    public void theUserTapsOnTheEditButtonNextToTheEmail() {
        BaseUtils.clickOnElement(profilePage.editEmail);
    }

    @When("the user taps on the edit button next to the hidden password")
    public void theUserTapsOnTheEditButtonNextToTheHiddenPassword() {
        BaseUtils.scrollUntilElementIsPresent(profilePage.editPasswd);
        BaseUtils.clickOnElement(profilePage.editPasswd);
    }

    @When("the user fills up the current password {string}")
    public void theUserFillsUpTheCurrentPassword(String currentPasswd) {
        changePassword = new ChangePassword(); 
        BaseUtils.scrollUntilElementIsPresent(changePassword.inputCurrentPasswd);       
        BaseUtils.fillUpField(changePassword.inputCurrentPasswd, currentPasswd);
    }

    @When("the user fill up the new password {string}")
    public void theUserFillUpTheNewPasswordWithThePreviousOne(String newPasswd) {
        BaseUtils.scrollUntilElementIsPresent(changePassword.inputNewPasswd);
        BaseUtils.fillUpField(changePassword.inputNewPasswd,newPasswd);
    }

    @Then("the apps shows the modal")
    public void theAppsShowsTheModal() {
        BaseUtils.scrollUntilElementIsPresent(changePassword.txtPasswdUsed);
        BaseUtils.waitUntilElementIsClickable(changePassword.btnTryAgain);
        BaseUtils.clickOnElement(changePassword.btnTryAgain);
    }

    @When("the user taps on continue button on Change Password")
    public void userTapsOnContinueButtonOnChangePassword() {
        BaseUtils.scrollUntilElementIsPresent(changePassword.btnChange);
        BaseUtils.clickOnElement(changePassword.btnChange);
    }

    @When("the user confirms the new password {string}")
    public void userConfirmsNewPasswordWithPreviousPassword(String newPasswd) {
        BaseUtils.scrollUntilElementIsPresent(changePassword.inputConfirmPasswd);
        BaseUtils.fillUpField(changePassword.inputConfirmPasswd,newPasswd);
    }

    @Then("the Change password button is not enabled")
    public void changePasswordButtonIsNotEnabled() {
        Assert.isTrue(changePassword.btnChange.isEnabled() != true, "The change password is not enabled");
    }

    @Then("the apps shows an error message")
    public void theAppsShowsErrorMessage() {
        BaseUtils.scrollUntilElementIsPresent(changePassword.lblPasswdsNotMatch);
    }

    @Then("the app shows the password updated successfully")
    public void appShowsPasswordUpdatedSuccessfully() {
        BaseUtils.scrollUntilElementIsPresent(changePassword.imgUpdated);
        BaseUtils.scrollUntilElementIsPresent(changePassword.btnGotoMyProfile);
        BaseUtils.clickOnElement(changePassword.btnGotoMyProfile);
    }

}
