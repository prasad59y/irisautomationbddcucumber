Feature: Create new Special Item
  Scenario: Create new Special Item and create the new Order
    Given user logins using the pinid "pres1"
    Then Click on the create order menu page
    And Validate the create order menu page
    Then enter the client surname "yar"
    And click on client search button
    And validate the client search results "yar"
    And Select the one of the client from the list
    Then click on the create delivery and select Add products
    And click on Create Special Order
    And Enter all required mandatory details
    |Test_QA|Complex care/high risk to carers|Accessory|Adult Mobility|Test|100|testing the specials|
    Then Attach the Quote here and add to basket
    And  Place the  Requisition
    And select the covid 19 check Questions
    Then Confirm the delivery instructions
    And Validate the order confirmation

