Feature: Create new client

  Scenario: create new client with all required details
    Given user logins using the pinid "pres1"
    Then Click on the create order menu page
    And Validate the create order menu page
    Then enter the client surname "yar"
    And click on client search button
    Then click on new client and enter details
    Then User enter the following client details
      | Mr | Chriss | 17/03/1982 | Harris | 07311252711 | 01 - WHITE BRITISH | D81618 (Ailsworth Medical Centre)(32 Main Street)(PE5 7AP) |
#    Then enter pin code "ng9 8bw" and click on find button
        When Address not found with postalcode
      | 34 | Toton | nottingham | NG9 6jb |
#    And Log out to the application




