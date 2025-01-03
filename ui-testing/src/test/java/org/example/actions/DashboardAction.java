package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
public class DashboardAction extends UIInteractionSteps {
    public String getUrl(){
        return getDriver().getCurrentUrl();
    }
}