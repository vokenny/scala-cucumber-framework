Feature: The Internet web application

  http://the-internet.herokuapp.com/

  Background:
    Given the User navigates to the Internet page
    Then the User should be on the Internet page

    Scenario: User can navigate to the Challenging DOM page
      When the User navigates to the Challenging DOM page
      Then the User should be on the Challenging DOM page