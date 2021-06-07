package com.pages;

import com.UtilTestBaseFramework.Configreader;
import com.UtilTestBaseFramework.Utils;
import com.qa.factory.DriverFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;
import java.text.BreakIterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Authorisation {
    private Properties prop;
    private Configreader configReader;
    private CreateOrder createorder;
    private WebDriver driver;
    private String actualAuthoriseUID;
    private String expectedAuthoriseUID;

//   private DriverFactory driverFactory;
//    private Utils utils;

    public Authorisation() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        configReader = new Configreader();
        prop = configReader.init_prop();
//        this.utils = new Utils();
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        this.createorder = new CreateOrder();
    }

    @FindBy(xpath = "//span[contains(@class,'iconhlToAuthorize')]/following-sibling::text()")
    public WebElement authorisationtoMe;
    @FindBy(xpath = "//h1[contains(text(),'Orders For Me To Authorise')]")
    public WebElement authorisationPageTitle;
    @FindBy(xpath = "//a[@id='MainContent_dgToAuthorise_lnkOrderNo_0']")
    public WebElement authorisationUID;
    @FindBy(xpath = " //input[contains(@title,'Authorise Order')]")
    public WebElement authoriseOrderButton;
    @FindBy(xpath = "//input[@id=\"MainContent_dgToAuthorise_btnAuthCancel_0\"]")
    public WebElement cancelOrderButton;
    @FindBy(xpath = "//a[@id='btnCancelOrder']")
    public WebElement clickCancelOrder;

    @FindBy(xpath = " //a[@id='MainContent_dgAlreadyAuthorised_lnkOrderNo_0']")
    public WebElement authorisedUID;
    //a[@id='MainContent_dgAlreadyAuthorised_lnkOrderNo_0']
    @FindBy(xpath = " //input[@id='ChkClientPostcode']")
    public WebElement selectClientFirstPostcode;
    @FindBy(xpath = " //input[@id='ChkAttending']")
    public WebElement selectClientsecondPostcode;
    @FindBy(xpath = "//a[@id='MainContent_btnShowAuthorised']")
    public WebElement showAuthorisedOrders;
    @FindBy(xpath = "(//a[contains(text(),'UID')])[2]")
    public WebElement doubleClickAuthorisedOrder;

    @FindBy(xpath = "//a[starts-with(@id,'MainContent_dgAlreadyRejected_lnkOrderNo')]")
    public List<WebElement> cancelRejectedUIDs;


    public void validateAuthoisationpage() throws InterruptedException {

        //Utils.BrowserTest.sleep(2000);
        //String actualauthorisationpagetitle = Utils.getText(By.xpath("//h1[contains(text(),'Orders For Me To Authorise')]"));
        String actualauthorisationpagetitle = authorisationPageTitle.getText();
        //Utils.BrowserTest.sleep(2000);
        String expectedauthorisationpagetitle = prop.getProperty("authoisationpagetitle");
        //Utils.BrowserTest.sleep(2000);
        Assert.assertEquals(actualauthorisationpagetitle, expectedauthorisationpagetitle);
    }

    public void authoriseOrder() throws Exception {
        //Utils.BrowserTest.sleep(2000);
        actualAuthoriseUID = authorisationUID.getText();
        System.out.println(actualAuthoriseUID);
        Utils.clickFunction(authoriseOrderButton);
        //Utils.BrowserTest.sleep(2000);
        Utils.acceptAlert();
        if (Utils.isElementExist(createorder.confirmDuplicateItemsPopup)) {
            driver.switchTo().frame(0);
            if (selectClientFirstPostcode.isEnabled()) {
                Utils.clickFunction(selectClientFirstPostcode);
            } else {
                Utils.clickFunction(selectClientsecondPostcode);
            }
            Utils.clickFunction(By.xpath("//input[@name='btnAuth']"));
            ////Utils.BrowserTest.sleep(3000);
            Utils.acceptAlert();
        }

    }

    public void verifyAuthoriseOrder() throws Exception {
        //Utils.BrowserTest.sleep(2000);
        Utils.clickFunction(showAuthorisedOrders);
        //Utils.BrowserTest.sleep(3000);
        Utils.clickFunction(By.xpath("(//a[contains(text(),'UID')])[2]"));
        //Utils.BrowserTest.sleep(3000);
        Utils.clickFunction(By.xpath("(//a[contains(text(),'UID')])[2]"));
        // Utils.doubleClick(By.xpath("(//a[contains(text(),'UID')])[2]"));
        //Utils.doubleClick(doubleClickAuthorisedOrder);
        //Utils.BrowserTest.sleep(2000);
        expectedAuthoriseUID = authorisedUID.getText();
        //Utils.BrowserTest.sleep(2000);
        Utils.moveToElement(By.xpath("(//a[contains(text(),'UID')])[2]"));
        System.out.println(actualAuthoriseUID);
        System.out.println(expectedAuthoriseUID);
        Assert.assertEquals(actualAuthoriseUID, expectedAuthoriseUID);
    }

    public void cancelTheorder() throws Exception {
        //Utils.BrowserTest.sleep(2000);
        Utils.doubleClick(By.xpath("//a[contains(text(),'UID')]"));
        //Utils.BrowserTest.sleep(4000);
        Utils.doubleClick(By.xpath("//a[contains(text(),'UID')]"));
        Utils.moveToElement(authorisationUID);
        actualAuthoriseUID = authorisationUID.getText();
        System.out.println(actualAuthoriseUID);
        Utils.clickFunction(cancelOrderButton);
        //Utils.BrowserTest.sleep(2000);
        driver.switchTo().frame(0);
        //Utils.switchToFrame(0);
        Utils.clickFunction(clickCancelOrder);
        //Utils.BrowserTest.sleep(2000);
        Utils.acceptAlert();
        //Utils.BrowserTest.sleep(3000);
       // Utils.clickFunction(showAuthorisedOrders);
        Utils.moveToElement(By.xpath("(//a[contains(text(),'UID')])[3]"));
        //Utils.BrowserTest.sleep(3000);
        Utils.clickFunction(By.xpath("(//a[contains(text(),'UID')])[3]"));
        //Utils.BrowserTest.sleep(3000);
        Utils.clickFunction(By.xpath("(//a[contains(text(),'UID')])[3]"));


        for (int i = 0; i <= cancelRejectedUIDs.size(); i++) {
            expectedAuthoriseUID = cancelRejectedUIDs.get(i).getText();

            if (expectedAuthoriseUID.equals(actualAuthoriseUID)) {
                System.out.println(actualAuthoriseUID);
                System.out.println(expectedAuthoriseUID);
                Assert.assertTrue(expectedAuthoriseUID.equals(actualAuthoriseUID));
                System.out.println("Value is displaying in cancel order Bucket");
                break;
            }

        }
        //Assert.assertEquals(actualAuthoriseUID, expectedAuthoriseUID);
        //Assert.assertTrue();
        //table[@id='MainContent_dgAlreadyRejected']
    }
}




