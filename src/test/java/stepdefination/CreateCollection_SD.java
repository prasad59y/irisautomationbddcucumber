package stepdefination;

import com.UtilTestBaseFramework.Utils;
import com.pages.CreateCollections;
import com.pages.CreateOrder;
import com.pages.CreateSpecialorder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class CreateCollection_SD {
    private CreateCollections createCollections;
    private CreateOrder createOrder;

    public CreateCollection_SD() {
        this.createCollections = new CreateCollections();
        this.createOrder = new CreateOrder();
    }

    @Then("select Add Items for collections")
    public void selectAddItemsForCollections() throws Exception {
        Utils.clickFunction(By.xpath("//a[@id=\"MainContent_btnAddItemsToClientAddress\"]"));
    }

    @And("Click on the Add product Button")
    public void clickOnTheAddProductButton() throws Exception {
        Utils.BrowserTest.sleep(2000);
        Utils.clickFunction(By.xpath("//a[contains(text(),'Add Products')]"));
    }

    @Then("Accepct the delete popup window")
    public void accepctTheDeletePopupWindow() throws Exception {
        createCollections.selectDuplicateItem();
    }

    @And("select the Item from list and collectItem")
    public void selectTheItemFromListAndCollectItem() throws Exception {
        createCollections.collectItem();
    }

    @And("confirm and place requisation")
    public void confirmAndPlaceRequisation() throws Exception {
        Utils.selectValueForDropdown(createCollections.selectIssueType, "Collection");
        Utils.BrowserTest.sleep(2000);
        Utils.selectValueForDropdown(createCollections.selectFrailtyType, "Not Applicable");
        Utils.clickFunction(createOrder.confirmAndPlaceRequisition);
    }
}
