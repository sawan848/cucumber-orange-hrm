@Login
Feature: Login Functionality for OrangeHrm crm Website
  Background:
    Given I am on the OrangeHrm login page


    @Success
    Scenario: Successful login with valid credentials
      Given User enter a valid email "Admin"
      And User enter invalid password "admin123"
      And User clicks on login button
      Then User should get successfully logged in

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given User have entered a invalid "<username>" and "<password>"
    And User clicks on login button
    Then User should see an error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message                                        |
      | invalid@email.com | invalidPassword | Invalid credentials|
      | abcccc            | validPassword   | Invalid credentials |
      | valid@gmail.com   | abccc           | Invalid credentials |

