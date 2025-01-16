Feature: Login Page Feature

  Scenario: Login Page Title
    Given User is on Login Page
    When User gets the title of the Page
    Then Title is "Login - My Shop"

  Scenario: Forgot Password link
    Given User is on Login Page
    Then Forgot your password link should be displayed

  Scenario: Login with correct credentials
    Given User is on Login Page
    When User enters email id as "aniketkothawade00@gmail.com"
    And User enters password as "Aniket@00"
    And User clicks on Login button
    Then User gets the title of the Page
    And Title is "My account - My Shop"

