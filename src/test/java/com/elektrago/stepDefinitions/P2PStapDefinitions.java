package com.elektrago.stepDefinitions;

import com.elektrago.pages.home.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class P2PStapDefinitions {
    HomePage homePage;
    
     @When("the user taps on the send option bottom menu")
    public void theUserTapsOnTheSendOptionBottomMenu() {
        if(homePage == null) {
            homePage = new HomePage();
        }

    }

    @When("the user clicks the add recipient button")
    public void theUserClicksTheAddRecipientButton() {
    }

    @Then("the user select the option Between Elektra Go Users in the send money options")
    public void theUserSelectTheOptionInTheSendMoneyOptions() {
    }

    @Then("the user will be able to see the new recipient in the list.")
    public void theUserWillBeAbleToSeeTheNewRecipientInTheList() {
    }

    @When("the user clicks the Add button")
    public void theUserClicksTheAddButton() {
    }

    @When("User fills in the Last Name field")
    public void userFillsInTheLastNameField() {
    }

    @When("User fills in the First name field")
    public void UserFillsInTheFirstNameField() {
    }

    @When("User fills in the Phone number field")
    public void UserFillsInThePhoneNumberField() {
    }
}
