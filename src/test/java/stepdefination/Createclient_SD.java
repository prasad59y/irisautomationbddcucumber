package stepdefination;

import com.UtilTestBaseFramework.Configreader;
import com.UtilTestBaseFramework.Utils;
import com.pages.CommonFunctions;
import com.pages.CreateClient;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;

public class Createclient_SD {
    private CommonFunctions commonFunctions;
    private CreateClient createClient;
    private Properties prop;
    private Configreader configReader;

    public Createclient_SD() {
        this.commonFunctions = new CommonFunctions();
        this.createClient = new CreateClient();
        configReader = new Configreader();
        prop = configReader.init_prop();
    }

    @Then("click on new client and enter details")
    public void clickOnNewClientAndEnterDetails() throws Exception {
        createClient.selectNewClient();

    }


    @Then("enter pin code and click on find button")
    public void enterPinCodeAndClickOnFindButton() {
    }

    @Then("User enter the following client details")
    public void userEnterTheFollowingClientDetails(DataTable dataTable) throws Exception {
        createClient.createClient(dataTable);
    }

    @Then("enter pin code {string} and click on find button")
    public void enterPinCodeAndClickOnFindButton(String pincode) throws Exception {
       // createClient.enterPostCode();

    }

    @When("Address not found with postalcode")
    public void addressNotFoundWithPostalcode(DataTable clientAddress) throws Exception {
        createClient.enterorSelectAddress(clientAddress);
    }

    @Then("user enter details {string}and {string} and {string}and {string}and {string}{string}and {string}")
    public void userEnterDetailsAndAndAndAndAnd(String a, String b, String c, String d, String e, String f, String g) throws Exception {
       createClient.enterDetailsExample(a,b,c,d,e,f,g);
    }

    @When("Address not found with postalcode {string}and{string}and{string}and{string}")
    public void addressNotFoundWithPostalcodeAndAndAnd(String h, String i, String j, String k) throws Exception {
        createClient.enterorSelectAddressExample(h,i,j,k);
    }


    @And("Validate the new client Page")
    public void validateTheNewClientPage() throws InterruptedException {
        Utils.BrowserTest.sleep(2000);
        //Utils.isElementExist(By.xpath("//div[contains(text(),'Service User')]"));
        String newClientPage = Utils.getText(By.xpath("//div[contains(text(),'Service User')]"));
        Assert.assertEquals(newClientPage, prop.getProperty("createNewclientPageTitle"));
    }
}

