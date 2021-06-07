package com.pages;

import com.UtilTestBaseFramework.Configreader;
import com.UtilTestBaseFramework.Utils;
import com.qa.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class CreateCollections {
    private WebDriver driver;
    private DriverFactory driverFactory;

    @FindBy(xpath = "//div[@class=\"GB_window\"]")
    WebElement confirmDuplicateItemsPopup;

    @FindBy(xpath = "//input[@name=\"ctl00$MainContent$dgShoppingBasket$ctl02$txtPUK\"]")
    WebElement enterPUKtextField;

    @FindBy(xpath = "//input[contains(@name,'ctl00$MainContent$dgItemsAtAddress')]")
    WebElement selectCollectionItem;

    @FindBy(xpath = " //a[contains(text(),'Collect Items')]")
    WebElement collectItem;

    @FindBy(xpath = "//select[@id='MainContent_ddlIssueType']")
    public WebElement selectIssueType;

    @FindBy(xpath = "//select[@id='MainContent_ddlFrailtyScale']")
    public WebElement selectFrailtyType;

    public CreateCollections(){
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);

    }

    public void selectDuplicateItem() throws Exception {

        if(Utils.isElementExist(confirmDuplicateItemsPopup)){
            Utils.switchToFrame(0);
            //driver.switchTo().frame(0);
            Utils.moveToElement(By.xpath("//div//input [@name=\"btnYes\"]"));
            Utils.clickFunctionByJavaScript(By.xpath("//div//input [@id=\"btnYes\"]"));
        }
        else if(Utils.isElementExist(By.xpath("//body[@class='popUpWindow']"))){
            Utils.clickFunctionByJavaScript(By.xpath("//input [@name=\"btnNo\""));
        }
        else{
            if(Utils.isElementExist(enterPUKtextField)){
              Utils.enterText(enterPUKtextField,"0");
                //Utils.BrowserTest.sleep(2000);
              Utils.clickFunction(By.xpath("//a[contains(text(),'Add to History')]"));
            }
            else {
                //Utils.BrowserTest.sleep(2000);
                Utils.clickFunction(By.xpath("//a[contains(text(),'Add to History')]"));
            }
        }
        if(Utils.isElementExist(enterPUKtextField)){
            Utils.enterText(enterPUKtextField,"0");
            //Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(By.xpath("//a[contains(text(),'Add to History')]"));
        }
        else {
            //Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(By.xpath("//a[contains(text(),'Add to History')]"));
        }

    }

    public void collectItem() throws Exception {
        Utils.clickFunction(selectCollectionItem);
        //Utils.BrowserTest.sleep(2000);
        Utils.clickFunction(collectItem);
    }

}






