package TestRunner;

import org.junit.runner.RunWith;
//import.cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/Resources/features/login.feature",
                //"src/test/java/com/Resources/features/Createorder.feature"
        },
        glue = {"stepdefination", "AppHooks"},
        //format = {"pretty", "html:Test-output", "json:Test-output/cucumber.json", "junit:Test-output/cucumber.xml"},
        plugin = {"pretty",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

                //"timeline:test-output-thread/"

                //			plugin={"html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        }
        //publish = true


)

public class Login_TR {

}
/*
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/main/resources/features/DAC6/DAC6 Outbound File/AdminActions.feature/"}
		//src/main/resources/features/DAC6/DAC6 Outbound File/AdminActions.feature/
		//src/main/resources/features/DAC6/DAC6 Inbound File/AdminActions_InboundFile.feature/
		, glue = {"uk.gov.hmrc.casemanagement.tests.portal.cucumber"}

		, plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/CADXTestAutomationReport.html"}
)

 */

