@UC-2
Feature: UC-2 - Login with username only

  Scenario: User attempts to login with only username entered
    Given the user is on the home screen of saucedemo.com
    When the user completes the login form with username "standard_user" and password ""
    And the user clicks the login button
    Then the user should see the error message "Password is required"
