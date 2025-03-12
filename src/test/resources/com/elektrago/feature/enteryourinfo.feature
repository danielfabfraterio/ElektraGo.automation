Feature: Enter your information

  Scenario: Enters personal info
    Given on "iOS"
    Given the user enters FirstName: "FirstName", SecondName: "SecondName", LastName: "LastName", SecondLastName: "SecondLastName"
    Given the user enters DOB: "24" "June" "2000"
    Given the user enters address: Street and number "123 Fake Street", Building or apartment "A"
    Then the user taps on Continue EYI