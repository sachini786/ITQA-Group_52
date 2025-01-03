package org.example.actions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClaimAction extends UIInteractionSteps {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    @Step("click assign claim")
    public void clickAssignClaim(){
        $(By.xpath("//button[contains(., 'Assign Claim')]")).click();
    }

    @Step("select employee name")
    public void selectEmployeeName(String employeeName){
        $(By.xpath("//label[contains(text(), 'Employee Name')]/following::input[1]")).sendKeys(employeeName, Keys.ARROW_DOWN, Keys.ENTER);
    }

    @Step("select event")
    public void selectEvent(String event){
        $(By.xpath("//label[contains(text(),'Event')]/following::div[contains(@class,'oxd-select-text-input')]")).click();
        $(By.xpath(String.format("//div[@role='listbox']//span[contains(text(),'%s')]",event))).click();
    }

    @Step("select currency")
    public void selectCurrency(String currency){
        $(By.xpath("//label[contains(text(),'Currency')]/following::div[contains(@class,'oxd-select-text-input')]")).click();
        $(By.xpath(String.format("//div[@role='listbox']//span[contains(text(),'%s')]",currency))).click();
    }
    @Step("click create")
    public void clickCreate(){
        $(By.xpath("//button[@type='submit']")).click();
    }

    @Step("wait for assign claim form")
    public void waitUntilClaimForm(){
        By assignClaimTitle=By.xpath("//h6[contains(@class, 'oxd-text--h6') and contains(@class, 'orangehrm-main-title') and and contains(text(), 'Assign Claim')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(assignClaimTitle));
        Assert.assertEquals("Assign Claim",find(assignClaimTitle).getAttribute("innerHTML"));
    }

    @Step("enter event to search")
    public void selectEventToSearch(String event) {
        $(By.xpath("//label[contains(text(),'Event Name')]/following::div[contains(@class,'oxd-select-text-input')]")).click();
        $(By.xpath(String.format("//div[@role='listbox']//span[contains(text(),'%s')]",event))).click();
    }

    @Step("click search")
    public void clickSearch(){
        $(By.xpath("//button[@type='submit']")).click();
    }

    @Step("validate if the table has claim")
    public void validateIfTableHasClaim(String employeeName){
        ListOfWebElementFacades rows = findAll(By.cssSelector(".oxd-table-row"));

        boolean rowFound = rows.stream().anyMatch(row -> {
            String empName = row.findElement(By.xpath(".//div[2]")).getText();
            return empName.equals(employeeName);
        });

        assertThat(rowFound)
                .as("Row with Employee Name: %s,should exist", employeeName)
                .isTrue();
    }

}
