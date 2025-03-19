package com.elektrago.stepDefinitions;

import java.io.File;
import java.io.IOException;

import com.github.javafaker.Faker;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RemittanceProcessStepDefinitions {
    LoginStepDefinitions loginStepDefinitions = new LoginStepDefinitions();
    RemittanceStepDefinitions remittanceStepDefinitions = new RemittanceStepDefinitions();
    ChoosearecipientStepDefinitions choosearecipientStepDefinitions = new ChoosearecipientStepDefinitions();
    AddRecipientStepDefinitions addRecipientStepDefinitions = new AddRecipientStepDefinitions();
    RecipientStepDefinitions recipientStepDefinitions = new RecipientStepDefinitions();
    ConfirmrecipientStepDefinitions confirmrecipientStepDefinitions = new ConfirmrecipientStepDefinitions();
    DeliverymethodStepDefinitions deliverymethodStepDefinitions = new DeliverymethodStepDefinitions();
    DirecttobankStepDefinitions directtobankStepDefinitions = new DirecttobankStepDefinitions();
    PayerBranchStepDefinitions payerbranchStepDefinitions = new PayerBranchStepDefinitions();
    PaymentmethodStepDefinitions paymentmethodStepDefinitions = new PaymentmethodStepDefinitions();
    CarddetailsStepDefinitions carddetailsStepDefinitions = new CarddetailsStepDefinitions();
    ReviewandsendStepDefinitions reviewandsendStepDefinitions = new ReviewandsendStepDefinitions();
    private JsonNode platformsData;
    private JsonNode remittancesData;

    @Given("test data is loaded from JSON data file")
    public void loadTestData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFilePlatforms = new File("src/test/java/com/elektrago/testData/platforms.json");
        File jsonFileRemittances = new File("src/test/java/com/elektrago/testData/remittances.json");

        platformsData = objectMapper.readTree(jsonFilePlatforms);
        remittancesData = objectMapper.readTree(jsonFileRemittances);
    }

    @Then("run Remittance tests")
    public void runRemittanceTests() {
        String platform = platformsData.get("platforms").get(0).get("name").asText();

        for (JsonNode remittanceData : remittancesData.get("remittances").get(0).get("cases")) {
            String country = remittanceData.get("country").asText();
            String amount = remittanceData.get("amount").asText();
            String deliveryMethod = remittanceData.get("deliveryMethod").asText();
            String state = remittanceData.get("state").asText();
            String institution = remittanceData.get("institution").asText();
            Boolean isAdditionalFieldRequired = remittanceData.get("isAdditionalFieldRequired").asBoolean();
            Boolean isPayerBranchRequired = remittanceData.get("isPayerBranchRequired").asBoolean();
            String paymentMethod = remittanceData.get("paymentMethod").asText();
            String accountNumber = remittanceData.get("accountNumber").asText();
            String senderIdNumber = remittanceData.get("senderIdNumber").asText();
            String promoCode = remittanceData.get("promoCode").asText();

            remittanceSetup(platform, country, amount);

            choosearecipient();

            confirmRecipient();

            if (deliveryMethod.equals("Cash Pickup")) {
                deliveryMethodCashPickup(state, institution);
            }

            if (deliveryMethod.equals("Account Credit")) {
                deliveryMethodAccountCredit(state, institution, accountNumber, senderIdNumber);
            }
            if (deliveryMethod.equals("Direct to App")) {
                deliveryMethodDirectToApp(state, institution);
                break;
            }

            if (isPayerBranchRequired) {
                payerBranch();
            }

            paymentMethodSteps(platform, paymentMethod);

            reviewAndSend(country, promoCode);
        }

        loginStepDefinitions.theUserLogsOut();
    }

    @Then("run Remittance Lite tests")
    public void runRemittanceLiteTests() {
        String platform = platformsData.get("platforms").get(0).get("name").asText();

        for (JsonNode remittanceData : remittancesData.get("remittances").get(1).get("cases")) {
            String country = remittanceData.get("country").asText();
            String amount = remittanceData.get("amount").asText();
            String deliveryMethod = remittanceData.get("deliveryMethod").asText();
            String state = remittanceData.get("state").asText();
            String institution = remittanceData.get("institution").asText();
            Boolean isAdditionalFieldRequired = remittanceData.get("isAdditionalFieldRequired").asBoolean();
            Boolean isPayerBranchRequired = remittanceData.get("isPayerBranchRequired").asBoolean();
            String paymentMethod = remittanceData.get("paymentMethod").asText();
            String accountNumber = remittanceData.get("accountNumber").asText();
            String senderIdNumber = remittanceData.get("senderIdNumber").asText();
            String promoCode = remittanceData.get("promoCode").asText();

            remittanceSetup(platform, country, amount);
            recipient(platform);
            if (deliveryMethod.equals("Cash Pickup")) {
                deliveryMethodCashPickup(state, institution);
            }
            if (deliveryMethod.equals("Account Credit")) {
                deliveryMethodAccountCredit(state, institution, accountNumber, senderIdNumber);
            }
            if (deliveryMethod.equals("Direct to App")) {
                deliveryMethodDirectToApp(state, institution);
                break;
            }
            if (deliveryMethod.equals("Home Delivery")) {
                deliveryMethodHomeDelivery(state, institution);
                break;
            }
            if (isPayerBranchRequired) {
                payerBranch();
            }
            paymentMethodStepsLite(paymentMethod);
            reviewAndSendLite(country, promoCode);
//            TODO Add Cancel Remittance proccess
        }
    }

    @Then("run first test Remittance Lite")
    public void runFirstTestRemittanceLite() {
        Faker faker = new Faker();
        String platform = platformsData.get("platforms").get(0).get("name").asText();

        String country = remittancesData.get("remittances").get(1).get("cases").get(0).get("country").asText();
        String amount = remittancesData.get("remittances").get(1).get("cases").get(0).get("amount").asText();
        String deliveryMethod = remittancesData.get("remittances").get(1).get("cases").get(0).get("deliveryMethod").asText();
        String state = remittancesData.get("remittances").get(1).get("cases").get(0).get("state").asText();
        String institution = remittancesData.get("remittances").get(1).get("cases").get(0).get("institution").asText();
        Boolean isAdditionalFieldRequired = remittancesData.get("remittances").get(1).get("cases").get(0).get("isAdditionalFieldRequired").asBoolean();
        Boolean isPayerBranchRequired = remittancesData.get("remittances").get(1).get("cases").get(0).get("isPayerBranchRequired").asBoolean();
        String recipientPhoneNumber = faker.phoneNumber().cellPhone();
        String recipientFirstName = faker.name().firstName();
        String recipientMiddleName = faker.name().firstName();
        String recipientLastName = faker.name().lastName();
        String recipientSecondLastName = faker.name().lastName();
        String paymentMethod = remittancesData.get("remittances").get(1).get("cases").get(0).get("paymentMethod").asText();
        String accountNumber = remittancesData.get("remittances").get(1).get("cases").get(0).get("accountNumber").asText();
        String senderIdNumber = remittancesData.get("remittances").get(1).get("cases").get(0).get("senderIdNumber").asText();
        String promoCode = remittancesData.get("remittances").get(1).get("cases").get(0).get("promoCode").asText();
        remittanceSetup(platform, country, amount);
        createRecipient(platform, recipientPhoneNumber, recipientFirstName, recipientMiddleName, recipientLastName, recipientSecondLastName);
        recipient(platform);
        if (deliveryMethod.equals("Cash Pickup")) {
            deliveryMethodCashPickup(state, institution);
        }

        if (deliveryMethod.equals("Account Credit")) {
            deliveryMethodAccountCredit(state, institution, accountNumber, senderIdNumber);
        }
        if (deliveryMethod.equals("Direct to App")) {
            deliveryMethodDirectToApp(state, institution);
        }
        if (deliveryMethod.equals("Home Delivery")) {
            deliveryMethodHomeDelivery(state, institution);
        }

        if (isPayerBranchRequired) {
            payerBranch();
        }

        paymentMethodStepsLite(paymentMethod);
        cardDetails(platform, "4895142232120006", "12/31", "321");
        reviewAndSendLite(country, promoCode);
    }

    private void reviewAndSend(String country, String promoCode) {
        reviewandsendStepDefinitions.theUserFillsPromoCode(country, promoCode);
        reviewandsendStepDefinitions.theUserTapsOnSendNowButton();
        reviewandsendStepDefinitions.theUserTapsOnGotIt();
        reviewandsendStepDefinitions.theUserTapsOnCancel();
    }

    private void reviewAndSendLite(String country, String promoCode) {
        reviewandsendStepDefinitions.theUserFillsPromoCode(country, promoCode);
        reviewandsendStepDefinitions.theUserTapsOnSendNowButton();
        reviewandsendStepDefinitions.theUserTapsOnGotIt();
        reviewandsendStepDefinitions.theUserTapsOnCancel();
    }

    private void cardDetails(String platform, String cardNumber, String expiration, String cvv) {
        carddetailsStepDefinitions.theUserEntersCardNumber(platform, cardNumber);
        carddetailsStepDefinitions.theUserEntersExpirationDate(expiration);
        carddetailsStepDefinitions.theUserEntersCVV(cvv);
        carddetailsStepDefinitions.theUserTapsOnContinueButtonCD();
    }

    private void paymentMethodSteps(String platform, String paymentMethod) {
        if (paymentMethod.equals("WALLET")) {
            paymentmethodStepDefinitions.theUserTapsOnWalletButton();
        }

        if (paymentMethod.equals("Saved Card")) {
            paymentmethodStepDefinitions.theUserTapsOnTheFirstCardAvailable();
            cardDetails(platform, "4000056655665556", "12/29", "123");
        }

        if (paymentMethod.equals("New Card")) {
            paymentmethodStepDefinitions.theUserTapsOnNewCardButton();
            cardDetails(platform, "4000056655665556", "12/29", "124");
        }

        if (paymentMethod.equals("Apple Pay")) {
            paymentmethodStepDefinitions.theUserTapsOnApplePayButton();
        }
    }

    private void paymentMethodStepsLite(String paymentMethod) {
        if (paymentMethod.equals("Saved Card")) {
            paymentmethodStepDefinitions.theUserTapsOnTheFirstCardAvailableLite();
        }

        if (paymentMethod.equals("New Card")) {
            paymentmethodStepDefinitions.theUserTapsOnNewCardButton();
        }
    }

    private void payerBranch() {
        payerbranchStepDefinitions.theUserTapsOnPayerBranch();
        payerbranchStepDefinitions.theUserTapsOnContinueButton();
        payerbranchStepDefinitions.theUserTapsOnConfirmButton();
    }

    private void confirmRecipient() {
        confirmrecipientStepDefinitions.theUserTapsOnConfirmButton();
    }

    private void directToBank(String accountNumber, String institution, String senderIdNumber) {
        directtobankStepDefinitions.theUserFillsUpTheAccountNumber(accountNumber);
        if (!institution.equals("Banco Azteca")) {
            directtobankStepDefinitions.theUserTapsOnSelectSenderIdType();
            directtobankStepDefinitions.theUserTapsOnDRIVERSLICENSE();
            directtobankStepDefinitions.theUserFillsUpTheSenderIdNumber(senderIdNumber);
        }
        directtobankStepDefinitions.theUserTapOnContinueButtonDTB();
    }

    private void deliveryMethod(String state, String institution) {
        deliverymethodStepDefinitions.theUserTapsOnRecipientsState();
        deliverymethodStepDefinitions.theUserFillsUpTheState(state);
        deliverymethodStepDefinitions.theUserTapsOnFilteredState();
        deliverymethodStepDefinitions.theUserTapsOnSelectInstitution();
        deliverymethodStepDefinitions.theUserFillsUpTheInstitution(institution);
        deliverymethodStepDefinitions.theUserTapsOnFilteredInstitution();
        deliverymethodStepDefinitions.theUserTapsOnContinueButton();
    }

    private void deliveryMethodDirectToApp(String state, String institution) {
        deliverymethodStepDefinitions.theUserTapsOnDirectToApp();

        deliveryMethod(state, institution);
    }

    private void deliveryMethodHomeDelivery(String state, String institution) {
        deliverymethodStepDefinitions.theUserTapsOnHomeDelivery();

        deliveryMethod(state, institution);
    }

    private void deliveryMethodCashPickup(String state, String institution) {
        deliverymethodStepDefinitions.theUserTapsOnCashPickup();

        deliveryMethod(state, institution);
    }

    private void deliveryMethodAccountCredit(String state, String institution, String accountNumber,
            String senderIdNumber) {
        deliverymethodStepDefinitions.theUserTapsOnDirectToBank();

        deliveryMethod(state, institution);

        directToBank(accountNumber, institution, senderIdNumber);
    }

    private void recipient(String platform) {
        recipientStepDefinitions.theUserTapsOnAddedRecipient(platform);
    }

    private void createRecipient(String platform, String recipientPhoneNumber, String recipientFirstName, String recipientMiddleName, String recipientLastName, String recipientSecondLastName) {
        addRecipientStepDefinitions.addsRecipient(platform);
        addRecipientStepDefinitions.entersMobilePhoneNumber(recipientPhoneNumber);
        addRecipientStepDefinitions.entersFirstName(recipientFirstName);
        addRecipientStepDefinitions.entersMiddleName(recipientMiddleName);
        addRecipientStepDefinitions.entersLastName(recipientLastName);
        addRecipientStepDefinitions.entersSecondLastName(recipientSecondLastName);
        addRecipientStepDefinitions.tapsOnAddButton();
    }

    private void choosearecipient() {
        choosearecipientStepDefinitions.theUserTapsOnTheFirstRecipientAvailableOn();
    }

    private void remittanceSetup(String platform, String country, String amount) {
        remittanceStepDefinitions.theUserSelectsCountry(platform, country);
        remittanceStepDefinitions.theUserFillsUpTheAmountToMakeTheRemittance(amount);
        remittanceStepDefinitions.theUserTapsOnLetsSend();
    }
}
