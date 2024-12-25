package org.example.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.LoginSteps;

public class loginStepDefinition {
    LoginSteps loginSteps=new LoginSteps();
    @Given("I am on the Moodle login page")
    public void i_am_on_the_moodle_login_page() {
        loginSteps.navigateToLoginPage();
    }

    @When("I enter valid credentials with username {string} and password {string}")
    public void i_enter_valid_credentials_with_username_and_password(String username, String password) {
        loginSteps.enterCredentials(username, password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginSteps.clickLogin();
    }

    @Then("I should be redirected to the Moodle dashboard")
    public void i_should_be_redirected_to_the_moodle_dashboard() {
        loginSteps.verifyDashboard();
    }
}