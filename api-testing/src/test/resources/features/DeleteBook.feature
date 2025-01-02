Feature: Delete book by ID

  Scenario Outline: Delete a book with a valid ID as a regular user
    Given user authenticate using by "<username>" and "<password>"
    When I send a DELETE request to delete a book with ID <id>
    Then the response status should be <statusCode>
    Examples:
      | username | password | statusCode | id
      |   user   | password |    403     | 11
      |   admin  | password |    200     |  6


#  @api
#  Scenario: Delete a book with a valid ID as a admin user
#    Given I am an admin user
#    When I send a DELETE request to delete a book with ID 6
#    Then the response status should be 200


  Scenario Outline: Delete a book with a non-existent ID as a regular user
    Given user authenticate using by "<username>" and "<password>"
    When I send a DELETE request to delete a book with ID <id>
    Then the response status should be <statusCode>
    Examples:
      | username | password | statusCode | id
      |   user   | password |    403     |  1
      |   admin  | password |    404     |  2

#  @api
#  Scenario: Delete a book with a non-existent ID as a admin user
#    Given I am an admin user
#    When I send a DELETE request to delete a book with ID 2
#    Then the response status should be 404


  Scenario Outline: Delete a book with a invalid ID as a regular user
    Given user authenticate using by "<username>" and "<password>"
    When I send a DELETE request to delete a book with ID "<id>"
    Then the response status should be <statusCode>
    Examples:
      | username | password | statusCode | id
      |   user   | password |    400     |  a
      |   admin  | password |    400     |  b

#  @api
#  Scenario: Delete a book with a invalid ID as a admin user
#    Given I am an admin user
#    When I send a DELETE request to delete a book with ID "b"
#    Then the response status should be 400


