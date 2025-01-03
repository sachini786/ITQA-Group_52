Feature: Delete a book
  @DeleteBook
  Scenario: Delete a Book which is already deleted
    Given The book is needed to be deleted
    When I delete a book which is already deleted
    Then the response status should be the 403