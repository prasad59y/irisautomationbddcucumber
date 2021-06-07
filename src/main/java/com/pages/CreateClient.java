package com.pages;

import com.UtilTestBaseFramework.Configreader;
import com.UtilTestBaseFramework.Utils;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class CreateClient {
    private WebDriver driver;
    private DriverFactory driverFactory;
    private Configreader configReader;
    private Properties prop;
   //private Utils utils;

    @FindBy(xpath = "//select[@id=\"MainContent_ddlTitle\"]")
    public WebElement clientTitle;
    @FindBy(xpath = "//input[@id=\"MainContent_txtForename\"]")
    public WebElement clientForename;
    @FindBy(xpath = "//input[@id=\"MainContent_txtDOB\"]")
    public WebElement clientDOB;
    @FindBy(xpath = "//select[@id=\"MainContent_ddlEthnicityCode\"]")
    public WebElement clientEthnicityCode;
    @FindBy(xpath = "//input[@id=\"MainContent_txtTelephone\"]")
    public WebElement clientTelephone;
    @FindBy(xpath = "//select[@id=\"MainContent_ddlGPCode\"]")
    public WebElement clientGPCode;
    @FindBy(xpath = "//input[@id=\"MainContent_txtSurName\"]")
    public WebElement clientSurName;
    @FindBy(xpath = "//input[@id=\"MainContent_txtPostcodeLookup\"]")
    public WebElement clientLookUppostCode;
    @FindBy(xpath = " //input[@id='MainContent_txtPostcodeLookup']")
    public WebElement clientPostCodeLookUp;
    @FindBy(xpath = "//a[@title=\"Lookup Address\"]")
    public WebElement findPostcode;
    @FindBy(xpath = "//span[@id=\"MainContent_lblQASNotAvailable\"]")
    public WebElement postcodeLookUpValidation;
    @FindBy(xpath = "//input[@title=\"House Name/No\"]")
    WebElement clientHouseNo;
    @FindBy(xpath = "//input[@title=\"Road\"]")
    WebElement clientRoad;
    @FindBy(xpath = "//input[@title=\"Town\"]")
    WebElement clientTown;
    @FindBy(xpath = "//input[@title=\"Postcode\"]")
    WebElement clientPostcode;
    @FindBy(xpath = "//a[@id='MainContent_btnAddClient']")
    WebElement addClient;
    @FindBy(xpath = "//select[@id='MainContent_lstPostCode1']")
    WebElement selectAddress;
    @FindBy(xpath = " //table//tr//td//input[@class='viewItem']")
    public WebElement selectClientFromList;


    public CreateClient() {

        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        configReader = new Configreader();
        prop = configReader.init_prop();
       //this.utils = new Utils();
    }

    public void createClient(DataTable clientData) throws Exception {
        List<List<String>> clientList = clientData.asLists(String.class);
        for (List<String> list : clientList) {
            System.out.println(list);
            //for (int i = 0; i < list.size(); i++) {
            String title = list.get(0);
            Utils.selectDropdownByVisibleText(clientTitle, title);
            String Forename = list.get(1);
            //Utils.BrowserTest.sleep(2000);
            Utils.enterText(clientForename, Forename);
            String DOB = list.get(2);
            //Utils.BrowserTest.sleep(2000);
            Utils.enterText(clientDOB, DOB);
            Utils.clickFunction(clientSurName);
            String SurName = list.get(3);
            //Utils.BrowserTest.sleep(2000);
            Utils.enterText(clientSurName, SurName);
            String Telephone = list.get(4);
            //Utils.BrowserTest.sleep(2000);
            Utils.enterText(clientTelephone, Telephone);
            String EthnicityCode = list.get(5);
            //Utils.BrowserTest.sleep(2000);
            //   Utils.selectByValue(clientEthnicityCode, EthnicityCode);
            // String value = Utils.getFirstSelectedOption(clientEthnicityCode);
            // System.out.println(value);
            Utils.selectDropdownByVisibleText(clientEthnicityCode, EthnicityCode);
            String GPCode = list.get(6);
            //Utils.BrowserTest.sleep(2000);
            //  Utils.selectByValue(clientGPCode, GPCode);
            Utils.selectDropdownByVisibleText(clientGPCode, GPCode);
            Utils.clickFunction(findPostcode);
        }

    }

//    public void enterPostCode() throws Exception {
//        Utils.enterText(clientPostCodeLookUp, "Ng9 6Ng");
//        //Utils.BrowserTest.sleep(2000);
 //      Utils.clickFunction(findPostcode);
//    }

    public void enterorSelectAddress(DataTable clientAddress) throws Exception {
       // if (Utils.isElementExist(postcodeLookUpValidation)) {
            List<List<String>> clientAdds = clientAddress.asLists(String.class);
            for (List<String> list : clientAdds) {
                System.out.println(list);
                String houseNo = list.get(0);
                Utils.enterText(clientHouseNo, houseNo);
                String road = list.get(1);
                //Utils.BrowserTest.sleep(2000);
                Utils.enterText(clientRoad, road);
                String town = list.get(2);
                //Utils.BrowserTest.sleep(2000);
                Utils.enterText(clientTown, town);
                String postCode = list.get(3);
                //Utils.BrowserTest.sleep(2000);
                Utils.enterText(clientPostcode, postCode);
                //Utils.BrowserTest.sleep(2000);
                Utils.clickFunction(addClient);
           }

//        } else {
//            //Utils.BrowserTest.sleep(2000);
//            Utils.clickFunction(selectAddress);
//            //Utils.BrowserTest.sleep(2000);
//            Utils.clickFunction(addClient);
//        }
    }

    public void enterDetailsExample(String a, String b, String c, String d, String e, String f, String g) throws Exception {
        Utils.selectDropdownByVisibleText(clientTitle, a);
        //Utils.BrowserTest.sleep(2000);
        Utils.enterText(clientForename, b);
        //Utils.BrowserTest.sleep(2000);
        Utils.enterText(clientDOB, c);
        Utils.clickFunction(clientSurName);
        //Utils.BrowserTest.sleep(2000);
        Utils.enterText(clientSurName, d);
        //Utils.BrowserTest.sleep(2000);
        Utils.enterText(clientTelephone, e);
        //Utils.BrowserTest.sleep(2000);
        Utils.selectDropdownByVisibleText(clientEthnicityCode, f);
        //Utils.BrowserTest.sleep(2000);
        Utils.selectDropdownByVisibleText(clientGPCode, g);
        Utils.clickFunction(findPostcode);
    }

    public void enterorSelectAddressExample(String h, String i, String j, String k) throws Exception {
       // if (Utils.isElementExist(postcodeLookUpValidation)) {
            Utils.enterText(clientHouseNo, h);
            //Utils.BrowserTest.sleep(2000);
            Utils.enterText(clientRoad, i);
            //Utils.BrowserTest.sleep(2000);
            Utils.enterText(clientTown, j);
            //Utils.BrowserTest.sleep(2000);
            Utils.enterText(clientPostcode, k);
            //Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(addClient);
 //       }
//        else{
//            //Utils.BrowserTest.sleep(2000);
//            Utils.clickFunction(selectAddress);
//            //Utils.BrowserTest.sleep(2000);
//            Utils.clickFunction(addClient);
//        }

    }

    public void selectNewClient() throws Exception {

            //  Utils.clickFunctionByJavaScript(By.xpath("//a[contains(text(),'Create New Client')]"));
            //Utils.BrowserTest.sleep(2000);
            //Utils.enterKeyvalue(By.xpath("//a[contains(@href,'btnAddClient')]"), Keys.SHIFT);
            //Utils.enterText(By.xpath("//a[contains(@href,'btnAddClient')]"),"");
           // Utils.focusElement();
        Utils.clickFunction(By.xpath("//a[contains(@href,'btnAddClient')]"));
            // Utils.mousehoverclick(By.xpath("//a[contains(@href,'btnAddClient')]"));

    }

}




