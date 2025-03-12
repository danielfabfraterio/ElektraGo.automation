package com.elektrago.stepDefinitions;

import com.elektrago.pages.addrecipient.AddRecipientPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;

import static com.elektrago.utils.AppiumDriverFactory.getDriver;

public class AddRecipientStepDefinitions {
  AppiumDriver driver;
  AddRecipientPage addRecipientPage;

  @Given("on {string} adds recipient")
  public void addsRecipient(String device) {
    driver = getDriver(device);
    addRecipientPage = new AddRecipientPage();
    addRecipientPage.validateAddRecipientPage();
  }

  @Given("the user inputs mobile phone number: {string}")
  public void entersMobilePhoneNumber(String mobilePhoneNumber) {
    addRecipientPage.inputMobilePhoneNumber(mobilePhoneNumber);
  }

  @Given("the user inputs first name: {string}")
  public void entersFirstName(String firstName) {
    addRecipientPage.inputFirstName(firstName);
  }

  @Given("the user inputs middle name: {string}")
  public void entersMiddleName(String secondName) {
    addRecipientPage.inputMiddleName(secondName);
  }

  @Given("the user inputs last name: {string}")
  public void entersLastName(String lastName) {
    addRecipientPage.inputLastName(lastName);
  }

  @Given("the user inputs second last name: {string}")
  public void entersSecondLastName(String secondLastName) {
    addRecipientPage.inputSecondLastName(secondLastName);
  }


  @Given("the user taps on add button")
  public void tapsOnAddButton() {
    addRecipientPage.btnAdd();
  }
}
