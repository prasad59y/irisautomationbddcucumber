Feature: validating the actions in For me to Authorise page

  Scenario: Verify the Orders For Me To Authorise page
    Given user logins using the pinid "pres1"
    Then Click on the create order menu page
    And Validate the create order menu page
    Then enter the client surname "yar"
    And click on client search button
    And validate the client search results "yar"
    And Select the one of the client from the list
    Then click on the create delivery and select Add products
    Given Add the one item from the catalogue
    Then  Place the  Requisition
    And select the covid 19 check Questions
    Then Confirm the delivery instructions
#    Then Confirm the delivery instructions"Form exists"
    And Validate the order confirmation
    And Log out to the application
    Given user logins using the auth pinid "auth1"
    Then Validate the authorisation home page
    And Click on for me to Authorisation
    Then validate the Orders For Me To Authorise page
    When Click on Show ALL Orders Requiring Authorisation button
    Then validate the show standard view and filter by authoriser options
    And Select the latest UId
#    And Select the latest UId With date
    Then Authorise the order with post code
    And verify authorised UID is
    Then cancel the  order and verify order id in rejected list

