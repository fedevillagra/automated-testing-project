@UC-3
Feature: UC-3 - Successful login

  Scenario Outline: User logs in with valid credentials
    Given the user is on the home screen of saucedemo.com
    When the user completes the login form with username "<user>" and password "<pass>"
    And the user clicks the login button
    Then the user should see the page title "Swag Labs"

    Examples:
      | user                    | pass         |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |
