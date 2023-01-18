Feature: Testing POST Todos JsonPlaceHolder API

  @GroupProject @Positive-Case
  Scenario: POST todos with valid input body should succes then return 201 response code
    Given Post create todos with valid json
    When Send request post todos with valid json
    Then Should return status code 201 Created
    And Validate json schema lists todos

  @GroupProject @Negative-Case
  Scenario Outline: POST Todos with blank parameter should failed then return 400 response code
    Given Post create todos with blank parameter json
    When Send request post todos with blank parameter json
    Then Should return status code 400 Bad Request
    And Validate json schema lists todos