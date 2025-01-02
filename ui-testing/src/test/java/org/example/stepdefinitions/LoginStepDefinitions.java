package org.example.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.NavigationAction;
import org.example.actions.DashboardAction;
import org.example.actions.LoginAction;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefinitions {
    NavigationAction navigate;
    LoginAction login;
    DashboardAction dashboard;

    @Given("I navigate to OrangeHRM login page")
    public void navigateToOrangeHRMLoginPage() {
        navigate.toOrangeHRMLoginPage();
    }

    @When("login with username {string} and password {string}" )
    public void login(String username, String password) {
        login.loginWithUsernameAndPassword(username,password);
    }

    @Then("should redirect to dashboard")
    public void shouldRedirectToDashboard() {
        assertThat(dashboard.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

}