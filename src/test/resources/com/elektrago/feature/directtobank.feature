Feature: Direct to bank

  Scenario: Selects Direct to bank
    Given the user fills up the account number "0123456789909192"
    When the user taps on select sender id type
    When the user taps on chosen sender id type
    When the user fills up the sender id number "0123456789"
    Then the user taps on continue button DTB

  Scenario: Selects Direct to bank (GT)
    Given the user fills up the account number "0123456789"
    When the user taps on select sender id type
    When the user taps on chosen sender id type
    When the user fills up the sender id number "0123456789"
    Then the user taps on continue button DTB
