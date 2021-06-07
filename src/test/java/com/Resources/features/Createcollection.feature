Feature: Create new Collection Item
  Scenario: Create new collections Item and create the new Order
    Given user logins using the pinid "pres1"
    Then Click on the create order menu page
    And Validate the create order menu page
    Then enter the client surname "yar"
    And click on client search button
    And validate the client search results "yar"
    And Select the one of the client from the list
    Then select Add Items for collections
    And Click on the Add product Button
    And Add the one item from the catalogue
    Then Accepct the delete popup window
    And select the Item from list and collectItem
    And confirm and place requisation

