Feature: Delete album

@Tugas
Scenario Outline: Delete users with valid id
Given Delete user with valid id <id>
When Send request delete album
Then should return status code 200
Examples:
  | id |
  | 50 |

  @Tugas @Negativecase
  Scenario Outline: Delete users with invalid id
    Given Delete user with invalid id <id>
    When Send request delete album
    Then should return status code 404
    Examples:
      | id  |
      | 101 |