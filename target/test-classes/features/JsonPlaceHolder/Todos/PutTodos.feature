Feature: Testing Update Todos JsonPlaceHolder API

  @GroupProject @Positive-Case
  Scenario: Put update todos with valid json
    Given Put update todos with valid json with id 1
    When Send request put update todos
    Then Should return status code 200 ok
    And Validate json schema put todos

  @GroupProject @Positive-Case
  Scenario: Put update todos with valid json
    Given Put update todos with valid json with id 1
    When Send request put update todos
    Then Should return status code 200 ok
    And Validate json schema put todos