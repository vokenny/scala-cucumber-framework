@api
Feature: poke API

  https://pokeapi.co/

  Scenario Outline: Valid GET request for pokemon information receives a 200 OK response
    Given we want pokemon information for <pokemon>
    When the GET request is made to the pokeApi endpoint
    Then the response code should be 200
    And the response body should be the <pokemon> profile with ID number <ID>
    And <pokemon> should have the <Abilities> abilities

    Examples:
      | pokemon   | ID  | Abilities                            |
      | pikachu   | 25  | lightning-rod, static                |
      | lapras    | 131 | hydration, shell-armor, water-absorb |
      | cyndaquil | 155 | flash-fire, blaze                    |
