Feature: Login

  Scenario: Successful Login
    Given user navigate to OrangeHRM login page
    When user login with username "Admin" and password "admin123"
    Then user expect redirection to dashboard
