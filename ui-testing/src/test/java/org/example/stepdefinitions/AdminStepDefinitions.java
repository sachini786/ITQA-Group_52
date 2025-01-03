package org.example.stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.AdminAction;
import org.example.actions.CommonAction;
import org.example.actions.LoginAction;
import org.example.actions.NavigationAction;

import static org.assertj.core.api.Assertions.assertThat;


public class AdminStepDefinitions {
    NavigationAction navigateAction;
    LoginAction loginAction;
    CommonAction commonAction;
    AdminAction adminAction;

    @Given("user in dashboard need to navigate to admin page")
    public void userInDashboardNeedToNavigateToAdminPage() {
        navigateAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword("Admin","admin123");
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("user click Admin section in sidebar")
    public void userClickAdminSectionInSidebar() {
        navigateAction.toOrangeHRMAdminPage();
    }

    @Then("user expect redirection to Admin section")
    public void userExpectRedirectionToAdminSection() {
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
    }

    @Given("user is in Admin page")
    public void userIsInAdminPageAndClickAddButton(){
        userInDashboardNeedToNavigateToAdminPage();
        userClickAdminSectionInSidebar();


    }

    @When("user clicking the add Button")
    public void userClickingTheAddButton(){
        adminAction.clickAddUser();
        adminAction.waitForRedirectionToAddUser();
    }

    @When("user add new user role {string}, employee name {string},Status {string}, username {string}, password {string}, confirmpassword {string}")
    public void userAddNewUserRoleEmployeeNameStatusUserNamePasswordConfirmPassword(String userrole, String status, String employeename, String username, String passwordgiven, String confirmpassword){
        adminAction.selectUserRole(userrole);
        adminAction.selectStatus(status);
        adminAction.selectEmployeeName(employeename);
        adminAction.userName(username);
        adminAction.passwordGiven(passwordgiven);
        adminAction.confirmPassword(confirmpassword);
        adminAction.clickSave();

    }
    @Then("user expect to redirected to the Admin section")
    public void userExpectToRedirectedToTheAdminSection(){
        adminAction.waitForRedirection();
    }
//page for the jobadding
    @Given("user is in the admin page")
    public void userIsInTheAdminPage(){
        userInDashboardNeedToNavigateToAdminPage();
        userClickAdminSectionInSidebar();
    }
    @When("user clicked the job icon")
    public void userClickedTheJobIcon(){
        adminAction.selectTheJobIcon();
    }
    @Then("redirecting to the job title page")
    public void redirectingToTheJobTitlePage(){
        adminAction.waitForJobTitlePage();
    }

    @Then("clicking the add job button")
    public void clicking_the_add_job_button() {
     adminAction.clickOnAddJobInTheJobPage();
    }

    @Then("redirecting to the  Add job page")
    public void redirecting_to_the_addjob_page() {
        adminAction.waitForJobAddPage();
    }
    @And("fill the job title as {string}")
    public void fill_the_job_title_as_block(String jobtitle) {
        adminAction.fillTheJobTitle("jobtitle");
    }


    @And("click on the save button")
    public void clickOnTheSaveButton() {
        adminAction.clickOnSave();
    }
}

