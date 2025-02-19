Feature: P2P

Background:
    Given the app on "Android"
    ## When the user tap on Register or log in
    Then the Login Page is shows on the app
    And the user tap the link to use mobile number
    When the user select the mobile code "+1"
    And the user fill up the mobile field with "8886797138"
    And the password "Test2025!"
    When the user tap on the Log in button
    Then the app shows the wallet home page

Scenario: Add Recipient - Manual
When the user taps on the send option bottom menu
Then the user select the option Between Elektra Go Users in the send money options
When the user clicks the add recipient button
And User fills in the Phone number field
And User fills in the First name field
And User fills in the Last Name field
When the user clicks the Add button
Then the user will be able to see the new recipient in the list. 