package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class RecruitmentAction extends UIInteractionSteps {

    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

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
    public void selectJobTitle() {

        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div[2]/div/div[2]/div/div/div[2]/i")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]/div[2]")));
        WebElement firstELement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/div/div[2]/div[4]")));
        firstELement.click();

    }

    @Step("Fill Hiring Manager")
    public void fillHiringManager() {

        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[3]/div[1]/div/div[2]/div/div/input")).sendKeys("a");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[1]/div/div[2]/div/div[2]")));
        WebElement firstElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[1]/div/div[2]/div/div[2]/div[1]/span")));
        firstElement.click();

    }

    @Step("Click Save button")
    public void clickSaveButton() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[7]/button[2]")));
        button.click();

    }

    @Step("Verify Edit Vacancy page")
    public void verifyEditVacancyPage() {

        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6")));

    }
}
