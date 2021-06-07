package stepdefination;

import com.UtilTestBaseFramework.Configreader;
import com.UtilTestBaseFramework.Utils;
import com.pages.CommonFunctions;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class CommonFunctions_SD {
    private CommonFunctions commonFunctions;
    private Properties prop;
    private Configreader configReader;

    //private WebDriver driver;
    public CommonFunctions_SD() {
        this.commonFunctions = new CommonFunctions();
        configReader = new Configreader();
        prop = configReader.init_prop();
    }

    @Given("^user logins using the pinid \"([^\"]*)\"$")
    public void userLoginsUsingThePinid(String pinId) throws Throwable {
       // commonFunctions.loginInTotheApplication(pinId, prop.getProperty("password"));
        commonFunctions.loginInTotheApplication(pinId);

    }


    @And("Log out to the application")
    public void logOutToTheApplication() throws Exception {
        commonFunctions.logoutToTheApplication();
    }

    @Then("Validate the home page")
    public void validateTheHomePage() throws Exception {
        commonFunctions.validateLoginPage();
    }

    @Given("user logins using the auth pinid {string}")
    public void userLoginsUsingTheAuthPinid(String pinID) throws Throwable{
        commonFunctions.loginInTotheApplicationauth(pinID, prop.getProperty("autpassword"));

    }

    @And("Select the latest UId")
    public void selectTheLatestUId() throws Exception {
        Utils.BrowserTest.sleep(2000);
        Utils.clickFunction(By.xpath("//a[contains(text(),'UID')]"));
//       Utils.BrowserTest.sleep(4000);
//        Utils.clickFunction(By.xpath("//a[contains(text(),'UID')]"));

    }

    @Then("Validate broken links in the page")
    public void validateBrokenLinksInThePage() throws Exception {
        commonFunctions.brokenLinksInthePage();
    }

    @Given("user logins using the iconpinid {string}")
    public void userLoginsUsingTheIconpinid(String pinPid) throws Throwable {
        commonFunctions.loginInTotheiCONApplication( pinPid);
    }
}