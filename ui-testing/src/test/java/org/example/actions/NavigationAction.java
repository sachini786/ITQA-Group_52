package org.example.actions;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;


public class NavigationAction extends UIInteractionSteps {
    @Step("Navigate to the login page")
    public void toOrangeHRMLoginPage() {
        openUrl("https://opensource-demo.orangehrmlive.com/");
    }

    @Step("Navigate to the Leave page")
    public void toOrangeHRMLeavePage() {
        $(By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']")).click();
    }

    @Step("Navigate to the Claim page")
    public void toOrangeHRMClaimPage() {
       $(By.xpath("//a[@href='/web/index.php/claim/viewClaimModule']")).click();
    }

    @Step("Navigate to the Admin page")
    public void toOrangeHRMAdminPage(){
        $(By.xpath("//span[@data-v-7b563373 and @data-v-6475d26d and text()='Admin']")).click();
    }
}