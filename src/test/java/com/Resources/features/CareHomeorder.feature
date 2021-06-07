Feature: validating the actions in care home order page
  Scenario: Create the order for care home order
    Given user logins using the pinid "pres1"
    Then Click on the carehome order menu page
    And Validate the carehome order menu page
    Then enter the client surname "yar"
    And click on client search button
    And validate the client search results "yar"
    And Select the one of the client from the list
    Then Click on create home delivery and select add products
    And Add the one item from the catalogue
    Then  Place the  Requisition
    And select the covid 19 check Questions
    Then Confirm the delivery instructions
    And verify the delivery address for care home
    And Confirm and place the requisation to create order
    And Validate the order confirmation
    And Log out to the application


