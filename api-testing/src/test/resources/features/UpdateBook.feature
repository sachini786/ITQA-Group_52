Feature: Update Book by ID

  Scenario: Update a book with a valid ID as an admin
    Given I am an admin user
    When I send a PUT request to update the test book
    Then the response status code should be as 404