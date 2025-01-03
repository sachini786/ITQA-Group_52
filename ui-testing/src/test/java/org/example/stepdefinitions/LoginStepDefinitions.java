package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.actions.NavigationAction;
import org.example.actions.CommonAction;
import org.example.actions.LoginAction;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefinitions {
    NavigationAction navigate;
    LoginAction login;
    CommonAction dashboard;

    @Given("user navigate to OrangeHRM login page")
    public void navigateToOrangeHRMLoginPage() {
        navigate.toOrangeHRMLoginPage();
    }

    @When("user login with username {string} and password {string}" )
    public void login(String username, String password) {
        login.loginWithUsernameAndPassword(username,password);
    }

    @Then("user expect redirection to dashboard")
    public void shouldRedirectToDashboard() {
        assertThat(dashboard.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }


}
