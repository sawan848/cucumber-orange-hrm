package org.example.app.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * 7/11/2023
 * 11:21 AM
 */
public class BasePage {
    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
