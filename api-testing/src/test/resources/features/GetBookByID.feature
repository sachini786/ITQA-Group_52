Feature: GET a book by ID

  Scenario Outline: GET a book by valid ID as different user when book does not exists
    Given user authenticate using by "<username>" and "<password>" wants to retrieve the book with valid ID
    When user calls service to get the book with ID
    Then user expects response status to be <statusCode>

    Examples:
      | username | password | statusCode |
      | admin    | password | 200        |
      | user     | password | 200        |
      | test     | test     | 401        |


  @ValidIdFormat-Admin
  Scenario: GET a book with a valid ID format as an admin user when book exists
    Given admin user wants to get book the ID is valid
    Given the book exists
    When user calls service to get the book with ID
    Then user expects response status to be 200
    And user expects response should contain the book details with ID

  @ValidIdFormat-RegularUser
  Scenario: GET a book with a valid ID format as an regular user when book exists
    Given regular user wants to get book the ID is valid
    Given the book exists
    When user calls service to get the book with ID
    Then user expects response status to be 200
    And user expects response should contain the book details with ID

  @BookNotFound
  Scenario: GET a non-existent book by ID as an admin
    Given admin user wants to get a non-existent book
    When user calls service to get the book with ID 9999
    Then user expects response status to be 404
    And user expects response should contain a "Book not found" message

  @BookNotFound
  Scenario: GET a non-existent book by ID as a regular user
    Given regular user wants to get a non-existent book
    When user calls service to get the book with ID 9999
    Then user expects response status to be 404
    And user expects response should contain a "Book not found" message

  @InvalidIDFormat
  Scenario: GET a book with an invalid ID format as an admin
    Given admin user wants to get a book with an invalid ID
    When user calls service to get the book with ID "invalid"
    Then user expects response status to be 400

  @InvalidIDFormat
  Scenario: GET a book with an invalid ID format as a regular user
    Given regular user wants to get a book with an invalid ID
    When user calls service to get the book with ID "invalid"
    Then user expects response status to be 400