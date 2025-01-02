package org.example.actions;

import net.thucydides.core.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class NavigationAction extends UIInteractionSteps {
    @Step("Navigate to the login page")
    public void toOrangeHRMLoginPage() {

        openUrl("https://opensource-demo.orangehrmlive.com/");
    }

//    nadun

    @Step("Navigate to the Admin page")
    public void toAdminPage(){
        openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
    }

    @Step("Navigate to the Add User Page")
    public void toAddUserPage(){
        openUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser");

    }


}