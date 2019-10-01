@api
Feature: Poké API

  https://pokeapi.co/

  Scenario Outline: Valid GET request for Pokémon information receives a 200 OK response
    Given we want Pokémon information for <Pokémon>
    When the GET request is made to the PokéApi endpoint
    Then the response code should be 200
    And the response body should be the <Pokémon> profile with ID number <ID>

    Examples:
      | Pokémon   | ID  |
      | pikachu   | 25  |
      | lapras    | 131 |
      | cyndaquil | 155 |
