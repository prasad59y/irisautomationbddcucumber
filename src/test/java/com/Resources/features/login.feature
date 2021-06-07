Feature: Login Page scenario

  Scenario: Login Page valididation Check
    Given user logins using the pinid "pres1"
    Then Validate the home page
    And Log out to the application


