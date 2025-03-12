Feature: Onboarding Lite iOS

  Scenario: Successful Registration
    Given the user tap on Register or log in
    Given the user fills login info
    Given the user fills personal data
    Then the app shows the lite home page

  Scenario: Test all registration cases
    Given the user tap on Register or log in
    Then test all registration cases ending with success
