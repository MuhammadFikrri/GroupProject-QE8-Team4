Feature: Testing Delete Posts REST API

  @GroupProject
  Scenario Outline: API DELETE posts with valid parameter
    Given Delete posts with valid id <id>
    When Send post request to delete user
    Then Should return status code 204
    Examples:
      | id |
      | 1  |
      | 2  |

  @GroupProject
  Scenario Outline: API DELETE posts with invalid parameter
    Given Delete user with invalid <id>
    When Send post request to delete user
    Then Should return status code 404
    Examples:
      | id   |
      | 8491 |
      | 8423 |
