Feature: Update Book by ID

  Scenario: Update a book with a valid ID as an admin
    Given I am an admin user
    When I send a PUT request to update the test book
    Then the response status code should be as 200

  Scenario: Update a book with missing mandatory fields as an admin
    Given I am an admin user
    When I send a PUT request to update the test book with missing mandatory fields
    Then the response status code should be 404

  Scenario: Update a book with a valid ID as a normal user
    Given I am a normal user
    When I send a PUT request to update the test book as a normal user
    Then the response status code should be in 403
