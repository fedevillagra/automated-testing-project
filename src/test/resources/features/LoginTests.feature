@Login
Feature: Login functionality

  @UC-1
  Scenario: Login with empty credentials
    Given the Home Page is displayed
    When I enter the username "" and password ""
    And I click the login button
    Then the error message "Username is required" is displayed

  @UC-2
  Scenario: Login with username only
    Given the Home Page is displayed
    When I enter the username "standard_user" and password ""
    And I click the login button
    Then the error message "Password is required" is displayed

  @UC-3
  Scenario Outline: Successful login
    Given the Home Page is displayed
    When I enter the username "<user>" and password "<pass>"
    And I click the login button
    Then the page has the title "Swag Labs"

    Examples:
      | user           | pass         |
      | standard_user  | secret_sauce |
      | locked_out_user| secret_sauce |
      | problem_user   | secret_sauce |
      | error_user     | secret_sauce |
      | visual_user    | secret_sauce |

    @UC-4
    Scenario: I enter a random user of {n} characters
      Given the Home Page is displayed
      When I enter a random user of 10 characters and password "pass"
      And I click the login button
      Then the error message "Username and password do not match any user in this service" is displayed