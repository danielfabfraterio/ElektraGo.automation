Feature: Forgot Password Process

Scenario: Forgot Password Process
    Given the app on "iOS"
    When the user tap on Register or log in
    Then the Login Page is shows on the app
    When the user fill up the email "a+2503051207@fraternitas.io"
    And the user taps on the Forgot Password button
    Given on "iOS" FPVE the user enters verification code "000000"
     Given on "iOS" the user enters ChangePassword password: "Test2019!"
     And the user enters ChangePassword password confirm: "Test2019!"
    Then the user taps on Change ChangePassword
  Given on "iOS" the user sees the Change Password Success Page
  Then the user taps on Back to login
     And the password "Test2019!"
     When the user tap on the Log in button
