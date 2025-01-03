package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser"));
    }
    @Step("select User Role")
    public void selectUserRole(String userrole){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")).click();
        By userRoleDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]");
        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();
        By adminOption = By.xpath("//div[@class='oxd-select-option']/span[text()='Admin']");
    }
    @Step("select Status")
    public void selectStatus(String status){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")).click();
        By statusDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]");
        By statusOptions = By.xpath("//div[@class='oxd-select-option']/span[text()='Enabled']");
        wait.until(ExpectedConditions.elementToBeClickable(statusOptions)).click();
    }
    @Step("select employeename")
    public void selectEmployeeName(String employeename){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("J");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]")));
        WebElement firstELement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]")));
        firstELement.click();
    }
    @Step("giving the username")
    public void userName(String username){

        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")));
        titleElement.sendKeys(username);
    }
    @Step("giving the password")
    public void passwordGiven(String passwordgiven1){
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")));
        titleElement.sendKeys(passwordgiven1);
    }
    @Step("giving the confirmpassword")
    public void confirmPassword(String confirmpassword){
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")));
        titleElement.sendKeys(confirmpassword);
    }
    @Step("click save")
    public void clickSave(){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
    }
    @Step("wait for redirection")
    public void waitForRedirection(){
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers"));
    }
    @Step("select the Job icon")
    public void selectTheJobIcon(){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span")).click();
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]/a")).click();
    }
    @Step("wait for jobtitlepage")
    public void waitForJobTitlePage(){
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList"));
    }
    @Step("wait for jobaddpage")
    public void waitForJobAddPage(){
        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveJobTitle"));
    }
    @Step("click on add job in the job page")
    public void clickOnAddJobInTheJobPage(){
        $(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")).click();
    }
    @Step("fill the job title")
    public void fillTheJobTitle(String jobtitle){
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")));
        titleElement.sendKeys(jobtitle);
    }
    @Step("click on save")
    public void clickOnSave(){
        $(By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary') and contains(., 'Save')]")).click();
    }

}