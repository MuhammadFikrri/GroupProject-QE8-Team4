Feature: Testing PUT Todos JsonPlaceHolder API

  @GroupProject @Positive-Case
  Scenario Outline: Put update user with valid json
    Given Put update todos with valid json body and id <id>
    When Send request put update todos
    Then Should return status code 200 ok
    And Validate json schema lists todos
    Examples:
      | id |
      | 1  |
