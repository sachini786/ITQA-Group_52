Feature: Get Book by ID

  @dev
  Scenario: Retrieve a book with a valid ID as a regular user
    Given I am a normal user
    When I send a GET request to get all books
    Then the response status code should be 200
#    And the response should contain the book details for ID 1

  @dev
  Scenario: Retrieve a book with a valid ID as an admin
    Given I am an admin user
    When I send a GET request to get all books
    Then the response status code should be 200
#    And the response should contain the book details for ID 1