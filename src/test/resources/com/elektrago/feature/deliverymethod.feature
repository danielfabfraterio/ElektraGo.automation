Feature: Delivery method

  Scenario: Selects Cash Pickup
    Given the user taps on Cash Pickup
    When the user taps on Recipient's state
    When the user fills up the state "Baja"
    When the user taps on filtered state
    When the user taps on select institution
    Then the user fills up the institution "Banorte"
    Then the user taps on filtered institution
    Then the user taps on continue button

  Scenario: Selects Direct to Bank
    Given the user taps on Direct to bank
    When the user taps on Recipient's state
    When the user fills up the state "Campeche"
    When the user taps on filtered state
    When the user taps on select institution
    Then the user fills up the institution "BBVA"
    Then the user taps on filtered institution
    Then the user taps on continue button

  Scenario: Selects Direct to App
    Given the user taps on Direct to App
    When the user taps on Recipient's state
    When the user fills up the state "Durango"
    When the user taps on filtered state
    When the user taps on select institution
    Then the user fills up the institution "Banorte"
    Then the user taps on filtered institution
    Then the user taps on continue button

  Scenario: Selects Cash Pickup (GT)
    Given the user taps on Cash Pickup
    When the user taps on Recipient's state
    When the user fills up the state "Escuintla"
    When the user taps on filtered state
    When the user taps on select institution
    Then the user fills up the institution "GyT Continental"
    Then the user taps on filtered institution
    Then the user taps on continue button

  Scenario: Selects Account Credit (GT)
    Given the user taps on Direct to bank
    When the user taps on Recipient's state
    When the user fills up the state "Chimaltenango"
    When the user taps on filtered state
    When the user taps on select institution
    Then the user fills up the institution "Banrural"
    Then the user taps on filtered institution
    Then the user taps on continue button
