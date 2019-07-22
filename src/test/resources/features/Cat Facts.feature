@api
Feature: Cat Facts API

  Scenario Outline: Valid GET request with a specific ID receives a 200 OK response, and a specific cat fact in the response body
    Given the cat fact ID is <ID>
    When the GET request is made to the Cat Facts endpoint
    Then the response code should be 200
    And the response body should contain the fact: <Fact>

    Examples:
      | ID                       | Fact                                                                                                            |
      | 591f9894d369931519ce358f | "A female cat will be pregnant for approximately 9 weeks - between 62 and 65 days from conception to delivery." |
      | 591f9854c5cbe314f7a7ad34 | "It has been scientifically proven that stroking a cat can lower one's blood pressure."                         |
      | 5887e1d85c873e0011036889 | "Cats make about 100 different sounds. Dogs make only about 10."                                                |
