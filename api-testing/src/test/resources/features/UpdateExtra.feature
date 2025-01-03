Feature:Update a book with unexpected data
  @UpdateBookUnexpectedData
  Scenario: Update a book with Extra unexpected details
    Given The details to be updated extra
    When I update a book with Extra details
    Then the response status should be the number 400
