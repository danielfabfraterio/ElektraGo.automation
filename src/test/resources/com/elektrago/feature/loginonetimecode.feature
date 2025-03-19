Feature: Login with one time code

  Scenario: Login Successfully with one time code
    Given the app on "iOS" LOTC
    Given on "iOS" the user enters one-time code "000000"