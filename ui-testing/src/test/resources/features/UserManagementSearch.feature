Feature: User Management - Search Functionality

Scenario: Navigate to Admin page
  Given user is in the dashboard
  When user click Admin section in sidebar
  Then user expect redirection to Admin section

#  Scenario: Add User
#    Given user is in Admin page and click Add button
#    When user add new user role "userrole", employee name {string},Status {string}, username {string}, password {string}, confirmpassword {string}
##    When employee name "John Doe"
##    When Status "Enabled"
##    When username "Nadun"
##    When password "password", confirmpassword "password"
#    Then user expect to redirected to the Admin section
#
    Scenario: navigate to the job page
    Given user is in the admin page
    When user clicked the job icon
    Then redirecting to the job title page
    And clicking the add job button
    Then redirecting to the  Add job page
#    And fill the job title as "testing the  job title page"
#    And click on the save button



