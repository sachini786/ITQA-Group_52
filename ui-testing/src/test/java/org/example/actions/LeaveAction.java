package org.example.actions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class LeaveAction extends UIInteractionSteps {

    private String getMonthName(int month) {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }

    @Step
    public void selectDate(String label, String date) {
        String[] dateParts = date.split("-");
        String year = dateParts[0];
        String day = String.valueOf(Integer.parseInt(dateParts[1]));
        String month = dateParts[2];

        $(By.xpath(String.format("//label[contains(text(), '%s')]/following::input[1]", label))).click();

        while (!$(By.xpath("//div[contains(@class, 'oxd-calendar-selector-year-selected')]/p"))
                .getText().equals(year)) {
            $(By.xpath("//button[contains(@class, 'oxd-icon-button')]")).click();
        }

        while (!$(By.xpath("//div[contains(@class, 'oxd-calendar-selector-month-selected')]/p"))
                .getText().equals(getMonthName(Integer.parseInt(month)))) {
            $(By.xpath("//button[contains(@class, 'oxd-icon-button')]")).click();
        }

        System.out.println(day);
        $(By.xpath(String.format("//div[@class='oxd-calendar-date-wrapper']//div[text()='%s']", day))).click();
    }



    @Step
    public  void selectLeaveStatus(String leaveStatus){
        $(By.xpath("//label[contains(text(), 'Show Leave with Status')]/following::div[@class='oxd-select-text-input']")).click();
        $(By.xpath(String.format("//div[@role='listbox']//div[@role='option']//span[text()='%s']", leaveStatus))).click();
    }

    @Step
    public void selectLeaveType(String leaveType){
        $(By.xpath("//label[contains(text(), 'Leave Type')]/following::div[@class='oxd-select-text-input']")).click();
        $(By.xpath(String.format("//div[@role='listbox']//div[@role='option']//span[text()='%s']", leaveType))).click();
    }

    @Step
    public  void  selectEmployeeName(String empName){
        $(By.xpath("//label[contains(text(), 'Employee Name')]/following::input[1]")).type(empName);
        $(By.xpath(String.format("//div[@role='listbox']//div[@role='option']//span[text()='%s']", empName))).click();
    }

    @Step
    public void clickSearch(){
        $(By.xpath("//button[contains(., 'Search')]")).click();
    }

    @Step
    public void checkRecord(){
        assert $(By.xpath("//span[@class='oxd-text oxd-text--span']")).getText().contains("Records Found");
    }

    @Step
    public void  navigateToAddEntitlements(){
        $(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item' and text()='Entitlements ']")).click();
        $(By.xpath("//ul[@class='oxd-dropdown-menu']//a[text()='Add Entitlements']")).click();
    }

    @Step
    public void selectLeavePeriod(String leavePeriod){
        $(By.xpath("//label[contains(text(), 'Leave Period')]/following::div[@class='oxd-select-text-input']")).click();
        $(By.xpath(String.format("//div[@role='listbox']//div[@role='option']//span[text()='%s']", leavePeriod))).click();
    }

    @Step
    public void enterEntitlement(int entitlement) {
        $(By.xpath("//label[contains(text(), 'Entitlement')]/ancestor::div[contains(@class, 'oxd-input-group')]/following-sibling::div//input"))
                .sendKeys(String.valueOf(entitlement));
    }

    @Step
    public void clickSave(){
        $(By.xpath("//button[contains(., ' Save ')]")).click();
    }

    @Step
    public void clickConfirm(){
        $(By.xpath("//button[contains(., ' Confirm ')]")).click();
    }
    @Step
    public void clickAssign(){
        $(By.xpath("//button[contains(., ' Assign ')]")).click();
    }

    @Step
    public void navigateToAssignPage() {
        $(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item' and text()='Assign Leave']")).click();
    }
}
