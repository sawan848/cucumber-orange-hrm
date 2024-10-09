package org.example.app.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.app.factory.DriverFactory;
import org.example.app.pageObject.LoginPage;
import org.example.app.pageObject.PersonalDetails;
import org.openqa.selenium.WebDriver;

import static org.testng.AssertJUnit.assertEquals;


/**
 * 7/11/2023
 * 11:15 AM
 */
public class LoginStepDef {
    private WebDriver driver;
    private LoginPage loginPage;
    private PersonalDetails personalDetails;
    @Given("I am on the OrangeHrm login page")
    public void i_am_on_the_orange_hrm_login_page() {
        driver= DriverFactory.getDriver();
        loginPage=new LoginPage(driver);

    }

    @Given("User enter a valid email {string}")
    public void user_enter_a_valid_email(String username) {
        // Write code here that turns the phrase above into concrete actions
       loginPage.setUserName(username);
    }

    @Given("User enter invalid password {string}")
    public void user_enter_invalid_password(String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.setPassword(password);
    }

    @Given("User clicks on login button")
    public void user_clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickOnLoginBtn();
    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        // Write code here that turns the phrase above into concrete actions;
        personalDetails=loginPage.clickOnDashboardLink();

    }

    @Given("User have entered a invalid {string} and {string}")
    public void user_have_entered_a_invalid_and(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.setUserName(username);
        loginPage.setPassword(password);

    }
    @Then("User should see an error message indicating {string}")
    public void user_should_see_an_error_message_indicating(String warning) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(loginPage.getWarningMessage(),warning);
    }
}
