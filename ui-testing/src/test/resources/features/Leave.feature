Feature: Leave

  Scenario: Navigate to Leave page
    Given user is in dashboard
    When user click leave section in sidebar
    Then user expect redirection to leave section

    Scenario: Add entitlements
      Given user is in add entitlements page
      And the user enters "Ranga  Akunuri" as the Employee Name
      And the user selects leave type "CAN - Matternity"
      And the user selects leave period "2025-01-01 - 2025-31-12"
      And the user enters the entitlement as 50
      When user clicks the save button
      And user clicks confirm button

  Scenario: Search Leave List
    Given user is in leave page wants to search for leaves
    And the user enters From Date = "2025-10-01"
    And the user selects leave status "Scheduled"
    And the user selects leave type "CAN - Matternity"
    And the user enters "Ranga  Akunuri" as the Employee Name
    When the user clicks the Search button
    Then user expect to see the leave requests for the employee
