package org.example.actions;

import net.thucydides.core.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginAction extends UIInteractionSteps {
    @Step("Login as a user '{0}'")
    public void loginWithUsernameAndPassword(String username,String password) {
        $(By.name("username")).sendKeys(username);
        $(By.name("password")).sendKeys(password,Keys.ENTER);
    }


//    @Step("Login as a user '{0}'")
//    public void loggedWithUsernameAndPassword(String username,String password) {
//        $(By.name("username")).sendKeys(username);
//        $(By.name("password")).sendKeys(password,Keys.ENTER);
//    }


}