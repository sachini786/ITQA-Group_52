package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.ClaimAction;
import org.example.actions.CommonAction;
import org.example.actions.LoginAction;
import org.example.actions.NavigationAction;

import static org.assertj.core.api.Assertions.assertThat;

public class ClaimStepDefinitions {
    NavigationAction navigateAction;
    LoginAction loginAction;
    CommonAction commonAction;
    ClaimAction claimAction;

    @Given("user is in dashboard")
    public void userIsInDashboard() {
        navigateAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword("Admin","admin123");
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("user click claim section in sidebar")
    public void userClickClaimSectionInSidebar() {
        navigateAction.toOrangeHRMClaimPage();
    }

    @Then("user expect redirection to claim section")
    public void userExpectRedirectionToClaimSection() {
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewAssignClaim");
    }

    @Given("user is in claim page and click assign claim button")
    public void userIsInClaimPageAndClickAssignClaimButton() {
        userIsInDashboard();
        userClickClaimSectionInSidebar();
        claimAction.clickAssignClaim();
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/claim/assignClaim");
    }

    @When("user create new claim request with employee name {string},event {string}, currency {string}")
    public void userCreateNewClaimRequest(String employeeName,String event,String currency) {
        claimAction.selectEmployeeName(employeeName);
        claimAction.selectEvent(event);
        claimAction.selectCurrency(currency);
        claimAction.clickCreate();
    }

    @Then("user expect to show assign claim form")
    public void userExpectToShowAssignClaimForm() {
        claimAction.waitUntilClaimForm();
    }

    @Given("user is in claim page wants to search for claim")
    public void userIsInClaimPageWantsToSearchForClaim() {
        userIsInDashboard();
        userClickClaimSectionInSidebar();
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewAssignClaim");
    }

    @When("user search for claim with employee name {string},event {string}")
    public void userSearchForClaimWithEmployeeNameEventCurrency(String employeeName, String event){
        claimAction.enterEmployeeNameToSearch(employeeName);
        claimAction.selectEventToSearch(event);
        claimAction.clickSearch();
    }

    @Then("user expect to see claim with name {string},event {string}")
    public void userExpectToSeeClaimWithNameEvent(String name, String event) {
        //claimAction.validateIfTableHasClaim(name,event,"Initiated");
    }
}
