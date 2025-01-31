package vTiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist to method related to property file
 * 
 */
public class PropertyFileutility {

	/**
	 * This method is used to read the data from property file if key is passed
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String toReadDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}
