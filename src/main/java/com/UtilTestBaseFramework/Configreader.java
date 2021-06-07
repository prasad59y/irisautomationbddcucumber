package com.UtilTestBaseFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configreader {
	public Properties prop;
	
	/*
	 * This method is used to load the properties from run time config properties
	 * @return it returns properties prop objects
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream("./src/test/java/com/Resources/runtimeconfigProperties");
		prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}


}
