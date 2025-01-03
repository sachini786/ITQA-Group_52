package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAction extends UIInteractionSteps {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    @Step("click add user")
    public void clickAddUser(){
        $(By.xpath("//button[contains(., 'Add')]")).click();
    }
    @Step("wait for redirection to adduser")
    public void waitForRedirectionToAddUser(){

        By addUsersTitle = By.xpath("//h6[contains(@class, 'oxd-text-filter-title') and text()='Add User']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUsersTitle));
    }


    @Step("select User Role")
    public void selectUserRole(String userrole){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();

        By userRoleDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]");
        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();

        By adminOption = By.xpath("//div[@class='oxd-select-option']/span[text()='Admin']");
        wait.until(ExpectedConditions.elementToBeClickable(adminOption)).click();

    }

    @Step("select Status")
    public void selectStatus(String status){
        $(By.xpath("//div[contains(@class, 'oxd-select-text-input') and text()='-- Select --']")).type(status);
        $(By.xpath(String.format("//div[@role='option' and contains(@class, 'oxd-select-option')]//span[text()='%s']",status))).click();
    }

    @Step("select employeename")
    public void selectEmployeeName(String employeename){
        $(By.xpath("//label[contains(text(), 'Employee Name')]/following::input[1]")).type(employeename);
        $(By.xpath(String.format("//div[@role='listbox']//div[@role='option']//span[text()='%s']",employeename))).click();

    }


    @Step("giving the username")
    public void userName(String username){
        $(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).type(username);
    }
    @Step("giving the password")
    public void passwordGiven(String passwordgiven){
        $(By.xpath("//label[contains(text(), 'Password')]")).type(passwordgiven);
    }
    @Step("giving the confirmpassword")
    public void confirmPassword(String confirmpassword){
        $(By.xpath("//label[contains(text(), 'Username')]")).type(confirmpassword);
    }
    @Step("click save")
    public void clickSave(){
        $(By.xpath("//button[@type='save']")).click();
    }


    @Step("wait for redirection")
    public void waitForRedirection(){
        By systemUsersTitle = By.xpath("//h5[contains(@class, 'oxd-table-filter-title') and text()='System Users']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(systemUsersTitle));
    }
    @Step("select the Job icon")
    public void selectTheJobIcon(){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span")).click();
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]/a")).click();

    }
    @Step("wait for jobpage")
    public void waitForJobPage(){
        By jobtitle = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/h6");
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobtitle));
    }


    @Step("click on add job in the job page")
    public void clickOnAddJobInTheJobPage(){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")).click();
    }

    @Step("wait for redirection to adduser")
    public void waitForRedirectionToAddJobpage(){

        By addJobPage = By.xpath("<h6 data-v-7b563373=\"\" class=\"oxd-text oxd-text--h6 orangehrm-main-title\">Add Job Title</h6>");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addJobPage));
    }
    @Step("fill the job title")
    public void fillTheJobTitle(String jobtitle){
//        $(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div")).type(jobtitle);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(fillTheJobTitle));

        By addjobtitle = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addjobtitle));

    }

}