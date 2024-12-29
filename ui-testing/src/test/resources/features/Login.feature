Feature: Login

  @ui
  Scenario: Successful Login
    Given I navigate to OrangeHRM login page
    When login with username "Admin" and password "admin123"
    Then should redirect to dashboard
