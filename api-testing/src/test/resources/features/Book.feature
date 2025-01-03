Feature: Book Details

  @GetAllBooks
  Scenario: Get all books
    Given I send a request to get all books
    Then the API should return status 200

