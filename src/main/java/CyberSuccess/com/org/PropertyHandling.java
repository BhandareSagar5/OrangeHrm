package CyberSuccess.com.org;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandling {
	
	Properties property;
	
	public PropertyHandling() throws IOException {
		String filePath = "D:\\com.org\\config.properties";
		
		property = new Properties();
		FileInputStream input = new FileInputStream(filePath);
		
		//load the input file into the Properties class
		property.load(input);
		
	}
	
	public String getProperty(String key) {
		return property.getProperty(key);
	}

}
