@test
Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on the Sign in option
    And User enter email 'maryamh@gmail.com' and password "Tek@12345"
    And User click on login button
    And User should be logged in into Account
    Then User click on Account option

  Scenario: Verify User can update Profile Information
    And User update Name 'Maryamh' and phone '4232328254'
    And User click on Update button
    Then User profile information should be updated

  Scenario: Verify User can add a payment method
    And User click on add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 3456876523459762 | Maryam     |              10 |           2025 |          587 |
    And User click on add your card button
    Then A message should be displayed 'Payment Method added sucessfully'

  Scenario: Verify User can edit Debit or Credit card
    And User click on bank card
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 3456876523459772 | Maro       |              11 |           2026 |          212 |
    And user click on Update Your Card button
    Then a message should be Displayed 'Payment Method updated Successfully'

  Scenario: Verify User can remove Debit or Credit card
    And User click on bank card
    And User click on remove option of card section
    Then payment details should be removed

  Scenario: Verify User can add an Address
    And User click on Add address option
    And user fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt | city   | state | zipCode |
      | United States | Maro     |  2342323455 | 2304 North    | 256 | Dallas | Texas |   75695 |
    And User click Add Your Address button
    Then address update message should be displayed 'Address Added Successfully'

  Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And User edit address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt | city   | state | zipCode |
      | United States | Maro     |  2356547896 | 254 West      | 895 | Dallas | Texas |   74568 |
    And User click update Your Address button
    Then A Message should be displayed 'Address Updated Successfully'

  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed
