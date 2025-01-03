Feature: Claim

  Scenario: Navigate to Claim page
    Given user is in dashboard
    When user click claim section in sidebar
    Then user expect redirection to claim section

  Scenario: Assign Claim
    Given user is in claim page and click assign claim button
    When user create new claim request with employee name "Peter Mac Anderson",event "Travel Allowance", currency "United States Dollar"
    Then user expect to show assign claim form

  Scenario: Search existing claim
    Given user is in claim page wants to search for claim
    When user search for claim with employee name "Giang Nguyen",event "Accommodation"
    Then user expect to see claim with name "Giang Nguyen",event "Accommodation"
