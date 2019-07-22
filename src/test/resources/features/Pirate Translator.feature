@api @ignore
Feature: Pirate Translator API

#  Ratelimited to 60 requests/day, at 5 requests/hour
#  Remove the @ignore tag if you want to run these scenarios

  Scenario Outline: Valid POST request for English to Pirate translations receive a 200 OK response
    Given the English text is "<English>"
    When the POST request is made to the Pirate endpoint
    Then the response code should be 200
    And the Pirate translation should be <Pirate>

    Examples:
      | English                            | Pirate                               |
      | This is my example of a POST call. | "This be me example o' a POST call." |
      | I have a parrot on my shoulder     | "I have a parrot on me shoulder"     |

  Scenario: Invalid POST request with missing payload receives a 400 Bad Request
    When the POST request with missing payload is made to the Pirate endpoint
    Then the response code should be 400

  Scenario: Valid POST request with empty English field receives a 200 OK
    Given the English text is ""
    When the POST request is made to the Pirate endpoint
    Then the response code should be 200
