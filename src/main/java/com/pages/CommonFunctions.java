package com.pages;

import com.UtilTestBaseFramework.Configreader;
import com.qa.factory.DriverFactory;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.UtilTestBaseFramework.Utils;
import org.testng.Assert;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CommonFunctions {

    private WebDriver driver;
    private DriverFactory driverFactory;
    private Configreader configReader;
    private Properties prop;
    //Find by locators

    @FindBy(xpath = "//input[@id='MainContent_txtPIN']")
    WebElement pintextField;
    @FindBy(xpath = "//input[@id='txtUsername']")
    WebElement iCONpintextField;


    @FindBy(xpath = "//input[@id=\"txtPassword\"]")
    WebElement iCONPasswordtextField;

    @FindBy(xpath = "//input[@id='MainContent_txtPassword']")
    WebElement passwordTextField;

    @FindBy(xpath = "//a[@id=\"MainContent_btnLogin\"]")
    WebElement loginButton;

    @FindBy(xpath = "//input[@id=\"btnLogin\"]")
    WebElement iCONLoginButton;


    @FindBy(xpath = "//span[@id='MainContent_lblImageError2']")
    WebElement landingPageHeading;

    @FindBy(xpath = "//a[@id='MasterLoginStatus']")
    WebElement logoutPage;

    @FindBy(xpath = "//iframe[@id=\"GB_frame\"]")
    WebElement logInConfirmation;
    @FindBy(xpath = "//input[@name=\"btnLogin\"]")
    WebElement confirmLogin;
    @FindBy(xpath = " //div//p[contains(text(),'Home page top section.')]")
    WebElement authLandingPage;

    public CommonFunctions() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
        configReader = new Configreader();
        prop = configReader.init_prop();
    }

    // Page Actions scripts

    public void loginInTotheApplication(String pinid) throws Throwable {
        //Utils.BrowserTest.sleep(2000);
        pintextField.sendKeys(pinid);
        //Utils.BrowserTest.sleep(2000);
        // passwordTextField.sendKeys(password);
        passwordTextField.sendKeys(prop.getProperty("password"));
        //Utils.BrowserTest.sleep(3000);
        Utils.clickFunction(loginButton);

        if (Utils.isElementExist(confirmLogin)) {
            Utils.switchToFrame(0);
            Utils.clickFunction(confirmLogin);
        } else {
            System.out.println("Login to the application sucessfully");
        }
    }
    public void loginInTotheiCONApplication(String iconpinid) throws Throwable {
        //Utils.BrowserTest.sleep(2000);
        iCONpintextField.sendKeys(iconpinid);
        //Utils.BrowserTest.sleep(2000);
        // passwordTextField.sendKeys(password);
        iCONPasswordtextField.sendKeys(prop.getProperty("password1"));
        //Utils.BrowserTest.sleep(3000);
        Utils.clickFunction(iCONLoginButton);

        if (Utils.isElementExist(confirmLogin)) {
            Utils.switchToFrame(0);
            Utils.clickFunction(confirmLogin);
        } else {
            System.out.println("Login to the application sucessfully");
        }
    }

    public void loginInTotheApplicationauth(String pinid, String autPassword) throws Throwable {
        //Utils.BrowserTest.sleep(2000);
        pintextField.sendKeys(pinid);
        //Utils.BrowserTest.sleep(2000);
        passwordTextField.sendKeys(autPassword);
        //Utils.BrowserTest.sleep(3000);
        Utils.clickFunction(loginButton);

        if (Utils.isElementExist(confirmLogin)) {
            Utils.switchToFrame(0);
            Utils.clickFunction(confirmLogin);
        } else {
            System.out.println("Login to the application sucessfully");
        }
    }

    public void validateLoginPage() throws Exception {
        //Utils.BrowserTest.sleep(2000);
        String loginPageDefaultMenu = landingPageHeading.getText();
        String expectedLandingPageMenu = prop.getProperty("landingHomePageHeading");
        Assert.assertEquals(loginPageDefaultMenu, expectedLandingPageMenu);
    }

    public void validateAuthorisationLoginPage() throws Exception {
        //Utils.BrowserTest.sleep(2000);
      //  String loginPageDefaultMenus =  driver.findElement(By.xpath("//div//p[contains(text(),'Home page top section.')]")).getText();
      //  String loginPageDefaultMenus = Utils.getText(By.xpath("//div//p[contains(text(),'Home page top section.')]"));
       String loginPageDefaultMenu = authLandingPage.getText();

        String expectedLandingPageMenu = prop.getProperty("landingauthHomePageHeading");
        Assert.assertEquals(loginPageDefaultMenu, expectedLandingPageMenu);
    }

    public void logoutToTheApplication() throws Exception {
        Utils.clickFunction(logoutPage);
    }

    public void brokenLinksInthePage() throws Exception {
        // 1. get all the list of links in the page
       // Utils.clickFunctionByJavaScript(By.xpath("//a[@id='Navigation1_Admin']"));
                //.clickFunction(By.xpath("//a[@id='Navigation1_Admin']"));
       List<WebElement> linksList = driver.findElements(By.tagName("a"));
       linksList.add(driver.findElement(By.tagName("img")));
       List<WebElement>activeLinks = new ArrayList<WebElement>();
       System.out.println("Sixe of the full linked list---->"+linksList.size());

       //2 iterate link list : exclude all links and images which doesn't have any href attribute
        for(int i =0 ; i<linksList.size();i++){
            System.out.println(linksList.get(i).getAttribute("href"));
            if(linksList.get(i).getAttribute("href")!=null &&! linksList.get(i).getAttribute("href").contains("javascript")){
                activeLinks.add(linksList.get(i));
            }
        }


        System.out.println("Size of the active links ---->"+activeLinks.size());

        // check the href url with http api connection

        for(int j= 0; j<activeLinks.size(); j++){
            HttpsURLConnection connection =   ( HttpsURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
           int Responce =connection.getResponseCode();
                   //getConnectTimeout();
                  // .getResponseMessage();

           // int Responce =connection.getResponseCode();
                    //.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href")  +"  ---->  "+Responce);

        }
    }

}