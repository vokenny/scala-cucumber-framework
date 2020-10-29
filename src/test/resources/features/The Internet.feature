Feature: The Internet web application

  http://the-internet.herokuapp.com/
  Tests are written for the sake of demo of test automation

  Background:
    Given the User navigates to the Internet page
    Then the User should be on the Internet page

  Scenario: User can navigate to the Challenging DOM page
    When the User navigates to the Challenging DOM page
    Then the User should be on the Challenging DOM page
    And the Randomised Buttons should be displayed

  Scenario Outline: User is shown the dynamically loaded content
    When the User navigates to the Dynamic Loading page
    Then the User should be on the Dynamic Loading page
    When the User clicks <Link>
    Then the User should be on the <Example> page
    When the User clicks Start

    Examples:
      | Link             | Example                   |
      | Example 1 Hidden | Dynamic Loading Example 1 |
      | Example 2 Render | Dynamic Loading Example 2 |

  Scenario: User can get through Basic Authentication
    Given the User is the Admin
    When the User navigates to the Basic Auth page
    Then the User should be on the Basic Auth page

  Scenario: User can upload a file
    When the User navigates to the File Uploader page
    Then the User should be on the File Uploader page
    When the User uploads a file
    Then the User should be on the File Uploader page

  @ignore # drag and drop doesn't work with Selenium Chromedriver
    Scenario: User can drag & drop the boxes, and drag & drop them back
      When the User navigates to the Drag and Drop page
      And the User drag and drops the left Box on to the right Box
      Then the box placements should have switched
      And the User drag and drops the right Box on to the left Box
      Then the box placements should have switched
