Feature: Login

  Scenario: Login Sucessfully with Email
    Given the app on "iOS"
    When the user tap on Register or log in
    Then the Login Page is shows on the app
    When the user fill up the email "pruebasektgo@gmail.com"
    And the password "Test2024!"
    When the user tap on the Log in button
    #Then the app shows the lite home page

  Scenario: Login sucessfully with Mobile Number
    Given the app on "iOS"
    When the user tap on Register or log in
    Then the Login Page is shows on the app
    And the user tap the link to use mobile number
    When the user select the mobile code "+1"
    And the user fill up the mobile field with "9096670041"
    And the password "Test2025!"
    When the user tap on the Log in button
    #Then the app shows the wallet home page