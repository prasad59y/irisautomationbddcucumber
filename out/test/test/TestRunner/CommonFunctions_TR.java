package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/com/Resources/features/login.feature"},
		glue = {"stepdefination", "AppHooks"},
		//format = {"pretty", "html:test-output", "json:test-output/cucumber.json", "junit:test-output/cucumber.xml"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:Test-output-thread/"

		}
		
		)

public class CommonFunctions_TR {

}
/*
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/main/resources/features/DAC6/DAC6 Outbound File/AdminActions.feature/"}
		//src/main/resources/features/DAC6/DAC6 Outbound File/AdminActions.feature/
		//src/main/resources/features/DAC6/DAC6 Inbound File/AdminActions_InboundFile.feature/
		, glue = {"uk.gov.hmrc.casemanagement.tests.portal.cucumber"}
		, format = {"pretty", "html:test-output", "json:test-output/cucumber.json", "junit:test-output/cucumber.xml"}
		,tags = {"@TestAsh100"}
		, plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/CADXTestAutomationReport.html"}
)

 */

