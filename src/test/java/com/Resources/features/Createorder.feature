Feature: Create Order Requisation


  Scenario: Validate Create order and search for the client
    Given user logins using the pinid "pres1"
    Then Click on the create order menu page
    And Validate the create order menu page
    Then enter the client surname "yar"
    And click on client search button
    And validate the client search results "yar"
    And Select the one of the client from the list
    Then click on the create delivery and select Add products
#    Scenario: Select the products Browse Catalogue
    Given select the Catalogue menu from the First List
    Then Add all the Items from the first catalogue
    And Validate all the Items in Basket List
    And Remove all Items from the List

#  Scenario: Add one item From catalogue and place Requisation
    Given Add the one item from the catalogue
    Then  Place the  Requisition
    And select the covid 19 check Questions
    Then Confirm the delivery instructions
    And Confirm and place the requisation to create order
#    Then Confirm the delivery instructions"Form exists"
    And Validate the order confirmation
