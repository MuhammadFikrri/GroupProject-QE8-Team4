Feature: Testing Create Todos JsonPlaceHolder API

  @GroupProject @Positive-Case
  Scenario: Post create new todos with valid json
    Given Post create todos with valid json
    When Send request post create todos
    Then Should return status code 201 Created
    And Validate json schema post todos

  @GroupProject @nyoba
  Scenario: Post create new todos with valid json
    Given Post create todos with valid json
    When Send request post create todos
    Then Should return status code 201 Created
#    And Response body name should be <userID> , job "<title>" and completed "true"
    And Validate json schema post todos