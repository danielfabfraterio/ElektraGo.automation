Feature: Create password

  Scenario: Creates password for user
    Given on "iOS" the user enters password: "Test2025!"
    And the user enters password confirm: "Test2025!"
    Then the user taps on Continue CP