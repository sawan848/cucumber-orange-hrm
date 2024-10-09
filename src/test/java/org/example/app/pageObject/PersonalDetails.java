package org.example.app.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 7/11/2023
 * 1:06 PM
 */
public class PersonalDetails extends BasePage{

    @FindBy(name = "firstName")
    private WebElement fistNameElement;
    @FindBy(name = "middleName")
    private WebElement middleNameElement;
    @FindBy(name = "lastName")
    private WebElement lastNameElement;
    public PersonalDetails(WebDriver driver) {
        super(driver);
    }

    public WebElement deleteTextFromInput(WebElement element){
        String s= Keys.chord(Keys.CONTROL,"a");
        element.sendKeys(s);
        element.sendKeys(Keys.DELETE);
        return  element;
    }
    public void setLastNameElement(String lastName) {
//       lastNameElement.sendKeys(lastName);
       WebElement element=deleteTextFromInput(lastNameElement);
       element.sendKeys(lastName);
    }

    public void setMiddleNameElement(String middleName) {
        WebElement element=deleteTextFromInput(middleNameElement);
       element.sendKeys(middleName);
    }

    public void setFistNameElement(String firstName) {
//       fistNameElement.sendKeys(firstName);
       WebElement element=deleteTextFromInput(fistNameElement);
       element.sendKeys(firstName);
    }
}
