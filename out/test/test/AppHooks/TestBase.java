package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.UtilTestBaseFramework.Configreader;
//import com.aventstack.extentreports.gherkin.model.Scenario;
import com.qa.factory.DriverFactory;
//import.io.cucumber.java.Before;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestBase {
private DriverFactory driverFactory;
private WebDriver driver;
private Configreader configReader;
Properties prop;

@Before(order = 0)
public void getProperty() {
configReader = new Configreader();
prop =configReader.init_prop();
	
}

@Before (order = 1)
public void launchBrowser() {
	String browserName =prop.getProperty("browser");
	driverFactory = new DriverFactory();
	driver = driverFactory.init_driver(browserName);
		
}

@Before (order = 2)

public void launchURL() {
	String url = prop.getProperty("testEnv");
	driver.get(url);
}

@After (order =0)
public void quitBrowser() {
//	driver.quit();
}

@After (order = 1)
public void tearDown(Scenario scenario) {
	if(scenario.isFailed()) {
		// Take screen shot
		String screenShotName = scenario.getName().replaceAll("", "_");
		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcePath, "image/png", screenShotName);
	}
}
}


