@UC-1
Feature: UC-1 - Login with empty credentials

  Scenario: User attempts to login without entering username and password
    Given the user is on the home screen of saucedemo.com
    When the user completes the login form with username "" and password ""
    And the user clicks the login button
    Then the user should see the error message "Username is required"
