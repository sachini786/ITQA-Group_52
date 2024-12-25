Feature: Login to Moodle
  As a user
  I want to log in to the Moodle portal
  So that I can access my dashboard

  Scenario: Successful Login
    Given I am on the Moodle login page
    When I enter valid credentials with username "username" and password "password"
    And I click the login button
    Then I should be redirected to the Moodle dashboard
