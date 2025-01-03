Feature: Update Book by ID

  @CreateBookForUpdate
  Scenario: Update a book with a valid ID as an admin
    Given User need to update a book as an admin
    When I send a PUT request to update the test book with ID 1
    Then the response status code should be 200

  @CreateBookForUpdate
  Scenario: Update a book with missing mandatory fields as an admin
    Given User need to update a book as an admin
    When I send a PUT request to update the test book with missing mandatory fields with ID 2
    Then the response status code should be 400

  @CreateBookForUpdate
  Scenario: Update a book with a valid ID as a normal user
    Given User need to update a book as an normal user
    When I send a PUT request to update the test book with ID 3
    Then the response status code should be 403

