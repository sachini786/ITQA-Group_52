Feature: Edge Cases

  Scenario: Accessing to an Invalid endpoint
    Given user needs to get all the authors
    When user send request to get all authors
    Then the edge case response status should be 404

  Scenario: Create a book with Extra unexpected details
    Given user need to create a book with extra field
    When user send request to create book
    Then the edge case response status should be 404

  Scenario: Update a book with Extra unexpected details
    Given user need to update a book with extra field
    When user send request to update book
    Then the edge case response status should be 404