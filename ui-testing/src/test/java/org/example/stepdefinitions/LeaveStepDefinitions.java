package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.LeaveAction;
import org.example.actions.CommonAction;
import org.example.actions.LoginAction;
import org.example.actions.NavigationAction;

import static org.assertj.core.api.Assertions.assertThat;

public class LeaveStepDefinitions {
    NavigationAction navigateAction;
    LoginAction loginAction;
    CommonAction commonAction;
    LeaveAction leaveAction;

    @Given("user is in the dashboard")
    public void userIsInDashboard() {
        navigateAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword("Admin", "admin123");
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("user click leave section in sidebar")
    public void userClickLeaveSectionInSidebar() {
        navigateAction.toOrangeHRMLeavePage();
    }

    @Then("user expect redirection to leave section")
    public void userExpectRedirectionToClaimSection() {
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
    }

    @Given("user is in leave page")
    public void userIsInLeavePage() {
        userIsInDashboard();
        userClickLeaveSectionInSidebar();
    }


    @And("the user enters From Date = {string}")
    public void theUserEntersFromDateToDate(String fromDate) {
        leaveAction.selectDate("From Date", fromDate);
    }

    @And("the user enters To Date = {string}")
    public void theUserEntersToDateToDate(String toDate) {
        leaveAction.selectDate("To Date", toDate);
    }

    @And("the user selects leave status {string}")
    public void theUserSelectsLeaveStatus(String leaveStatus) {
        leaveAction.selectLeaveStatus(leaveStatus);
    }

    @And("the user selects leave type {string}")
    public void theUserSelectsLeaveType(String leaveType) {
        leaveAction.selectLeaveType(leaveType);
    }

    @And("the user enters {string} as the Employee Name")
    public void theUserEntersAsTheEmployeeName(String empName) {
        leaveAction.selectEmployeeName(empName);    
    }

    @When("the user clicks the Search button")
    public void theUserClicksTheSearchButton() {
        leaveAction.clickSearch();
    }

    @Then("user expect to see the leave requests for the employee")
    public void userExpectToSeeTheLeaveRequests() {
        leaveAction.checkRecord();
    }

    @Given("user is in add entitlements page")
    public void userIsInAddEntitlementsPage() {
        userIsInLeavePage();
        leaveAction.navigateToAddEntitlements();
    }

    @And("the user selects leave period {string}")
    public void theUserSelectsLeavePeriod(String leavePeriod) {
        leaveAction.selectLeavePeriod(leavePeriod);
    }

    @And("the user enters the entitlement as {int}")
    public void theUserEntersTheEntitlementAs(int enetitlement) {
        leaveAction.enterEntitlement(enetitlement);
    }

    @When("user clicks the save button")
    public void userClicksTheSaveButton() {
        leaveAction.clickSave();
    }

    @And("user clicks confirm button")
    public void userClicksConfirmButton() {
        leaveAction.clickConfirm();
    }

    @And("user clicks Assign button")
    public void userClicksAssignButton() {
        leaveAction.clickAssign();
    }

    @And("user navigates to assign page")
    public void userNavigatesToAssignPage() {
        leaveAction.navigateToAssignPage();
    }
}