@Info
Feature: Set Information for OrangeHrm crm Website



  Scenario Outline: User add the personal details
    Given I am logged in to the OrangeHrm website
    When  I navigate to the My Info page
    And I Enter my personal details  with  With excel row "<row_index>"
#    Given I am on the OrangeHrm info page
#    Then check User add personal details by passing details With excel row "<row_index>"

    Examples:
    |row_index|
    |1        |