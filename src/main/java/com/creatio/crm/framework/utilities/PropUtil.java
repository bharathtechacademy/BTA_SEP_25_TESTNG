package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {
	
	//Common method to read the data from properties file.
	public static Properties readData(String fileName) {	
		
		//Initially properties are null.
		Properties prop=null;
		
		try {
			//Read the properties file in Java.
			//System.getProperty("user.dir") - to get the project folder path automatically
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Config\\"+fileName);
			
			//Load all the properties available inside this file into the 'prop' variable.
			prop = new Properties();
			prop.load(fis);			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;		
	}
	
	
	public static void main(String [] args) {
		//Calling common method to read the properties.
		Properties prop = readData("Config.properties");
		
		System.out.println(prop.getProperty("APP_URL"));
		System.out.println(prop.getProperty("BROWSER"));
		

	}
	
	
	
	

}
