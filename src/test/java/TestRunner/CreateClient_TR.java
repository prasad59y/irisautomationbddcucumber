package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {//"src/test/java/com/Resources/features/login.feature",
                //"src/test/java/com/Resources/features/Authorisation.feature",
              // "src/test/java/com/Resources/features/Createclient.feature",
                //"src/test/java/com/Resources/features/test.feature",
                //"src/test/java/com/Resources/features/CreateSpecialitem.feature",
              // "src/test/java/com/Resources/features/Createorder.feature",
               // "src/test/java/com/Resources/features/Createcollection.feature"
               //"src/test/java/com/Resources/features/SmokeTestsuite.feature"
                //"src/test/java/com/Resources/features/CareHomeorder.feature"
                //"src/test/java/com/Resources/features/BrokenLinks.feature"
                "src/test/java/com/Resources/features/iConBrokenLinks.feature"
        },
        glue = {"stepdefination", "AppHooks"},
        //format = {"pretty", "html:Test-output", "json:Test-output/cucumber.json", "junit:Test-output/cucumber.xml"},
        plugin = {"pretty", "html:target/cucumber-report.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
               // "timeline:test-output-thread/"

//                "html:target/cucumber-html-report",
//                "json:target/cucumber-reports/cucumber.json",
//                "junit:target/cucumber-reports/cucumber.xml",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

        }
       //,
              //publish=true


)

public class CreateClient_TR {

}




