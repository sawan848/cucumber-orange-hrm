package org.example.app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
*Jun 9, 20238:18:11 PM 
*
*/
public class ConfigReader {
	private Properties properties;

	/**
	 * This method is used to load the propertieserties from config.propertieserties file
	 * @return it returns propertieserties properties object
	 */
	public Properties init_properties() {

		properties = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/conf/config.properties");
			properties.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;

	}
}


