Feature: Onboarding lite

    Scenario: Onboarding Lite Sucessfully
        Given the app on "ANDROID" 
        When the user tap on Register or log in
        Then the Login Page is shows on the app
        When the user tap on Sign up here
        Then the Sign Up Page it shows on the app
        When the user fill up the email "pruebasektgo@gmail.com"
        And the user fill up the mobile field with "+15167288721"
        When the user tap on the Continue button
        Then the Offers and exclusives Nodal it shows on the app
        When the user tap on the Continue button
        Then the Verify your email Page it shows on the app
        When the user fill up the verification code with "000000"
        Then the Enter your information Page it shows on the app
        When the user fill up the First name with "Random"
        And the user fill up the First lastname with "Test"
        And the user fill up the Date of birth "12-12-1994"
        When the user tap on the Continue button
        Then the Enter your address Page it shows on the app
        When the user fill up the Street address with "5525 North MacArthur Boulevard"
        And the user tap on the Continue button
        Then the Create password Page it shows on the app
        When the user fill up the Enter your password with "Test2023!"
        And the user fill up the Confirm password with "Test2023!"
        When the user tap on the Create button
        # Then the Almost there! Page it shows on the app
        # When the user tap on Take selfie button 
        # Then the Get Ready! Page it shows on the app
        # When the user taps on the Im ready button
        # Then the app shows the lite home page 


        





