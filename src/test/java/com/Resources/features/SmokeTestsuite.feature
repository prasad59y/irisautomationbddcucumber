Feature: Execute all smoke Test scenarios for the Application

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
#    Scenario: Add one item From catalogue and place Requisation
    Given Add the one item from the catalogue
    Then  Place the  Requisition
     And select the covid 19 check Questions
    Then Confirm the delivery instructions
    And Confirm and place the requisation to create order
# Then Confirm the delivery instructions"Form exists"
    And Validate the order confirmation

  Scenario: create new client with all required details
    Given user logins using the pinid "pres1"
    Then Click on the create order menu page
    And Validate the create order menu page
    Then enter the client surname "yar"
    And click on client search button
    Then click on new client and enter details
    And Validate the new client Page
    Then User enter the following client details
      | Mr | Chriss | 17/03/1982 | Harris | 07311252711 | 01 - WHITE BRITISH | D81618 (Ailsworth Medical Centre)(32 Main Street)(PE5 7AP) |
#    Then enter pin code "ng9 8bw" and click on find button
    When Address not found with postalcode
      | 34 | Toton | nottingham | NG9 6jb |
#    And Log out to the application



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
    And  Confirm and place the requisation to create order
    And Validate the order confirmation

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
    And  Confirm and place the requisation to create order
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
    And cancel the  order and verify order id in rejected list
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

