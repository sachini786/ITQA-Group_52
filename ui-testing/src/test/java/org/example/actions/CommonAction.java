package org.example.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
public class CommonAction extends UIInteractionSteps {
    public String getUrl(){
        return getDriver().getCurrentUrl();
    }
}
