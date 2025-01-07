Feature: Send Now

  Scenario: Send Now
    Given the user fills promo code "Mexico" "PACO"
    Given the user taps on send now button

  Scenario: Send Now (GT)
    Given the user fills promo code "Guatemala" "PACO"
    Given the user taps on send now button
