Feature: The Internet web application

  http://the-internet.herokuapp.com/
  Tests are written for the sake of demo of test automation

  Background:
    Given the User navigates to the Internet page
    Then the User should be on the Internet page

  Scenario: User can navigate to the Challenging DOM page
    When the User navigates to the Challenging DOM page
    Then the User should be on the Challenging DOM page

  Scenario Outline: User is shown the dynamically loaded content
    When the User navigates to the Dynamic Loading page
    Then the User should be on the Dynamic Loading page
    When the User clicks <Link>
    Then the User should be on the <Example> page
    When the User clicks Start
    Then the Dynamic Content should be displayed

    Examples:
      | Link             | Example                   |
      | Example 1 Hidden | Dynamic Loading Example 1 |
      | Example 2 Render | Dynamic Loading Example 2 |
