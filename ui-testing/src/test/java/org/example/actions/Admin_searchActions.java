package org.example.actions;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Admin_searchActions {

    WebDriver driver;

    @Step("Navigate to User Management page")
    public void navigateToUserManagementPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
    }

    @Step("Enter search details: Username={0}, User Role={1}, Employee Name={2}, Status={3}")
    public void enterSearchDetails(String username, String userRole, String employeeName, String status) {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys(employeeName);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).sendKeys(userRole);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]")).sendKeys(status);
    }

    @Step("Click the Search button")
    public void clickSearchButton() {
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")).click();
    }

    @Step("Verify 'No Records Found' message is displayed")
    public void verifyNoRecordsFound() {
        boolean isMessageDisplayed = driver.findElement(By.xpath("//span[text()='No Records Found']")).isDisplayed();
        assert isMessageDisplayed : "Expected 'No Records Found' message, but it was not displayed.";
    }
}
