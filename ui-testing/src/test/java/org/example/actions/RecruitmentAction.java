package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class RecruitmentAction extends UIInteractionSteps {

    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

//    @Step("Verify dashboard page")
//    public void verifyDashboardPage() {
//        assertThat(getDriver().getCurrentUrl()).contains("dashboard");
//    }

//    @Step("Click Recruitment tab")
//    public void clickRecruitmentTab() {
//        $(By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']")).click();
//    }

//    @Step("Verify Recruitment page")
//    public void verifyRecruitmentPage() {
//        assertThat(getDriver().getCurrentUrl()).contains("recruitment");
//    }

    @Step("Click Vacancies tab")
    public void clickVacanciesTab() {
        $(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Vacancies']")).click();

    }

    @Step("Click Add button")
    public void clickAddButton() {
        $(By.xpath("//button[contains(@class,'oxd-button') and contains(., 'Add')]")).click();
    }

    @Step("Fill Vacancy Name")
    public void fillVacancyName(String vacancyName) {
        $(By.xpath("//label[text()='Vacancy Name']/ancestor::div[contains(@class, 'oxd-input-group')]//input[contains(@class, 'oxd-input') and contains(@class, 'oxd-input--active')]")).type(vacancyName);
    }

    @Step("Select Job Title")
    public void selectJobTitle(String jobTitle) {

        $(By.xpath("//div[contains(@class,'oxd-select-text--after')]")).click();

        // Select the job title dynamically from the options
        $(By.xpath(String.format("//div[@role='listbox']//span[contains(text(),'%s')]", jobTitle))).click();




    }

    @Step("Fill Hiring Manager")
    public void fillHiringManager(String letter) {
        // Type the letter "a" into the input field
        $(By.xpath("//div[@class='oxd-autocomplete-text-input--active']//input")).sendKeys(letter);

        // Wait for the suggestion to appear
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-autocomplete-wrapper']//span")));

        // Click the first suggestion from the list
        $(By.xpath("//div[@class='oxd-autocomplete-wrapper']//span[1]")).click();
    }

    @Step("Click Save button")
    public void clickSaveButton() {
        $(By.xpath("//button[@type='submit' and contains(text(), 'Save')]")).click();    }

    @Step("Verify Edit Vacancy page")
    public void verifyEditVacancyPage() {
        By editVacancyTitle = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and contains(text(), 'Edit Vacancy')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(editVacancyTitle));
    }
}
