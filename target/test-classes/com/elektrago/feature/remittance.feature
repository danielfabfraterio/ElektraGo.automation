Feature: Remittance

  Scenario: Successful Remittance
    Given on "iOS" the user selects country "Mexico"
    Given the user fills up the amount to make the remittance for "3000"
    Then the user taps on Let's Send

  Scenario: Selects country, state and payer branch
    Given on "iOS" the user selects country "Guatemala"
    Given the user fills up the amount to make the remittance for "3001"
    Then the user taps on Let's Send
