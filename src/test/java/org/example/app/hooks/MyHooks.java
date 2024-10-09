package org.example.app.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.app.factory.DriverFactory;
import org.example.app.utils.ConfigReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Properties;

/**
*Jun 9, 20237:11:45 PM 
*
*/
public class MyHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties properties;
	
	
	@Before(order=0)
	public void getProperty() {
		configReader=new ConfigReader();
		properties=configReader.init_properties();
	}
	
	@Before(order=1)

	public void launchBrowser() {
		String browser = System.getProperty("Browser");
		//tring browser=properties.getProperty("browser");
//		driverFactory=new DriverFactory();
		driver= DriverFactory.init_driver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(properties.getProperty ( "url" ));
	}
	
//	@After(order=0)
//	public void quitBrowser() {
//		driver.quit();
//	}
	@After
	public void tearDown(Scenario scenario) {
		System.out.println("Scenario status =====>" + scenario);

		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		driver.quit();
	}
}


