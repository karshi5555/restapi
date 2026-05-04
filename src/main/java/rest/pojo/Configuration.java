package rest.pojo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private static Properties prop = new Properties();
	
	static {
		loadConfig();
	}

	public static void loadConfig() {

		// read the config.properties file and load the properties into a Properties
		// object

		String file = System.getProperty("user.dir") + "/src/test/resources/testdata/config.properties";

		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}
