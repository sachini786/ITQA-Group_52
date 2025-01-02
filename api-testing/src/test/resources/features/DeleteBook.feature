Feature: Delete book by ID
  @api
  Scenario: Delete a book with a valid ID as a regular user
    Given I am a normal user
    When I send a DELETE request to delete a book with ID 4
    Then the response status should be 403

  @api
  Scenario: Delete a book with a valid ID as a admin user
    Given I am an admin user
    When I send a DELETE request to delete a book with ID 5
    Then the response status should be 200




