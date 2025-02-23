package com.elektrago.stepDefinitions;

import com.elektrago.pages.choosearecipient.ChoosearecipientPage;
import com.elektrago.pages.gifselection.GifSelectionPage;
import com.elektrago.pages.home.HomePage;
import com.elektrago.pages.p2p.P2PPage;
import com.elektrago.pages.sendmoney.SendMoney;
import com.elektrago.utils.BaseUtils;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class P2PStapDefinitions {
    HomePage homePage;
    ChoosearecipientPage choosearecipientPage;
    SendMoney sendMoney;
    String nameBeneficiary;
    P2PPage p2pPage;
    GifSelectionPage gifSelectionPage;
    
     @When("the user taps on the send option bottom menu")
    public void theUserTapsOnTheSendOptionBottomMenu() {
        if(homePage == null) {
            homePage = new HomePage();
        }

    }

    @When("the user clicks the add recipient button")
    public void theUserClicksTheAddRecipientButton() {
        choosearecipientPage = new ChoosearecipientPage();
        BaseUtils.clickOnElement(choosearecipientPage.addButton);
    }

    @Then("the user select the option Between Elektra Go Users in the send money options")
    public void theUserSelectTheOptionInTheSendMoneyOptions() {
        sendMoney = new SendMoney();
        BaseUtils.clickOnElement(sendMoney.buttonP2P);
    }

    @Then("the user will be able to see the new recipient in the list.")
    public void theUserWillBeAbleToSeeTheNewRecipientInTheList() {
        choosearecipientPage.scrollToBeneficiary(nameBeneficiary);
    }

    @When("the user clicks the Add button")
    public void theUserClicksTheAddButton() {
        BaseUtils.clickOnElement(choosearecipientPage.addButton);
    }

    @When("User fills in the Last Name field")
    public void userFillsInTheLastNameField() {
        Faker faker = new Faker();
        BaseUtils.fillUpField(choosearecipientPage.firstNameField, faker.name().lastName());
    }

    @When("User fills in the First name field")
    public void UserFillsInTheFirstNameField() {
        Faker faker = new Faker();
        nameBeneficiary = faker.name().firstName();
        BaseUtils.fillUpField(choosearecipientPage.firstNameField, nameBeneficiary);
    }

    @When("User fills in the Phone number field")
    public void UserFillsInThePhoneNumberField() {
        Faker faker = new Faker();
        BaseUtils.fillUpField(choosearecipientPage.mobileNumberField, faker.phoneNumber().phoneNumber());
    }

    @When("User fills in the Phone number  with {string}")
    public void userFillsInThePhoneNumberWith(String number) {
        BaseUtils.fillUpField(choosearecipientPage.mobileNumberField, number);   
    }

    @Then("the user presses the Invite button")
    public void theUserPressesTheInviteButton() {
        choosearecipientPage.clickInviteButton(nameBeneficiary);
    }

    @Then("the user search the beneficiary {string}")
    public void theUserSearchTheBeneficiary(String beneficiaryName) {
        if(choosearecipientPage == null){
            choosearecipientPage = new ChoosearecipientPage();
        }
        BaseUtils.fillUpField(choosearecipientPage.seachBeneficiary, beneficiaryName);
    }

    @Then("the beneficiary is shows by the result of the searching")
    public void theBeneficiaryIsShowsByTheResultOfTheSearching() {
        BaseUtils.waitUntilElementisPresent(choosearecipientPage.resultBeneficiarySearch);
    }

    @Then("The user click on the result of the searching")
    public void theUserClickOnTheResultOfTheSearching() {
        BaseUtils.clickOnElement(choosearecipientPage.resultBeneficiarySearch);
    }

    @When("the user types the amount {string}")
    public void theUserTypesTheAmount(String amount) {
        p2pPage = new P2PPage();
        p2pPage.inputAmount.clear();
        BaseUtils.fillUpField(p2pPage.inputAmount, amount);
    }

    @Then("the app shows an error on the screen")
    public void theAppShowsAnErrorOnTheScreen() {
        BaseUtils.waitUntilElementisPresent(p2pPage.errorText);
    }

    @When("the user clicks on the continue button")
    public void theUserClicksOnTheContinueButton() {
        BaseUtils.waitUntilElementisPresent(p2pPage.buttonContinue);
        BaseUtils.clickOnElement(p2pPage.buttonContinue);
    }

    @When("the user clicks on the Send button")
    public void theUserClicksOnTheSendButton() {
        BaseUtils.waitUntilElementisPresent(p2pPage.sendButton);
        BaseUtils.clickOnElement(p2pPage.sendButton);
    }

    @Then("the app shows the confirmation Page")
    public void theAppShowsTheConfirmationPage() {
        BaseUtils.waitUntilElementisPresent(p2pPage.moneySent);
        BaseUtils.waitUntilElementisPresent(p2pPage.btnShare);
        BaseUtils.waitUntilElementisPresent(p2pPage.btnDone);
    }

    @Then("the user click on the Done button")
    public void theUserClickOnTheDoneButton() {
        BaseUtils.clickOnElement(p2pPage.btnDone);
    }

    @When("the user fills the description field")
    public void theUserFillsTheDescriptionField() {
        Faker fker = new Faker();
        BaseUtils.fillUpField(p2pPage.inputDescription, fker.lorem().paragraph());
    }

    @When("the user clicks the Gif icon")
    public void theUserClicksTheGifIcon() {
        BaseUtils.waitUntilElementIsClickable(p2pPage.gifButton);
        BaseUtils.clickOnElement(p2pPage.gifButton);
    }

    @Then("the user click on random Gif")
    public void theUserClickOnRandomGif() {
        gifSelectionPage = new GifSelectionPage();
        gifSelectionPage.selectRandomGif();
    }

    @When("the user clicks on Cancel button")
    public void theUserClicksOnCancelButton() {
        BaseUtils.clickOnElement(p2pPage.cancelButton);
    }
}
