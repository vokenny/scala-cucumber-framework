@api @ignore
Feature: Pirate Translator API

#  Ratelimited to 60 requests/day, at 5 requests/hour

  Scenario Outline: Valid POST request for English to Pirate translations receive a 200 OK response
    Given the English text is "<English>"
    When the POST request to the Pirate endpoint is made
    Then the response status should be 200 OK
    And the Pirate translation should be "<Pirate>"

    Examples:
      | English                                         | Pirate                                                                             |
      | This is my example of a POST call.              | This be me example o' a POST call.                                                 |
      | Hello sir! my mother goes with me to the ocean. | Ahoy matey!  me dear ol' mum, bless her black soul goes with me t' th' briny deep. |
