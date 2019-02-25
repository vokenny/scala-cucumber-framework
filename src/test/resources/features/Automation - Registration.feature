Feature: Automation Practice: User Registration

  Background:
    Given the User does not have an existing account
    And the User navigates to the Home page
    Then the User should be on the Home page

    Scenario: User can successfully register for an account
      When the User clicks Sign In
      Then the User should be on the Authentication page
      When the User submits a valid email address
      Then the User should be on the Registration page
      When the User submits valid registration details
#      Then the User should be on the Successful Registration page
