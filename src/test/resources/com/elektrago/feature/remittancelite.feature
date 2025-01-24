Feature: Remittance Lite

Background: 
  Given the app on "iOS"
  When the user tap on Register or log in
  Then the Login Page is shows on the app
  When the user fill up the email "yekiro4211@modotso.com"
  And the password "Test2025!"
  When the user tap on the Log in button

Scenario: Load test data and run cases
  Given test data is loaded from JSON data file
  Then run Remittance Lite tests