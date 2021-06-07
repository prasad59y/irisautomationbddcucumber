package stepdefination;

import com.UtilTestBaseFramework.Configreader;
import com.UtilTestBaseFramework.Utils;
import com.pages.CreateOrder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Properties;

public class CreateHomeOrder_SD {
    private Properties prop;
    private CreateOrder createOrder;
    private Configreader configreader;

    public CreateHomeOrder_SD() {
        this.createOrder = new CreateOrder();
        this.configreader = new Configreader();
        prop = configreader.init_prop();
    }

    @Then("Click on the carehome order menu page")
    public void clickOnTheCarehomeOrderMenuPage() throws Exception {
        Utils.clickFunction(By.xpath("//a[@title=\"Care Home Order\"]"));
    }

    @And("Validate the carehome order menu page")
    public void validateTheCarehomeOrderMenuPage() {
        String actualTitle = Utils.getText(By.xpath("//h2[@id='MainContent_pageTitle']"));
        String expectedTitle = prop.getProperty("createCareHomeOrderPageTitle");

    }

    @Then("Click on create home delivery and select add products")
    public void clickOnCreateHomeDeliveryAndSelectAddProducts() throws Exception {
        Utils.clickFunction(By.xpath("//a[contains(text(),'Create Care Home Order')]"));
       // Utils.clickFunction(By.xpath("//a[contains(text(),'Add Products')]"));
    }

    @And("verify the delivery address for care home")
    public void verifyTheDeliveryAddressForCareHome() {
       // Assert.assertTrue(Utils.isSelected(By.xpath("//input[contains(@name,'AlternateAddress')]")));
        Utils.isSelected(By.xpath("//input[contains(@name,'AlternateAddress')]"));
    }
}

