Feature: Testing DELETE comments JsonPlaceHolder

  @GroupProject @Positive-Case
  Scenario Outline: DELETE Comments with valid parameter
    Given Delete comments with valid parameter <id>
    When Send request delete comments
    Then Should return status code 200
    Examples:
      | id  |
      | 1   |
      | 400 |

  @GroupProject @Negative-Case-Case
  Scenario Outline: DELETE Comments with unregistered parameter id
    Given Delete comments with valid parameter <id>
    When Send request delete comments
    Then Should return status code 400
    Examples:
      | id  |
      | 600 |
      | 900 |

  @GroupProject @Negative-Case-Case
  Scenario Outline: DELETE Comments with invalid parameter id
    Given Delete comments with invalid parameter "<id>"
    When Send request delete comments
    Then Should return status code 400
    Examples:
      | id  |
      | abc |
      | def |
    

