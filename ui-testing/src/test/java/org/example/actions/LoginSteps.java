package org.example.actions;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver driver = ThucydidesWebDriverSupport.getDriver();

    @Step("navigate to the login page")
    public void navigateToLoginPage(){
        driver =new ChromeDriver();
        driver.get("https://online.uom.lk/login/index.php");
    }

    @Step("Enter valid credentials")
    public void enterCredentials(String username,String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @Step("click the login button")
    public void clickLogin (){
        driver.findElement(By.id("loginbtn")).click();
    }
    @Step("Verify dashboard is displayed")
    public void verifyDashboard(){
        Assert.assertEquals("https://online.uom.lk/my/",driver.getCurrentUrl());
    }
}
