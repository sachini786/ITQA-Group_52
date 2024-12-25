Feature: Update a book
  @UpdateBook
  Scenario: Successfully update a book with valid details
    Given The details to be updated
    When I update a book with valid details
    Then the response status should be 400
   