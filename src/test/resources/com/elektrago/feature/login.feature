Feature: Login

  Scenario: Login Sucessfully
    Given the app on "Android"
    When the user tap on Register or log in
    Then the Sign up Lite is shows on the app
    And the user tap on the link log in here
    When the user fill up the email "pruebasektgo@gmail.com"
    And the password "Test2024!"
    When the user tap on the Log in button
    Then the app shows the lite home page
