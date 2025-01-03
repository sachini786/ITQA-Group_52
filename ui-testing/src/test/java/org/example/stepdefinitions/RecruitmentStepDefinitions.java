package org.example.stepdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import org.example.actions.CommonAction;
import org.example.actions.LoginAction;
import org.example.actions.NavigationAction;
import org.example.actions.RecruitmentAction;

import static org.assertj.core.api.Assertions.assertThat;

public class RecruitmentStepDefinitions {
    NavigationAction navigateAction;
    LoginAction loginAction;
    CommonAction commonAction;
    RecruitmentAction recruitmentAction;

    @Given("user is on the dashboard")
    public void userIsOnTheDashboard() {
        navigateAction.toOrangeHRMLoginPage();
        loginAction.loginWithUsernameAndPassword("Admin","admin123");
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("user clicks Recruitment section in the sidebar")
    public void userClicksRecruitmentSectionInTheSidebar() {
        navigateAction.toOrangeHRMRecruitmentPage();
    }

    @Then("user expects redirection to the Recruitment page")
    public void userExpectsRedirectionToTheRecruitmentPage() {
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
    }

    @Given("user is on the Recruitment page and clicks the Vacancies section and the Add button")
    public void userIsOnTheRecruitmentPageAndClicksTheVacanciesSectionAndAddButton() {
        userIsOnTheDashboard();
        userClicksRecruitmentSectionInTheSidebar();
        recruitmentAction.clickVacanciesTab();
        recruitmentAction.clickAddButton();
        assertThat(commonAction.getUrl()).isEqualTo("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addJobVacancy");

    }

    @When("user adds a new vacancy with Vacancy Name {string}, Job Title {string}, Hiring Manager {string}")
    public void userAddsANewVacancy(String vacancyName, String jobTitle, String hiringManager) {
        recruitmentAction.fillVacancyName(vacancyName);
        recruitmentAction.selectJobTitle(jobTitle);
        recruitmentAction.fillHiringManager(hiringManager);
        recruitmentAction.clickSaveButton();
    }

    @Then("user expects to see the Edit Vacancy page")
    public void userExpectsToSeeTheEditVacancyPage() {
        recruitmentAction.verifyEditVacancyPage();
    }
}
