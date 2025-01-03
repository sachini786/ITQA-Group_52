Feature: Get All Books

  Scenario Outline: Get all books as different user
    Given user authenticate using by "<username>" and "<password>" wants to get all books
    When user call service to get all books
    Then user expect response status to be <statusCode>
    Examples:
      | username | password | statusCode |
      |    admin | password | 200        |
      |     user | password | 200        |
      |     test | test     | 401        |

  Scenario: Get all books when no book exist
    Given user want to get all books when there are no books available
    When user call service to get all books
    Then user expect response status to be 200
    And user expect response should contain an empty list

  @BooksExist
  Scenario: Get all books when books exist
    Given user want to get all books when there are books available
    When user call service to get all books
    Then user expect response status to be 200
    And user expect response should contain a list of books

  @BooksExist
  Scenario: Get all books when books exist and validate response schema
    Given user want to get all books when there are books available
    When user call service to get all books
    Then user expect response should have valid schema
