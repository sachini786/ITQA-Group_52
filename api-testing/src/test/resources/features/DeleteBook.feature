Feature: Delete book by ID
  @api
  Scenario: Delete a book with a valid ID as a regular user
    Given I am a normal user
    When I send a DELETE request to delete a book with ID 10
    Then the response status should be 403

  @api
  Scenario: Delete a book with a valid ID as a admin user
    Given I am an admin user
    When I send a DELETE request to delete a book with ID 6
    Then the response status should be 200

  @api
  Scenario: Delete a book with a non-existent ID as a regular user
    Given I am a normal user
    When I send a DELETE request to delete a book with ID 1
    Then the response status should be 403

  @api
  Scenario: Delete a book with a non-existent ID as a admin user
    Given I am an admin user
    When I send a DELETE request to delete a book with ID 2
    Then the response status should be 404

  @api
  Scenario: Delete a book with a invalid ID as a regular user
    Given I am a normal user
    When I send a DELETE request to delete a book with ID "a"
    Then the response status should be 400

  @api
  Scenario: Delete a book with a invalid ID as a admin user
    Given I am an admin user
    When I send a DELETE request to delete a book with ID "b"
    Then the response status should be 400


