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
And User fills in the Phone number  with "5548102532"
And User fills in the First name field
And User fills in the Last Name field
When the user clicks the Add button
Then the user will be able to see the new recipient in the list. 

Scenario: Add Recipient - Invite user
When the user taps on the send option bottom menu
Then the user select the option Between Elektra Go Users in the send money options
When the user clicks the add recipient button
And User fills in the Phone number field 
And User fills in the First name field
And User fills in the Last Name field
When the user clicks the Add button
Then the user presses the Invite button

Scenario: Search Beneficiary on the List
When the user taps on the send option bottom menu
Then the user select the option Between Elektra Go Users in the send money options
And the user search the beneficiary "Daniel Lopez"
Then the beneficiary is shows by the result of the searching

Scenario: Verify amount limits (maximum and minimum)
When the user taps on the send option bottom menu
Then the user select the option Between Elektra Go Users in the send money options
And the user search the beneficiary "Daniel Lopez"
Then the beneficiary is shows by the result of the searching
And The user click on the result of the searching
When the user types the amount "0.01"
Then the app shows an error on the screen
When the user types the amount "600"
Then the app shows an error on the screen

Scenario: Send P2P Successfully
When the user taps on the send option bottom menu
Then the user select the option Between Elektra Go Users in the send money options
And the user search the beneficiary "Daniel Lopez"
Then the beneficiary is shows by the result of the searching
And The user click on the result of the searching
When the user types the amount "1.00"
And the user clicks on the continue button
When the user clicks on the Send button
Then the app shows the confirmation Page
And the user click on the Done button


Scenario: Send P2P with description Successfully
When the user taps on the send option bottom menu
Then the user select the option Between Elektra Go Users in the send money options
And the user search the beneficiary "Daniel Lopez"
Then the beneficiary is shows by the result of the searching
And The user click on the result of the searching
When the user types the amount "1.00"
And the user clicks on the continue button
And the user fills the description field
When the user clicks on the Send button
Then the app shows the confirmation Page
And the user click on the Done button

Scenario: Send P2P with description and GIF Successfully
When the user taps on the send option bottom menu
Then the user select the option Between Elektra Go Users in the send money options
And the user search the beneficiary "Daniel Lopez"
Then the beneficiary is shows by the result of the searching
And The user click on the result of the searching
When the user types the amount "1.00"
And the user clicks on the continue button
And the user fills the description field
And the user clicks the Gif icon
When the user clicks on the Send button
Then the app shows the confirmation Page
And the user click on the Done button