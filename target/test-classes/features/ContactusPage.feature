Feature: Contact Us Page Feature

  Scenario Outline: Entering contact info with different data
    Given User navigates to contact us page
    When User fills the form with sheetname "<SheetName>"  and rownnumber <RowNumber>
    And User clicks on send button
    Then User gets successful message "Your message has been successfully sent to our team."

    Examples: 
      | SheetName | RowNumber |
      | contactus |         0 |
      | contactus |         1 |
      | contactus |         2 |
      | contactus |         3 |
