Feature: Regression tests

  Scenario: Onboarding + Auth + Remittance
    Given Run regression Case 1

  Scenario: Passwordless login
    Given Run Passwordless login

  Scenario: Password login
    Given Run Password login

  Scenario: Remittance Cash Pickup
    Given Run Remittance Cash Pickup

  Scenario: Remittance Cancel Receipt
    Given Run Remittance Cancel Receipt

  Scenario: Forgot password
    Given the app on "iOS" run Forgot password