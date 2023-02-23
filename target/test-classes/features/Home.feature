Feature: Retail Home Page

  Scenario: Verify user can search a product
    Given User is on retail website
    When User search for "pokemon" product
    Then The product should be displayed

  
  Scenario: Verify Shop by Department sidebar
    Given User is on retail website
    When User click on All section
    Then User below options are present in Shop by department sidebar
      | Electronics | Computers | Smart Home | Sports | Automative |


  @test
  Scenario Outline: Verify Department sidebar option
    Given User is on retail website
    When User click on All section
    And User is on '<department>'
    Then below options are present in department
      | <optionOne> | <optionTwo> |

    Examples: 
      | department  | optionOne                      | optionTwo               |
      | Electronics | TV & Video                     | Video Game              |
      | Smart Home  | Smart Home Lightning           | Plugs and Outlets       |
      | Sports      | Athletic Clothing              | Exercise & Fitness      |
      | Automative  | Automative Parts & Accessories | MotoCycle & Powersports |
