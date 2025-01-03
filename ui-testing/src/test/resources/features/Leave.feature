Feature: Leave

  Scenario: Navigate to Leave page
    Given user is in dashboard
    When user click leave section in sidebar
    Then user expect redirection to leave section

  Scenario: Search Leave List
    Given user is in leave page wants to search for leaves
    And the user enters From Date = "2025-10-01"
    And the user selects leave status "Scheduled"
    And the user selects leave type "CAN - FMLA"
    And the user enters "John Doe" as the Employee Name
    When the user clicks the Search button
    Then user expect to see the leave requests for the employee
