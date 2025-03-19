Feature: Change Password

  Scenario: Changes password for user
    Given on "iOS" the user enters ChangePassword password: "Test2023!"
    And the user enters ChangePassword password confirm: "Test2023!"
    Then the user taps on Change ChangePassword