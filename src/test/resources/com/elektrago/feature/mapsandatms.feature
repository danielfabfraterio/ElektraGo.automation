Feature: Maps & ATM's

  Background:
    Given the app on "Android"
    ## When the user tap on Register or log in
    Then the Login Page is shows on the app
    And the user tap the link to use mobile number
    When the user select the mobile code "+1"
    And the user fill up the mobile field with "9096670041"
    And the password "Test2025!"
    When the user tap on the Log in button
    Then the app shows the wallet home page

  Scenario: Find Location
    Given Cost Calculator is displayed
    When Select Maps and ATMs
    Then Map with location is displayed
    When Tap on Find Location
    And Fill in with "Irving, Texas, EE.UU"
    Then Map is displayed with new location

  Scenario: Filter map with Add money with barcode
    Given Cost Calculator is displayed
    When Select Maps and ATMs
    Then Map with location is displayed
    When Tap on Find Location
    And Fill in with "Irving, Texas, EE.UU"
    Then Map is displayed with new location
    When Tap on Filter "Show all"
    And Select "Add money with barcode"
    Then Map is displayed with the selected filter "Add money with barcode"


  Scenario: Filter map with Add money with your card
    Given Cost Calculator is displayed
    When Select Maps and ATMs
    Then Map with location is displayed
    When Tap on Find Location
    And Fill in with "Irving, Texas, EE.UU"
    Then Map is displayed with new location
    When Tap on Filter "Show all"
    And Select "Add money with your card"
    Then Map is displayed with the selected filter "Add money with card"

  Scenario: Filter map with Withdraw Money
    Given Cost Calculator is displayed
    When Select Maps and ATMs
    Then Map with location is displayed
    When Tap on Find Location
    And Fill in with "Irving, Texas, EE.UU"
    Then Map is displayed with new location
    When Tap on Filter "Show all"
    And Select "Withdraw money (ATM)"
    Then Map is displayed with the selected filter "Withdraw (ATM)"

  Scenario: Generate barcode with 7 Eleven
    Given Cost Calculator is displayed
    When Select Maps and ATMs
    Then Map with location is displayed
    When Tap on Find Location
    And Fill in with "Irving, Texas, EE.UU"
    Then Map is displayed with new location
    When tap on Barcode button
    Then Show add cash from a store screen
    When tap on the Generate Code button
    When Select "7-Eleven" on the store list
    Then Create custom barcode alert is displayed
    When Select Create Code button
    Then Barcode screen is displayed

  Scenario: Generate barcode with CVS
    Given Cost Calculator is displayed
    When Select Maps and ATMs
    Then Map with location is displayed
    When Tap on Find Location
    And Fill in with "Irving, Texas, EE.UU"
    Then Map is displayed with new location
    When tap on Barcode button
    Then Show add cash from a store screen
    When tap on the Generate Code button
    When Select "CVS" on the store list
    Then Create custom barcode alert is displayed
    When Select Create Code button
    Then Barcode screen is displayed

  Scenario: Generate barcode with Walgreens
    Given Cost Calculator is displayed
    When Select Maps and ATMs
    Then Map with location is displayed
    When Tap on Find Location
    And Fill in with "Irving, Texas, EE.UU"
    Then Map is displayed with new location
    When tap on Barcode button
    Then Show add cash from a store screen
    When tap on the Generate Code button
    When Select "Walgreens" on the store list
    Then Create custom barcode alert is displayed
    When Select Create Code button
    Then Barcode screen is displayed

  Scenario: Generate barcode with Walmart
    Given Cost Calculator is displayed
    When Select Maps and ATMs
    Then Map with location is displayed
    When Tap on Find Location
    And Fill in with "Irving, Texas, EE.UU"
    Then Map is displayed with new location
    When tap on Barcode button
    Then Show add cash from a store screen
    When tap on the Generate Code button
    When Select "Walmart" on the store list
    Then Create custom barcode alert is displayed
    When Select Create Code button
    Then Barcode screen is displayed