package com.pages;

import com.UtilTestBaseFramework.Configreader;
import com.UtilTestBaseFramework.Utils;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Properties;

public class CreateSpecialorder {

    private WebDriver driver;
    private DriverFactory driverFactory;
    private Configreader configReader;
    private Properties prop;

    @FindBy(xpath="//textarea[@id=\"MainContent_txtDesc\"]")
    WebElement specialDesp;

    @FindBy(xpath="//select[@id=\"MainContent_ddlIssueType\"]")
    WebElement specialIssueType;

    @FindBy(xpath="//select[@id=\"MainContent_ddlOrderType\"]")
    WebElement specialOrderType;

    @FindBy(xpath="//select[@id=\"MainContent_ddlCategory\"]")
    WebElement specialCategory;

    @FindBy(xpath="//input[@id=\"MainContent_txtSearch\"]")
    WebElement specialSupplierName;

    @FindBy(xpath="//input[@id=\"MainContent_txtValue\"]")
    WebElement specialvalue;

    @FindBy(xpath=" //textarea[@id=\"MainContent_txtSpecInst\"]")
    WebElement specialfurtherInfo;


       public CreateSpecialorder(){
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        configReader = new Configreader();
        prop = configReader.init_prop();


    }

    public void enterspecialOrderDetails(DataTable specialDetails) throws Exception {

        List<List<String>> createSpecial = specialDetails.asLists(String.class);
        for (List<String> list : createSpecial){
            String descption = list.get(0);
            Utils.enterText(specialDesp,descption);
            String issueType = list.get(1);
            Utils.enterText(specialIssueType,issueType);
            String orderType = list.get(2);
            Utils.enterText(specialOrderType,orderType);
            String category = list.get(3);
            Utils.enterText(specialCategory,category);
            String supplierName = list.get(4);
            Utils.enterText(specialSupplierName,supplierName);
            Utils.clickFunction(By.xpath("//a[@id=\"MainContent_btnSearch\"]"));
            String value = list.get(5);
            Utils.enterText(specialvalue,value);
            String futherInfo = list.get(6);
            Utils.enterText(specialfurtherInfo,futherInfo);

        }


    }
}
