Feature: Accounts Page Feature

  Background: 
    Given user has already logged into the application
      | username                    | password  |
      | aniketkothawade00@gmail.com | Aniket@00 |

  Scenario: Accounts Page title
    Given user is on accounts page
    When User gets the title of the Page
    Then Title is "My account - My Shop"

  Scenario: Accounts Page section
    Given user is on accounts page
    Then user gets the accounts section
      | ADD MY FIRST ADDRESS      |
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | Home                      |
    And user section count is 6
