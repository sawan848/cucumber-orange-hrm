package org.example.app.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 7/11/2023
 * 11:20 AM
 */
public class LoginPage extends BasePage{
    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement userNameElement;

    @FindBy(name = "password")
    private WebElement passwordElement;
    @FindBy(xpath="//button[normalize-space()='Login']")
    private WebElement loginBtnElement;

    @FindBy(partialLinkText = "My Info")
    private WebElement dashboardLink;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement warningMsg;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public void clickOnLoginBtn(){
        loginBtnElement.click();
    }
    public PersonalDetails clickOnDashboardLink(){
        dashboardLink.click();
        return new PersonalDetails(driver);
    }
    public String getWarningMessage(){return warningMsg.getText();}
    public void setPassword(String pwd) {passwordElement.sendKeys(pwd); }
    public void setUserName(String userName) {userNameElement.sendKeys(userName);}
}
