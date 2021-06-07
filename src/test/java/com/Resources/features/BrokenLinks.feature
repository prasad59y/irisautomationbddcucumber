Feature: validating the Broken Links in Iris Application

  Scenario: Validate server errors and broken links in application
    Given user logins using the pinid "demo"
    Then Validate broken links in the page
    And Log out to the application