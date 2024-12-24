Feature: Update a book

  Scenario: Successfully update a book with valid details
    Given the API is running
    When I update a book with valid details
    Then the response status should be 200
    And the response should contain the updated details

  Scenario: Fail to update a book with missing parameters
    Given the API is running
    When I update a book with missing title
    Then the response status should be 400

  Scenario: Fail to update a non-existent book
    Given the API is running
    When I update a book with a non-existent id
    Then the response status should be 404
