package org.example.app.factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
*Jun 9, 20237:13:38 PM 
*
*/
public class DriverFactory {
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();


	public WebDriver driver;

	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */
	public static WebDriver init_driver(String browser) {
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
			
			tlDriver.set(new ChromeDriver());
			
		}else if(browser.equals("firefox")){
			
			tlDriver.set(new FirefoxDriver());
			
		}else if(browser.equals("edge")){
			tlDriver.set(new EdgeDriver());
			
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		return getDriver();
	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}


