package com.elektrago.stepDefinitions;

import com.elektrago.pages.home.HomePage;
import com.elektrago.pages.profile.ProfilePage;
import com.elektrago.utils.BaseUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileStepDefinitions {
    HomePage homePage;
    ProfilePage profilePage;


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

}
