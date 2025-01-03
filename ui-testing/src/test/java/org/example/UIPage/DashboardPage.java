//package org.example.UIPage;
//
//import net.thucydides.core.pages.PageObject;
//import org.openqa.selenium.By;
//
//public class DashboardPage extends PageObject {
//
//    public void isLogoExist() {
//       shouldBeVisible(By.className("client brand banner"));
//    }
//    public String doSearch(String searchkey,String searchname){
//        typeInto($("<input data-v-1f99f73c=\"\" data-v-636d6b87=\"\" class=\"oxd-input oxd-input--active\" placeholder=\"Search\">"),searchkey);
//        waitForTextToAppear(searchname);
//        clickOn($("//span.oxd[text()='"+searchname+"']"));
//        return find(By.tagName("h5")).getText();
//    }
//
//}
