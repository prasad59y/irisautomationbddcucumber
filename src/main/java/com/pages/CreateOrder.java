package com.pages;

import com.UtilTestBaseFramework.Configreader;
import com.UtilTestBaseFramework.Utils;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CreateOrder extends Configreader {
    private WebDriver driver;
    private DriverFactory driverFactory;
    private String actualCOTitle;
    private String expectedCOTitle;
    private Configreader configReader;
    private Properties prop;
    private Utils utils;


    //Find by locators

    @FindBy(xpath = "//a[contains(@title,'Create an Order ')]")
    WebElement createOrderLink;

    @FindBy(xpath = "//h2[contains(text(),'Create Order')]")
    WebElement createOrderPageTitle;

    @FindBy(xpath = "//input [@title='Enter Client Surname']")
    WebElement enterClientSurname;

    @FindBy(xpath = "//a[@id='MainContent_ClientSearch1_btnSearch']")
    WebElement clientsearchButton;

    @FindBy(xpath = "(//input[@class='viewItem'])[1]")
    WebElement selectClientFromList;

    @FindBy(xpath = "//table//tr//td//a[contains(@id,\"MainContent_ClientSearch1_dgClientSearch_lnkSurname\")]")
    List<WebElement> surnameDetailsList;

    @FindBy(xpath = "//table[@id=\"MainContent_dgShoppingBasket\"]//td[4]")
    List<WebElement> orderBasketList;

    //table[@id="MainContent_dgShoppingBasket"]//td[4]

    @FindBy(xpath = "(//div[@class=\"subCatViewBox\"])[1]//table//tbody//tr//a")
    List<WebElement> selectsubCatViewBox;

    @FindBy(xpath = "//a[@id='MainContent_btnAddToCart_1']")
    public WebElement addFirstProductFromSubCat;

    @FindBy(xpath = "//a[contains(@title,'Create an Order ')]")
    public WebElement clickCreateOrderLink;

    @FindBy(xpath = "//a[@class=\"basketButton\"]")
    public WebElement clickBasketButton;

    @FindBy(xpath = "//input[contains(@id,'MainContent_dgShoppingBasket_imbDelete')]")
    List<WebElement> removeItems;


    @FindBy(xpath = "//input[@value=\"Confirm Delivery Instructions\"]")
    public WebElement confirmDelivery;
    @FindBy(xpath = " //div[contains(text(),'Please select an Issue Type')]")
    WebElement issueTypeErrorMessage;
    @FindBy(xpath = "//select[@id=\"MainContent_ddlIssueType\"]")
    WebElement issueTypeDropDown;
    @FindBy(xpath = "//select[@id=\"MainContent_ddlFrailtyScale\"]")
    WebElement frailtyScaleDropDown;

    @FindBy(xpath = "//input[contains(@value,\"Confirm Delivery Instructions\")]")
    WebElement confirmDeliveryInstructions;
    @FindBy(xpath = "//input[contains(@value,\"Confirm Authorised Order\")]")
    WebElement confirmAuthorisedOrder;
    @FindBy(xpath = "//div[@class=\"GB_window\"]")
    public WebElement confirmDuplicateItemsPopup;
    @FindBy(xpath = "//input[@value=\"Confirm and Place Requisition\"]")
    public WebElement confirmAndPlaceRequisition;
    @FindBy(xpath = "//a[contains(@title,'Create an Order ')]//span")
    public WebElement clickOnCreateOrder;

    @FindBy(xpath = "//select[contains(@name,'AlternatePrescribers')]")
    public WebElement selectAlternatePrescribers;

    @FindBy(xpath = "//select[contains(@name,'AlternatePrescribers')]//option[2]")
    public WebElement selectPrescriber;

    @FindBy(xpath = "//span[contains(text(),'Care Home Type')]")
    public WebElement careHomeTypeOption;

    @FindBy(xpath = "//select[contains(@name,'CareHomeTypes')]/option[2]")
    public WebElement selectCareHomeType;

    @FindBy(xpath = "    //select[contains(@name,'CareHomes')]/option[2]")
    public WebElement selectCareHome;


    // constructor of the page class
    public CreateOrder() {
        this.driver = DriverFactory.getDriver();
        this.utils = new Utils();
        PageFactory.initElements(driver, this);
        configReader = new Configreader();
        prop = configReader.init_prop();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // WebDriverWait wait = new WebDriverWait(driver, 5);
    }

    public void clickOnCreateOrder() throws Exception {
        ////Utils.BrowserTest.sleep(2000);
        Utils.clickFunction(clickCreateOrderLink);

    }

    public void validateCOMenuPage() throws InterruptedException {
        //CO = Createorder
        ////Utils.BrowserTest.sleep(2000);
        actualCOTitle = createOrderPageTitle.getText();
        expectedCOTitle = prop.getProperty("createOrderPageTitle");
        ////Utils.BrowserTest.sleep(2000);
        Assert.assertEquals(actualCOTitle, expectedCOTitle);

    }

    public void searchClientName(String surName) throws Exception {
        if (selectAlternatePrescribers.isDisplayed()) {
            ////Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(selectPrescriber);
            enterClientSurname.sendKeys(surName);
            Utils.moveToElement(clientsearchButton);
            ////Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(clientsearchButton);
            ////Utils.BrowserTest.sleep(2000);

                if (Utils.isElementExist(careHomeTypeOption)) {
                    Utils.clickFunction(selectCareHomeType);
                    Utils.clickFunction(selectCareHome);
                    //enterClientSurname.sendKeys(surName);
                    //Utils.moveToElement(clientsearchButton);
                    ////Utils.BrowserTest.sleep(2000);
                    //Utils.clickFunction(clientsearchButton);
                }
            }

         else {

            ////Utils.BrowserTest.sleep(2000);
            enterClientSurname.sendKeys(surName);
            Utils.moveToElement(clientsearchButton);
            ////Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(clientsearchButton);
            // Utils.clickFunction(By.xpath("//a[@id='MainContent_ClientSearch1_btnSearch']"));
        }
    }

    public void surnameSearchResultsValidation(String surname) {
        for (int i = 0; i < surnameDetailsList.size(); i++) {
            String getRowValue = surnameDetailsList.get(i).getText().toLowerCase();
            Assert.assertTrue(getRowValue.contains(surname));
            // Assert.assertTrue(surname.contains(getRowValue));

        }

    }

    public void selectCatalogue() throws Exception {
        // List<List<String>> lists = Catalogue.asList(String.class);
        // for (List<String> list :lists){
        int itemsCount = selectsubCatViewBox.size();

        System.out.println(itemsCount);
        for (int i = 0; i < itemsCount; i++) {
            //////Utils.BrowserTest.sleep(1000);
            // Utils.clickFunction(selectsubCatViewBox.get(i));
            Utils.doubleClick(selectsubCatViewBox.get(i));
            //////Utils.BrowserTest.sleep(1000);
            Utils.clickFunction(addFirstProductFromSubCat);
            if (Utils.isElementExist(confirmDuplicateItemsPopup)) {
                Utils.switchToFrame(0);
                //driver.switchTo().frame(0);
                Utils.moveToElement(By.xpath("//div//input [@name=\"btnYes\"]"));
                Utils.clickFunctionByJavaScript(By.xpath("//div//input [@id=\"btnYes\"]"));
                //////Utils.BrowserTest.sleep(1000);
                Utils.clickFunction(By.xpath("//a[contains(text(),'Add Products')]"));
            } else {
                //////Utils.BrowserTest.sleep(1000);
                Utils.clickFunction(By.xpath("//a[contains(text(),'Add Products')]"));
            }

        }
        Utils.clickFunction(clickBasketButton);
        ////Utils.BrowserTest.sleep(2000);
        int orderCount = orderBasketList.size() - 1;
        System.out.println(orderCount);
        Assert.assertTrue(itemsCount == orderCount);
    }

    public void removeItems() {
        int countOfitemsremoved = removeItems.size();
        System.out.println(countOfitemsremoved);
        for (int i = 0; i < countOfitemsremoved; i++) {
            //  //Utils.BrowserTest.sleep(3000);
            try {
                Utils.clickFunctionByJavaScript(removeItems.get(0));

                ////Utils.BrowserTest.sleep(2000);
                Utils.acceptAlert();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        Assert.assertTrue(removeItems.size() == 0);
    }

    public void orderConfirmation() throws InterruptedException {
        String actualresult = Utils.getText(By.xpath("//h1[contains(text(),'Order Confirmation')]"));
        String expectedresult = prop.getProperty("orderpageCreation");
        ////Utils.BrowserTest.sleep(2000);
        Assert.assertEquals(actualresult, expectedresult);
        String orderId = Utils.getText(By.xpath("//span[@id='MainContent_lblOrderNo']"));
        ////Utils.BrowserTest.sleep(2000);
        System.out.println(orderId);
    }

    public void confirmDeliveryInstructions() throws Exception {

        Utils.clickFunction(confirmDelivery);
        //String actualErrorMessage = issueTypeErrorMessage.getText().trim();
        //System.out.println(actualErrorMessage);

        if (Utils.isElementExist(issueTypeErrorMessage)) {
            //if (issueTypeErrorMessage.getText().trim().contains("Please select an Issue Type")) {
            ////Utils.BrowserTest.sleep(2000);
            Utils.selectDropdownByVisibleText(issueTypeDropDown, "PC - Pallative Care");
            ////Utils.BrowserTest.sleep(2000);
            Utils.selectDropdownByVisibleText(frailtyScaleDropDown, "Very Fit");
            ////Utils.BrowserTest.sleep(2000);
            //Utils.clickFunction(confirmDeliveryInstructions);
            ////Utils.BrowserTest.sleep(2000);
            // Utils.clickFunction(confirmAuthorisedOrder);
            ////Utils.BrowserTest.sleep(2000);
           // Utils.clickFunction(By.xpath("//input[contains(@name,'cbxAuthSelected')]"));
            ////Utils.BrowserTest.sleep(2000);
       //     Utils.clickFunction(confirmAndPlaceRequisition);

        } else {
            ////Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(By.xpath("//option[@value=\"Hospital Discharge\"]"));
            ////Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(By.xpath("//input[contains(@name,'rptForms$ctl00$rptSections$ctl00$rptQuestions$ctl02')]"));
            ////Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(By.xpath("//input[contains(@name,'rptForms$ctl00$rptSections$ctl00$rptQuestions$ctl03')]"));
            ////Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(By.xpath("//input[contains(@name,'rptForms$ctl00$rptSections$ctl00$rptQuestions$ctl04')]"));
            ////Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(By.xpath("//a[@class=\"formDependent formPopUpSave\"]"));
            ////Utils.BrowserTest.sleep(2000);
           // Utils.clickFunction(By.xpath("//input[@name=\"ctl00$MainContent$btnConfirmandPlace\"]"));
            ////Utils.BrowserTest.sleep(2000);
           // Utils.clickFunction(By.xpath("//input[contains(@name,'cbxAuthSelected')]"));
            ////Utils.BrowserTest.sleep(2000);
         //   Utils.clickFunction(confirmAndPlaceRequisition);
        }

    }

    public void confirmdeliveryinstandplacereq() throws Exception {
        Utils.clickFunction(confirmDeliveryInstructions);
        Utils.clickFunction(By.xpath("//input[contains(@name,'cbxAuthSelected')]"));
        Utils.clickFunction(confirmAndPlaceRequisition);
    }


}







