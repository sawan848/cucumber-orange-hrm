package org.example.app.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * 10/8/2024
 * 11:21 PM
 */
public class DriverManager {
    private String BaseURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    public WebDriver getDriver(String browser){
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("Chrome"))
        {driver=new ChromeDriver(  );
        }else if(browser.equalsIgnoreCase("Edge")){
            driver=new EdgeDriver(  );
        }
        driver.get(BaseURL);
        driver.manage().window().maximize();
        return driver;
    }
}
