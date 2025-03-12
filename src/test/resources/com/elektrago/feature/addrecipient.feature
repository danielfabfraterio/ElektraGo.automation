Feature: Add Recipient

  Scenario: Adds recipient
    Given on "iOS" adds recipient
    Given the user inputs mobile phone number: "2503051099"
    Given the user inputs first name: "RFirst"
    Given the user inputs middle name: "RSecond"
    Given the user inputs last name: "RLast"
    Given the user inputs second last name: "RSecondLast"
    When the user taps on add button