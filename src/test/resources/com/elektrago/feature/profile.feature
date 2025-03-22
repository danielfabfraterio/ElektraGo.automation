Feature: Profile

Background:
    Given the app on "Android"
    ## When the user tap on Register or log in
    Then the Login Page is shows on the app
    And the user tap the link to use mobile number
    When the user select the mobile code "+1"
    And the user fill up the mobile field with "8886797138"
    And the password "Test2025!"
    When the user tap on the Log in button


  Scenario: Edit phone number - Call now
    Given the app shows the wallet home page
    Then the user taps on the icon profile button
    When the user taps on the My profile option
    And the user taps on the edit button next to the phone number
    Then the user taps on the call now button on the modal

  Scenario: Edit phone number - Later
    Given the app shows the wallet home page
    Then the user taps on the icon profile button
    When the user taps on the My profile option
    And the user taps on the edit button next to the phone number
    Then the user taps on the later button on the modal

  Scenario: Edit email - Call now
    Given the app shows the wallet home page
    Then the user taps on the icon profile button
    When the user taps on the My profile option
    And the user taps on the edit button next to the email
    Then the user taps on the call now button on the modal

  Scenario: Edit email - Later
    Given the app shows the wallet home page
    Then the user taps on the icon profile button
    When the user taps on the My profile option
    And the user taps on the edit button next to the email
    Then the user taps on the later button on the modal


  Scenario: Edit Password - Use a previous Password
    Given the app shows the wallet home page
    Then the user taps on the icon profile button
    When the user taps on the My profile option
    And the user taps on the edit button next to the hidden password
    When the user fills up the current password "Test2025!"
    And the user fill up the new password "Test2025!"
    And the user confirms the new password "Test2025!"
    When the user taps on continue button on Change Password
    Then the apps shows the modal

  Scenario: Edit Password - Enter Password that does not meet requirements
      Given the app shows the wallet home page
      Then the user taps on the icon profile button
      When the user taps on the My profile option
      And the user taps on the edit button next to the hidden password
      When the user fills up the current password "Test2025!"
      And the user fill up the new password "Test2025"
      And the user confirms the new password "Test2025"
      Then the Change password button is not enabled

  Scenario: Edit Password - Enter Password that does not meet requirements
      Given the app shows the wallet home page
      Then the user taps on the icon profile button
      When the user taps on the My profile option
      And the user taps on the edit button next to the hidden password
      When the user fills up the current password "Test2025!"
      And the user fill up the new password "Test2024!"
      And the user confirms the new password "Test2026!"
      Then the apps shows an error message

  Scenario: Edit Password - Enter Password that does not meet requirements
      Given the app shows the wallet home page
      Then the user taps on the icon profile button
      When the user taps on the My profile option
      And the user taps on the edit button next to the hidden password
      When the user fills up the current password "Test2025!"
      And the user fill up the new password "Test2026!"
      And the user confirms the new password "Test2026!"
      When the user taps on continue button on Change Password
      Then the app shows the password updated successfully
