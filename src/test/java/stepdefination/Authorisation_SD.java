package stepdefination;

import com.UtilTestBaseFramework.Utils;
import com.pages.Authorisation;
import com.pages.CommonFunctions;
import com.pages.CreateOrder;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Authorisation_SD {
    private Authorisation authorisation;
    private Properties prop;
    private CommonFunctions commonFunctions;
    private CreateOrder createorder;

    public Authorisation_SD(){
        this.authorisation = new Authorisation();
        this.commonFunctions= new CommonFunctions();
        this.createorder = new CreateOrder();

    }


    @And("Click on for me to Authorisation")
    public void clickOnForMeToAuthorisation() throws Exception {
        Utils.BrowserTest.sleep(4000);
        Utils.clickFunction(By.xpath("//a[contains(@title,'Awaiting Authorisation by Me')]//span"));
       // Utils.clickFunction(By.xpath("//span[contains(@class,'iconhlToAuthorize')]/following-sibling::text()"));
       // Utils.clickFunction(authorisation.authorisationtoMe);

    }

    @When("Click on Show ALL Orders Requiring Authorisation button")
    public void clickOnShowALLOrdersRequiringAuthorisationButton() throws Exception {
        Utils.clickFunction(By.xpath("//a[contains(text(),'Show ALL Orders ')]"));
    }

    @Then("validate the Orders For Me To Authorise page")
    public void validateTheOrdersForMeToAuthorisePage() throws InterruptedException {
       authorisation.validateAuthoisationpage();

    }

    @Then("Validate the authorisation home page")
    public void validateTheAuthorisationHomePage() throws Exception {
      commonFunctions.validateAuthorisationLoginPage();
    }

    @Then("Authorise the order with post code")
    public void authoriseTheOrderWithPostCode() throws Exception {
authorisation.authoriseOrder();
    }

    @And("verify authorised UID is")
    public void verifyAuthorisedUIDIs() throws Exception {
        authorisation.verifyAuthoriseOrder();

    }



    @Then("cancel the  order and verify order id in rejected list")
    public void cancelTheOrderAndVerifyOrderIdInRejectedList() throws Exception {
        authorisation.cancelTheorder();
    }
    }

//    @And("validate cancel order")
//    public void validateCancelOrder() throws Exception {
//        authorisation.validatecancelOrder();
//    }
//}

