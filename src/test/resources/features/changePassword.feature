Feature: Change Password

  @test
  Scenario: Verify User can Update password
    Given User is on retail website
    When User click on the Sign in option
    And User enter email 'maro@gmail.com' and password "Tek@123456"
    And User click on login button
    And User should be logged in into Account
    And User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Tek@12346        | Tek@12345  | Tek@12345      |
    And User click on Change password button
    Then a Message should be displayed 'Password Updated Successfully'
