Feature: Create new client

  Scenario Outline: create new client with all required details with example
    Given user logins using the pinid "pres1"
    Then Click on the create order menu page
    And Validate the create order menu page
    Then enter the client surname "yar"
    And click on client search button
    Then click on new client and enter details
    Then user enter details "<title>"and "<Forename>" and "<Dob>"and "<Surname>"and "<TeleNo>""<Ethinicity>"and "<GPcode>"
#Then enter pin code "ng9 6ng" and click on find button
    When Address not found with postalcode "<No>"and"<Street>"and"<Town>"and"<PostalCode>"
    Examples:
      | title | Forename | Dob        | Surname | TeleNo      | Ethinicity         | GPcode                                                     | No | Street | Town       | PostalCode |
      | Mr    | bes      | 10/03/1984 | ton     | 07312250122 | 01 - WHITE BRITISH | D81618 (Ailsworth Medical Centre)(32 Main Street)(PE5 7AP) | 2  | Mount  | Nottingham | Ng9 8bw    |
     | Mr    | chil     | 11/04/1985 | well    | 07372251122 | 01 - WHITE BRITISH | D81618 (Ailsworth Medical Centre)(32 Main Street)(PE5 7AP) | 7  | Mount  | Nottingham | Ng7 6bw    |
      | Mr    | chriss   | 18/03/1986 | harris  | 07312850122 | 01 - WHITE BRITISH | D81618 (Ailsworth Medical Centre)(32 Main Street)(PE5 7AP) | 9  | Mount  | Nottingham | Ng8 6NG    |

