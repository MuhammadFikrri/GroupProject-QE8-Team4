Feature: Testing

#  @Tugas
#  Scenario: Get list album with valid parameter
#    Given Get list album
#    When send request get list albums
#    Then should return status code 200
#    And Validate json schema get albums




  @Tugas
  Scenario: Get album with valid parameter
    Given Get list album with id 1
    When send request get albums
    Then should return status code 200
    And Validate json schema get albums

@Tugas @NegativeCase

Scenario: Get album with invalid parameter
  Given Get list album with invalid id 101
  When send request get albums
  Then should return status code 404




