package org.example.actions;

import net.thucydides.core.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import org.openqa.selenium.By;

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
    @Step("Navigate to the Recruitment page")
    public void toOrangeHRMRecruitmentPage() {
        $(By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']")).click();
    }

}
