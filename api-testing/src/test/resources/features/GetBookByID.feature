Feature: GET a book by ID

  @api
  Scenario: GET a valid book by ID
    When I send a GET request to retrieve the book with ID 1
    Then The API response status code should be 200
    And The response should contain the book details with ID 1
