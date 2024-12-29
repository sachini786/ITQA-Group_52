Feature: Get Book by ID

  @api
  Scenario: Retrieve a book with a valid ID as a regular user
    Given I am a normal user
    When I send a request to get all books
    Then API response status code should be 200

  @api
  Scenario: Retrieve a book with a valid ID as an admin
    Given I am an admin user
    When I send a request to get all books
    Then API response status code should be 200