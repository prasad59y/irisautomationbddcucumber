package stepdefination;


import com.UtilTestBaseFramework.Utils;
import com.pages.CreateClient;
import com.pages.CreateOrder;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateOrder_SD {
    private CreateOrder createOrder;
    private CreateClient createClient;
   private DriverFactory driverFactory;
    private WebDriver driver;

    public CreateOrder_SD() {
        this.createOrder = new CreateOrder();
        this.createClient=new CreateClient();
      this.driver = DriverFactory.getDriver();

    }

    @Then("Click on the create order menu page")
    public void clickOnTheCreateOrderMenuPage() throws Exception {
        Utils.BrowserTest.sleep(2000);
        Utils.acceptAlert();
        Utils.moveToElement(createOrder.clickOnCreateOrder);
        Utils.BrowserTest.sleep(2000);
       // Utils.clickFunction(createOrder.clickOnCreateOrder);
       Utils.clickFunction(By.xpath("//a[contains(@title,'Create an Order ')]//span"));

    }

    @And("Validate the create order menu page")
    public void validateTheCreateOrderMenuPage() throws Exception {
        createOrder.validateCOMenuPage();
    }

    @Then("enter the client surname {string}")
    public void enterTheClientSurname(String surName) throws Exception {
        createOrder.searchClientName(surName);
    }

    @And("click on client search button")
    public void clickOnClientSearchButton() throws Exception {

    }


    @And("Select the one of the client from the list")
    public void selectTheOneOfTheClientFromTheList() throws Exception {
        Utils.clickFunction(createClient.selectClientFromList);
        // Utils.clickFunctionByJavaScript(By.xpath("(//input[@class='viewItem'])[1]"));

    }

    @And("validate the client search results {string}")
    public void validateTheClientSearchResults(String surname) {
        createOrder.surnameSearchResultsValidation(surname);
    }


    @Then("click on the create delivery and select Add products")
    public void clickOnTheCreateDeliveryAndSelectAddProducts() throws Exception {
        Utils.clickFunction(By.xpath("//a[contains(text(),'Create Delivery')]"));
       // Utils.BrowserTest.sleep(2000);
       Utils.clickFunction(By.xpath("//a[contains(text(),'Add Products')]"));

    }

    @Then("select the Catalogue menu from the First List")
    public void selectTheCatalogueMenuFromTheFirstList() throws Exception {
        createOrder.selectCatalogue();
    }

    @And("Remove all Items from the List")
    public void removeAllItemsFromTheList() throws Exception {
        createOrder.removeItems();
    }

    @And("Add all the Items from the first catalogue")
    public void addAllTheItemsFromTheFirstCatalogue() {

    }

    @Then("Validate all the Items in Basket List")
    public void validateAllTheItemsInBasketList() {

    }

    @Given("Add the one item from the catalogue")
    public void addTheOneItemFromTheCatalogue() throws Exception {

        Utils.clickFunction(By.xpath("//a[contains(text(),'Add Products')]"));
        Utils.BrowserTest.sleep(2000);
        Utils.clickFunction(By.xpath("(//div[@class=\"subCatViewBox\"])[2]//table//tbody//tr//td//a[1]"));
        Utils.BrowserTest.sleep(2000);
        Utils.clickFunction(createOrder.addFirstProductFromSubCat);
        if (Utils.isElementExist(createOrder.confirmDuplicateItemsPopup)) {
            Utils.switchToFrame(0);
            //driver.switchTo().frame(0);
            Utils.moveToElement(By.xpath("//div//input [@name=\"btnYes\"]"));
            Utils.clickFunctionByJavaScript(By.xpath("//div//input [@id=\"btnYes\"]"));
            //Utils.BrowserTest.sleep(2000);
           //Utils.clickFunction(By.xpath("//a[@id=\"MainContent_btnPlaceRequisition\"]"));
        }
        else{
            Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(By.xpath("//a[@id=\"MainContent_btnPlaceRequisition\"]"));
        }
        }

        @Then("Place the  Requisition")
        public void placeTheRequisition () {
            try {
                Utils.clickFunction(By.xpath("//a[@id=\"MainContent_btnPlaceRequisition\"]"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @And("select the covid {int} check Questions")
        public void selectTheCovidCheckQuestions ( int arg0){
            try {
                Utils.clickFunction(By.xpath("(//input[contains(@name,'rptForms')])[3]"));
                Utils.BrowserTest.sleep(2000);
                Utils.clickFunctionByJavaScript(By.xpath("(//input[contains(@name,'rptForms')])[5]"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Then("Confirm the delivery instructions")
        public void confirmTheDeliveryInstructions () throws Exception {
            createOrder.confirmDeliveryInstructions();
        }

        @And("Validate the order confirmation")
        public void validateTheOrderConfirmation () {
            try {
                createOrder.orderConfirmation();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    @And("Confirm and place the requisation to create order")
    public void confirmAndPlaceTheRequisationToCreateOrder() throws Exception {
       createOrder.confirmdeliveryinstandplacereq();
    }


//    @Then("Confirm the delivery instructions{string}")
//    public void confirmTheDeliveryInstructions(String form) {
//        createOrder.confirmDeliveryInstructions();
//    }


    }
