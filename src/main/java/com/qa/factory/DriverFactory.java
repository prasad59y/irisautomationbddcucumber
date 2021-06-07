package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/*
	 * This method is used to intialize the thread local driver on the basis of given browser
	 * return web driver
	 */
	
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is "+browser);
		
		if(browser.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			//ChromeOptions handlingSSL = new ChromeOptions();
			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			//handlingSSL.setAcceptInsecureCerts(true);
			//WebDriver driver = new ChromeDriver (handlSSLErr);

			System.setProperty("webdriver.chrome.driver","./src/test/java/com/Drivers/chromedriver.exe");
			tlDriver.set(new ChromeDriver());

		}
		
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
	}
		else if (browser.equals("InternetExplore")) {
			WebDriverManager.iedriver().setup();
			tlDriver.set(new InternetExplorerDriver());
		}
		
		else {
			System.out.println("Pass the correct Browser value " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	/*
	 * this is used to get the driver with thread local
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
