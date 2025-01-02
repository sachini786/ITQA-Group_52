Feature: Delete book by ID
  @api
  Scenario: Delete a book with a valid ID as a regular user
    Given I am a normal user
    When I send a DELETE request to delete a book with ID 1
    Then the response status should be 200
#    And the book should still exist




