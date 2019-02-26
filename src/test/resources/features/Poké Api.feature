@api
Feature: Poké API

  Scenario Outline: Valid GET request for Pokémon information receives a 200 OK response
    Given we want Pokémon information for <Pokémon>
    When the GET request to the PokéApi endpoint is made
    Then the response status should be 200 OK
    And the response body should be the <Pokémon> profile

    Examples:
      | Pokémon   |
      | Pikachu   |
      | Lapras    |
      | Cyndaquil |
