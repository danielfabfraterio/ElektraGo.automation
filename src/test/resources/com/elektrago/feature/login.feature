Feature: Login

Scenario: Login Successfully with Email
  Given the app on "iOS"
  When the user tap on Register or log in
  Then the Login Page is shows on the app
  And the user taps use email instead
  When the user fill up the email "a+2503051207@fraternitas.io"
  And the password "Test2020!"
  When the user tap on the Log in button

Scenario: Login successfully with Mobile Number
  Given the app on "iOS"
  When the user tap on Register or log in
  Then the Login Page is shows on the app
  And the user tap the link to use mobile number
  When the user select the mobile code "+1"
  And the user fill up the mobile field with "2503051207"
  And the password "Test2020!"
  When the user tap on the Log in button

Scenario: Login with invalid credentials with email
Given the app on "iOS"
When the user tap on Register or log in
Then the Login Page is shows on the app
When the user fill up the email "pruebasektgo@gmail.com"
And the password "Test2023!"
When the user tap on the Log in button
Then the app shows an error message related to username or password

Scenario: Login with invalid credentials with email
Given the app on "iOS"
When the user tap on Register or log in
Then the Login Page is shows on the app
And the user tap the link to use mobile number
When the user select the mobile code "+1"
And the user fill up the mobile field with "9096670041"
And the password "Test2025!"
When the user tap on the Log in button
Then the app shows an error message related to username or password

Scenario: Login after onboarding
  Given the app on "iOS"
  When the user tap on Register or log in
  Then the Login Page is shows on the app
  When the user fill up the email "a+2503051226@fraternitas.io"
  Given the app on "iOS" LOTC
  Then on "iOS" the user enters one-time code "000000"

#  TODO Login after onboarding with mobile number
