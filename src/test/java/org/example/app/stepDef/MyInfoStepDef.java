package org.example.app.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.app.factory.DriverFactory;
import org.example.app.pageObject.LoginPage;
import org.example.app.pageObject.PersonalDetails;
import org.example.app.utils.DataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import java.util.HashMap;
import java.util.List;

/**
 * 7/11/2023
 * 11:47 AM
 */
public class MyInfoStepDef {
    private WebDriver driver;
    private PersonalDetails personalDetails;
    private List<HashMap<String,String>>dataReader;
    private LoginPage loginPage;
    final String path="C:\\Users\\2271259\\IdeaProjects\\cucumber-project\\cucumber-orange-hrm\\src\\test\\resources\\testData\\orange-hrm.xlsx";

    @Given("I am logged in to the OrangeHrm website")
    public void i_am_logged_in_to_the_orange_hrm_website() {
        // Write code here that turns the phrase above into concrete actions
        driver= DriverFactory.getDriver();
        loginPage=new LoginPage(driver);
        loginPage.setUserName("Admin");
        loginPage.setPassword("admin123");
        loginPage.clickOnLoginBtn();
    }

    @When("I navigate to the My Info page")
    public void i_navigate_to_the_my_info_page() {
        // Write code here that turns the phrase above into concrete actions
        personalDetails=loginPage.clickOnDashboardLink();
    }

    @When("I Enter my personal details  with  With excel row {string}")
    public void i_enter_my_personal_details_with_with_excel_row(String row) {
        // Write code here that turns the phrase above into concrete actions
        dataReader = DataReader.data(path, "Sheet1");
        int index = Integer.parseInt(row) - 1;
        String firstName = dataReader.get(index).get("Firstname");
        String lastName = dataReader.get(index).get("Lastname");
        String middleName = dataReader.get(index).get("Middlename");
        System.out.println(firstName + "\t" + "," + lastName + "," + middleName);
        try {
            personalDetails.setFistNameElement(firstName);
            personalDetails.setLastNameElement(lastName);
            personalDetails.setMiddleNameElement(middleName);
            Thread.sleep(40000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}




















//    @Given("I am on the OrangeHrm info page")
//    public void i_am_on_the_orange_hrm_info_page()throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        driver= DriverFactory.getDriver();
//        loginPage=new LoginPage(driver);
//        personalDetails=loginPage.clickOnDashboardLink();
//        loginPage=new LoginPage(driver);
//        Thread.sleep(5000);
//        loginPage.setUserName("Admin");
//        loginPage.setPassword("admin123");
//        loginPage.clickOnLoginBtn();
//        loginPage.getDashboardLink().click();
//
//    }


//    @Given("I am logged in to the OrangeHrm website")
//    public void  i_am_logged_in_to_the_OrangeHrm_website(){
//        driver=DriverFactory.getDriver();
//        loginPage=new LoginPage(driver);
//        loginPage.setUserName("Admin");
//        loginPage.setPassword("admin123");
//        loginPage.clickOnLoginBtn();
//    }
//
//    @When("I navigate to the My Info page")
//    public void i_navigate_to_the_My_Info_page(){
//        personalDetails=loginPage.clickOnDashboardLink();
//    }
//    @And("I Enter my personal details  with  With excel row {string}")
//    public void check_user_add_personal_details_by_passing_details_with_excel_row(String row) {
//         Write code here that turns the phrase above into concrete actions
//        System.out.println("row = " + row);
//        dataReader= DataReader.data(path,"Sheet1");
//        int index=Integer.parseInt(row)-1;
//        String firstName=dataReader.get(index).get("Firstname");
//        String lastName=dataReader.get(index).get("Lastname");
//        String middleName=dataReader.get(index).get("Middlename");
//        System.out.println(firstName+"\t"+","+lastName+","+middleName);
//        try {
//            WebElement firstNameElement=driver.findElement(By.name("firstName"));
//            personalDetails.setFistNameElement(firstName);
//            String s= Keys.chord(Keys.CONTROL,"a");
//            firstNameElement.sendKeys(s);
//            firstNameElement.sendKeys(Keys.DELETE);
//            firstNameElement.sendKeys("Ankur");
//            personalDetails.setLastNameElement(lastName);
//            personalDetails.setMiddleNameElement(middleName);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//


