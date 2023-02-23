Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on the Sign in option
    And User enter email 'abdullah.bahir88@gmail.com' and password "Tek@12345"
    And User click on login button
    Then User should be logged in into Account

  
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Abdullah' and phone '4232328412'
    And User click on Update button
    Then User profile information should be updated
