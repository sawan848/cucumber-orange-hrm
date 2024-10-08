package org.example.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.DriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {

    DriverManager driverManager;
    WebDriver driver=null;
    @BeforeTest
    public void init(){
    driver=new org.example.app.driverFactory.DriverManager().getDriver("Chrome");
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        System.out.println(driver.getTitle());
        assertTrue(driver.getTitle().contains("OrangeHRM") );
        System.out.println(driver.getCurrentUrl() );
        try {
            Thread.sleep(4000);
        }catch (Exception e){e.printStackTrace();}
        driver.quit();

    }
}
