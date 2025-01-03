Feature: Recruitment Page Actions
  As a user, I want to navigate through the Recruitment page and add a new vacancy.

  Scenario: Navigate to Recruitment page
    Given user is on the dashboard
    When user clicks Recruitment section in the sidebar
    Then user expects redirection to the Recruitment page

  Scenario: Add a new vacancy
    Given user is on the Recruitment page and clicks the Vacancies section and the Add button
    When user adds a new vacancy with Vacancy Name "New Intern", Job Title "Automation Tester", Hiring Manager "Anoja Dayas Silva"
    Then user expects to see the Edit Vacancy page
