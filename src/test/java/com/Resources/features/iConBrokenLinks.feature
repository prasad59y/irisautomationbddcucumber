Feature: validating the Broken Links in icon Application

  Scenario: Validate server errors and broken links in icon application
    Given user logins using the iconpinid "demo"
    Then Validate broken links in the page
    And Log out to the application