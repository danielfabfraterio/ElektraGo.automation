Feature: Remittance Process

    Scenario: Selecting amount and Tapping on Let's Send
        Given the user fills up the amount to make the remittance on "iOS" for "3000"
        Then the user taps on Let's Send

    Scenario: Choose a recipient
        Given the user taps on the first recipient available on iOS

    Scenario: Confirm recipient
        Given the user taps on confirm button

    Scenario: Selects delivery method
#        Direct to bank
#        The user selects State
        Given the user taps on select institution
        Then the user selects an institution
        Then the user taps on continue button

    Scenario: Selects payment method
        Given the user taps on wallet button

    Scenario: Send Now
        Given the user taps on send now button