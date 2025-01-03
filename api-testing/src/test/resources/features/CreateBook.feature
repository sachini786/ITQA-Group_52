Feature: Book API Test Scenarios

  Scenario Outline: Create a book with valid details by roles
    Given user as "<role>"
    When send request to create book with <id>,"<title>","<author>"
    Then the response status should be <status>

    Examples:
      | id | title           | author        | status |role  |
      | 1  | Robinson Crusoe | Daniel Defoe  |   201  |admin |
      | 2  | Clean Code      | Robert Martin |   201  |user  |


  Scenario Outline: Validate request when mandatory fields are missing
    Given request payload with
      """
      {
        "id": <id>,
        "title": "<title>",
        "author": "<author>"
      }
      """
    When method POST with endpoint "/books"
    Then status <status>
    And the response message should contain "Mandatory parameters should not be null"

    Examples:
      | id | title | author          | status |
      |    |       |                 | 400    |
      | 6  | Jane  |                 | 400    |
      |    |Hamlet |                 | 400    |
      |    |       |Charles Dickens  | 400    |


  Scenario Outline: Validate duplicate title
    Given request payload with
      """
      {
        "id": <id>,
        "title": "<title>",
        "author": "<author>"
      }
      """
    When method POST with endpoint "/books"
    Then status <status>
    And the response message should contain "Book Already Exists"
    Examples:
      | id | title                   | author              | status |
      |    | The Hobbit              | Aldous Huxley       | 400    |






