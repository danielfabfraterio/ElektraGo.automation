Feature: Profile

Background:
    Given the app on "Android"
    ## When the user tap on Register or log in
    Then the Login Page is shows on the app
    And the user tap the link to use mobile number
    When the user select the mobile code "+1"
    And the user fill up the mobile field with "9096670041"
    And the password "Test2025!"
    When the user tap on the Log in button


  Scenario: Edit phone number - Call now
    Given the app shows the wallet home page
    Then the user taps on the icon profile button
    When the user taps on the My profile option
    And the user taps on the edit button next to the phone number
    Then the user taps on the call now button on the modal