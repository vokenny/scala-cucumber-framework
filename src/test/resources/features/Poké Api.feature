@api
Feature: Poké API

  https://pokeapi.co/

  Scenario Outline: Valid GET request for Pokémon information receives a 200 OK response
    Given we want Pokémon information for <Pokémon>
    When the GET request is made to the PokéApi endpoint
    Then the response code should be 200
    And the response body should be the <Pokémon> profile with ID number <ID>
    And <Pokémon> should have the <Abilities> abilities

    Examples:
      | Pokémon   | ID  | Abilities                            |
      | pikachu   | 25  | lightning-rod, static                |
      | lapras    | 131 | hydration, shell-armor, water-absorb |
      | cyndaquil | 155 | flash-fire, blaze                    |
