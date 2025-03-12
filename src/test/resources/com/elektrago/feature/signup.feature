Feature: Sign up

  Scenario: Fills SignUp data
    Given on "iOS" using email "a+2503051205@axented.com"
    Given using phone number "2503051205"
    Then the user taps on Continue