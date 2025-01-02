Feature: Update Book by ID

  Scenario: Update a book with a valid ID as an admin
    Given I am an admin user
    When I send a PUT request to update the test book with ID 1
    Then the response status code should be 200

  Scenario: Update a book with missing mandatory fields as an admin
    Given I am an admin user
    When I send a PUT request to update the test book with missing mandatory fields with ID 2
    Then the response status code should be 400

  Scenario: Update a book with a valid ID as a normal user
    Given I am a normal user
    When I send a PUT request to update the test book with ID 1
    Then the response status code should be 403
