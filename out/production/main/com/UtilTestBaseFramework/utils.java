package com.UtilTestBaseFramework;


import com.google.common.base.Function;
import com.qa.factory.DriverFactory;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.NoSuchElementException;
import java.util.*;


public class utils extends DriverFactory {
	public static WebDriver driver;
	public static Properties prop;
	public static Thread BrowserTest = null;



    public static void highlightElement(By elmt) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(elmt));
        // BrowserTest.sleep(1000);
        js.executeScript("arguments[0].style.border=''", driver.findElement(elmt));
        // BrowserTest.sleep(1000);
    }

    public static int randomNumber() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(23000 - 10000 + 1);
    }

    /********************** To generate Random Country Code********************/
    public static String getRandomCountryCode() {
        String names[] = {"AT", "BE", "BG", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FR", "GB", "HR", "HU", "IE", "IT", "LT",
                "LU", "LV", "MT", "NL", "PL", "PT", "RO", "SE", "SI", "SK"};
        Random randomNameGenerator = new Random();
        return names[randomNameGenerator.nextInt(names.length)];
    }

    /********************** To generate Current Date(Disclosure ID)********************/
    public static String getDateForDisclosureID() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");//("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();   //20140806
        return dateFormat.format(date);
    }

    /********************** To generate Random Text(Disclosure ID)********************/
    private static final String STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String getRandomAlphanumericText(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * STRING.length());
            builder.append(STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String getValidDisclosureID() {
        String validDisclosureID=getRandomCountryCode()+"D"+getDateForDisclosureID()+getRandomAlphanumericText(6);
        return validDisclosureID;
    }

    public static String getValidArrangementID() {
        String validArrangementID=getRandomCountryCode()+"A"+getDateForDisclosureID()+getRandomAlphanumericText(6);
        return validArrangementID;
    }

    public static String getTextJavaScript(By elmt) {
        return ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", driver.findElement(elmt)).toString();
    }

    public static String getTitle() {
        return driver.getTitle();
    }

    public static void navigateURL() {
        System.out.println("before getting navigateURL");
        driver.get(prop.getProperty("url"));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
//**************** Send Keys (Entering text into text boxes or text area********************************************

    public static boolean enterText(WebElement textArea, String textAreaValue) {
        try {
            utils.waitForLoad();
            utils.waitForAjax();
            textArea.sendKeys(textAreaValue.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean clearText(By xPath) {
        try {
            utils.waitForLoad();
            utils.waitForAjax();
            driver.findElement(xPath).clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean enterText(By textArea, String textAreaValue) {
        try {
            utils.waitForLoad();
            utils.waitForAjax();
            driver.findElement(textArea).sendKeys(textAreaValue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean clearTextArea(WebElement textArea)  {
        try {
            utils.findElement(driver, textArea, 30);
            textArea.clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean clearTextArea(By textArea){
        try {
            utils.findElement(driver, driver.findElement(textArea), 30);
            driver.findElement(textArea).clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //*************** Dropdowns generic methods****************************************.

    public static boolean selectValueForDropdown(By dropDownList, String strDrpValue) {
        try {

            utils.waitForLoad();
            Select select = new Select(driver.findElement(dropDownList));
            select.selectByVisibleText(strDrpValue.trim());
            return true;
        } catch (Exception e) {
            try {
                utils.waitForLoad();
                Select select = new Select(driver.findElement(dropDownList));
                select.selectByVisibleText(strDrpValue.trim());
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    // select DropDown with WebElement
    public static boolean selectValueForDropdown(WebElement dropDown, String strDrpValue) {
        try {
            // Ag and Turf Assessments

            utils.waitForLoad();
            Select select = new Select(dropDown);
            select.selectByVisibleText(strDrpValue.trim());
            return true;
        } catch (Exception e) {
            try {
                utils.waitForLoad();
                Select select = new Select(dropDown);
                select.selectByVisibleText(strDrpValue.trim());
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    public static boolean selectIndexValueForDropdown(By dropDownList, int indexOfDropdown) {
        try {
            utils.waitForLoad();
            Select select = new Select(driver.findElement(dropDownList));
            select.selectByIndex(indexOfDropdown);
            return true;
        } catch (Exception e) {
            try {
                utils.waitForLoad();
                Select select = new Select(driver.findElement(dropDownList));
                select.selectByIndex(indexOfDropdown);
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    public static boolean selectDropDownByOptionIndex(By xpath, int optionIndex) {
        try {
            Select select = new Select(driver.findElement(xpath));
            select.selectByIndex(optionIndex);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }


    public static boolean selectDropdownByVisibleText(WebElement dropDownList, String strDrpValue) {
        try {
            utils.waitForLoad();
            utils.waitForAjax();
//            utils.waitForAnObject_TillUiIsBlocked();
            Select select = new Select(dropDownList);
            select.selectByVisibleText(strDrpValue.trim());
            utils.waitForJQuery();
            utils.waitForLoad();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean selectDropdownByVisibleText1(WebElement dropDownList, List<String> strDrpValue) {
        try {
            utils.waitForLoad();
            utils.waitForAjax();
            utils.waitForAnObject_TillUiIsBlocked();
            Select select = new Select(dropDownList);

            select.selectByVisibleText(String.valueOf(strDrpValue));
            utils.waitForJQuery();
            utils.waitForLoad();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean IsValueSelectedInDropdown(By xpath, String string)  {
        Select select = new Select(driver.findElement(xpath));
        return select.getFirstSelectedOption().getText().trim().equals(string);
    }

    public static String getSelectedOption(By xpath)  {
        Select select = new Select(driver.findElement(xpath));
        return select.getFirstSelectedOption().getText().trim();
    }

    public static boolean deSelectValueIndropDownByIndex(By xpath, int optionIndex) {
        try {
            Select select = new Select(driver.findElement(xpath));
            select.deselectByIndex(optionIndex);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public static boolean deSelectValueIndropDownByValue(By xpath, String optionValue) {
        try {
            Select select = new Select(driver.findElement(xpath));
            select.deselectByValue(optionValue);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    //**************************** Radio button generic methods*********************************

    public static boolean selectRadioButton(By radioButton) {
        try {
            driver.findElement(radioButton).click();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }


    public static boolean clickRadioButton(WebElement radioButton)
            throws WebDriverException, Exception {
        return clickFunctionByJavaScript(radioButton);
    }

    //**************************** Submit Button generic methods*********************************

    public static boolean buttonClick(WebElement buttonCreateNew)
            throws WebDriverException, Exception {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", buttonCreateNew);
            return true;
        } catch (Throwable e) {
            try {
                buttonCreateNew.click();
                return true;
            } catch (Throwable e1) {
                return false;
            }
        }
    }

//***************** Click Functions***********************************************************************************

    public static boolean clickFunctionByJavaScript(WebElement webElement) throws WebDriverException, Exception {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", webElement);
            return true;
        } catch (Throwable e) {
            try {
                webElement.click();
                return true;
            } catch (Throwable e1) {
                return false;
            }
        }
    }


    public static boolean clickFunctionByJavaScript(By by) throws WebDriverException, Exception {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(by));
            return true;
        } catch (Throwable e) {
            try {
                driver.findElement(by).click();
                return true;
            } catch (Throwable e1) {
                return false;
            }
        }
    }

    public static boolean clickFunction(WebElement webElement) throws WebDriverException, Exception {
        try {
            webElement.click();
            return true;
        } catch (Exception e) {
            try {
                webElement.click();
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    public static boolean clickFunction(By by) throws WebDriverException, Exception {
        try {
            driver.findElement(by).click();
            return true;
        } catch (Exception e) {
            try {
                driver.findElement(by).click();
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    //****************** Scroll to the co-ordinates ******************************************************************//

    public static boolean scrollUpDownLeftRight(int horizontal, int vertical) throws WebDriverException, Exception {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("scroll(horizontal,vertical)");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*********************** Get Attribute Values *************************************************************************/
    public static boolean getAttributeValue(WebElement readOnlyField, String attributeValue) {
        String isReadOnlyField = readOnlyField.getAttribute(attributeValue);
        return Boolean.parseBoolean(isReadOnlyField);
    }

    public static boolean getAttributeValue(By xpath, String attributeValue) {
        String isReadOnlyField = driver.findElement(xpath).getAttribute(attributeValue);
        return Boolean.parseBoolean(isReadOnlyField);
    }

    public static String getAttributeValueAsString(By xpath, String attributeValue) {
        String attributeVal = driver.findElement(xpath).getAttribute(attributeValue);
        return attributeVal;
    }

    public static String getElementInnerText(WebElement elem, String description) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) (driver);
            String text = (String) js.executeScript("return arguments[0].innerHTML.toString();", elem);
            return text;
        } catch (Exception e) {
            return "";

        }
    }

    public static String getElementValue(WebElement elem, String description) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) (driver);
            String text = (String) js.executeScript("return arguments[0].value.toString();", elem);
            return text;
        } catch (Exception e) {
            return "";

        }
    }

    public static String convertXpath(WebElement element) {
        String xpath = element.toString().substring(element.toString().indexOf("//"));
        return xpath.substring(0, xpath.lastIndexOf("]")).trim();
    }

    public static String getText(WebElement webelement) {
        utils.waitForAnObject(webelement, 5);
        return webelement.getText().trim();
    }

    /*********************** All Alerts *************************************************************************/

    public static boolean waitForAlert(Integer time) {
        WebDriverWait wait;
        try {
            wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Throwable e) {
            return false;
        }
    }

    public static boolean switchToAlert() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Throwable e1) {
            return false;
        }
    }

    public static boolean acceptAlert() {
        try {
            driver.switchTo().alert().accept();
            return true;
        } catch (Throwable e1) {
            return false;
        }
    }

    public static boolean dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
            return true;
        } catch (Throwable e) {
            try {
                driver.switchTo().alert().dismiss();
                return true;
            } catch (Throwable e1) {
                return false;
            }
        }
    }

    public static String getAlertText() {
        try {
            return driver.switchTo().alert().getText();
        } catch (Throwable e) {
            try {
                return driver.switchTo().alert().getText();
            } catch (Throwable e1) {
                return "";
            }
        }
    }

    /*********************** Frames In Pega *************************************************************************/

    // Switch frame
    public static boolean switchToFrame(WebElement frameID) {
        try {
            driver.switchTo().frame(frameID);
            return true;
        } catch (Throwable th1) {
            try {
                driver.switchTo().frame(frameID);
                return true;
            } catch (Throwable th2) {
                return false;
            }
        }
    }

    // Switch frame
    public static boolean switchToFrame(By frameID) {
        try {
            driver.switchTo().frame(driver.findElement(frameID));
            return true;
        } catch (Throwable th1) {
            try {
                driver.switchTo().frame(driver.findElement(frameID));
                return true;
            } catch (Throwable th2) {
                return false;
            }
        }
    }

    public static boolean switchToDefaultFrame() {
        try {
            driver.switchTo().defaultContent();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Find frame for a particular element
    public static void switchToFrame(List<WebElement> frames, By elementXPath) {
        try {
//			System.out.println("Total frames sixe on page= "+frames.size());
            for (int i = 0; i < frames.size(); i++) {
                utils.switchToFrame(frames.get(i));
                if (utils.waitForAnObject(elementXPath, 1)) {
                    break;
                } else {
                    utils.switchToDefaultFrame();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*********************** Mouse Events In Pega *************************************************************************/

    public static boolean moveToElement(WebElement element) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(element).build().perform();
            // action.perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean moveToElement(By linkSubmitForApprovalProgramAction) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(linkSubmitForApprovalProgramAction)).build().perform();
            return true;
        } catch (Exception e) {
            try {
                Actions action = new Actions(driver);
                action.moveToElement(driver.findElement(linkSubmitForApprovalProgramAction)).build().perform();
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    public static boolean doubleClick(By linkSubmitForApprovalProgramAction) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(linkSubmitForApprovalProgramAction)).build().perform();
            return true;
        } catch (Exception e) {
            try {
                Actions action = new Actions(driver);
                action.doubleClick().build().perform();
                action.moveToElement(driver.findElement(linkSubmitForApprovalProgramAction)).build().perform();
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    /*********************** Common Elements Actions*************************************************************************/


    public static boolean isElementExist(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementExist(WebElement element) {
        try {
            driver.findElement(By.xpath(convertXpath(element)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementEnabled(By by) {
        try {
            return driver.findElement(by).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementEnabled(WebElement webElement) {
        try {
            boolean isEnabled = webElement.isEnabled();
            // getAttributeValue(webElement,"disabled");
            return isEnabled;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean isSelected(WebElement webElement) {
        try {
            return webElement.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isSelected(By xpath) {
        try {
            return driver.findElement(xpath).isSelected();
        } catch (Exception e) {
            return false;
        }
    }

//    public static boolean assertCheck(boolean input1, boolean input2, String message) {
//        Assert.assertEquals(input1, input2, message);
//        return input1;
//    }

    /*********************** Click on Checkbox In Pega *************************************************************************/

    public static boolean clickOnCheckbox(By by) throws WebDriverException, Exception {
        try {
            driver.findElement(by).click();
            return true;
        } catch (Exception e) {
            try {
                clickFunctionByJavaScript(by);
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    public static boolean clickOnDeleteCrossIcon(By by) throws WebDriverException, Exception {
        try {
            driver.findElement(by).click();
            return true;
        } catch (Exception e) {
            try {
                clickFunctionByJavaScript(by);
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    public static boolean selectFutureBFDate(WebElement calendarStartDate, int currentDate)
            throws WebDriverException, Exception {
         String selectedStartDate = null;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", calendarStartDate);
            utils.waitForLoad();
            System.out.println(utils.getLastDayOfMonth());
            System.out.println(currentDate);
            if (currentDate == utils.getLastDayOfMonth()) {
                selectedStartDate = utils.getFirstDayOfNextMonth();
                utils.waitForAnObject(By.xpath("//*[@id='monthSpinner']//button[@class='spin-button spin-up']"), 10);
                clickFunction(driver.findElement(By.xpath("//*[@id='monthSpinner']//button[@class='spin-button spin-up']")));
                utils.waitForAnObject(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"), 5000);
                BrowserTest.sleep(500);
                utils.clickFunction(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"));
                BrowserTest.sleep(500);
            } else {
                selectedStartDate = Integer.toString(currentDate + 1);
                utils.waitForAnObject(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"), 5000);
                clickFunction(driver.findElement(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']")));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean isCheckBoxEnabled(WebElement checkboxelement) {
        try {
            checkboxelement.isEnabled();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isCheckBoxDisplayed(WebElement checkboxelement) {
        try {
            checkboxelement.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isCheckBoxSelected(WebElement checkboxelement) {
        try {
            checkboxelement.isSelected();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean clickOnCrossImg(WebElement checkboxelement) {
        try {
            checkboxelement.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /*********************** Drag and Drop In Pega *************************************************************************/


    // FUNCTION TO DRAG AND DROP
    public static boolean dragAndDrop(By Src, By Dest) {
        try {
            Actions a = new Actions(driver);
            // Actions act=new Actions(driver);
            // act.d
            /*
             * a.moveToElement(driver.findElement(Src));
             * a.dragAndDrop(driver.findElement(Src),
             * driver.findElement(Dest)).perform(); <<<<<<< .mine
             * .moveToElement(driver.findElement(Src))
             * .release(driver.findElement(Dest)).perform();
             */
            Action dragAndDrop = a.clickAndHold(driver.findElement(Src)).moveToElement(driver.findElement(Dest))
                    .release(driver.findElement(Dest)).build();
            dragAndDrop.perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    //

    public static boolean enterMinimumRequired(By textArea, String minimumRequired)
            throws WebDriverException, Exception {
        try {
            driver.findElement(textArea).sendKeys(minimumRequired);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean enterMinimumRecommended(By textArea, String minimumRecommended)
            throws WebDriverException, Exception {
        try {
            driver.findElement(textArea).sendKeys(minimumRecommended);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static boolean selectStartDate(WebElement calendarStartDate, int currentDate, int sheetStartDate)
            throws WebDriverException, Exception {
         String selectedStartDate = null;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", calendarStartDate);
            utils.waitForLoad();
            if (currentDate == utils.getLastDayOfMonth()) {
                selectedStartDate = utils.getFirstDayOfNextMonth();
                utils.waitForAnObject(By.xpath("//*[@id='monthSpinner']//button[@class='spin-button spin-up']"), 10);
                clickFunction(
                        driver.findElement(By.xpath("//*[@id='monthSpinner']//button[@class='spin-button spin-up']")));
                utils.waitForAnObject(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"),
                        5);
                // clickFunction(driver.findElement(By.xpath("//*[@id='controlCalBody']//a[text()='"+selectedStartDate+"']")));
                utils.clickFunctionByJavaScript(
                        By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"));
            } else {
                selectedStartDate = Integer.toString(currentDate + 1);
                utils.waitForAnObject(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"),
                        5);
                clickFunction(driver
                        .findElement(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']")));
           }
            String startDate = selectedStartDate;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean selectPastBFDate(WebElement datePicker, int currentDate)
            throws WebDriverException, Exception {
         String selectedStartDate = null;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", datePicker);
            utils.waitForLoad();
            if (currentDate == utils.getLastDayOfMonth()) {
                selectedStartDate = utils.getFirstDayOfNextMonth();
                BrowserTest.sleep(3000);
                utils.waitForAnObject(By.xpath("//*[@id='monthSpinner']//button[@class='spin-button spin-down']"), 10);
                utils.clickFunctionByJavaScript(By.xpath("//*[@id='monthSpinner']//button[@class='spin-button spin-down']"));
                utils.waitForAnObject(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"), 5);
                BrowserTest.sleep(500);
                utils.clickFunction(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"));
                BrowserTest.sleep(500);
            } else {
                selectedStartDate = Integer.toString(currentDate - 1);
                utils.waitForAnObject(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"), 5);
                clickFunction(driver.findElement(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']")));
            }
            // startDate = selectedStartDate;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean selectTodaysBFDate(WebElement datepicker, int currentDate)
            throws WebDriverException, Exception {
        int selectedStartDate;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", datepicker);
            utils.waitForLoad();
            if (currentDate == utils.getLastDayOfMonth()) {
                selectedStartDate = utils.getLastDayOfMonth();
                utils.waitForAnObject(By.xpath("//*[@id='monthSpinner']//button[@class='spin-button spin-up']"), 10);
                clickFunction(driver.findElement(By.xpath("//*[@id='monthSpinner']//button[@class='spin-button spin-up']")));
                utils.waitForAnObject(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"),
                        5);
                // clickFunction(driver.findElement(By.xpath("//*[@id='controlCalBody']//a[text()='"+selectedStartDate+"']")));
                utils.clickFunction(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"));
            } else {
                selectedStartDate = utils.convertStringToInt(getCurrentDate());
                utils.waitForAnObject(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']"), 5);
                clickFunction(driver.findElement(By.xpath("//*[@id='controlCalBody']//a[text()='" + selectedStartDate + "']")));
            }
            // startDate = selectedStartDate;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean scrollIntoViewElement(WebElement ScrollToElement) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", ScrollToElement);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean scrollIntoViewElement(By ScrollToElement) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(ScrollToElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitForAnObjectToBeClickable(WebDriver driver, By loadingImg, By element, Integer time)
            throws InterruptedException {
        utils.waitForAnObjectToBenVisible(loadingImg, time);
        utils.waitForLoad();
        utils.waitForAnObject(element, time);
        utils.waitForAnObjectToBeAvailable(element, time);
    }

//    public static void catchException(Throwable e1) {
//        fail = true;
//        e1.printStackTrace();
//        if (!e1.toString().contains("AssertionError")) {
//            userDefinedError = "Due to more reponse time, page or object may not be visible/loaded within timeout";
//            techError = e1.toString().substring(0, e1.toString().indexOf("(WARNING")).trim();
//        } else {
//            functionalError = e1.toString().substring(e1.toString().indexOf(":") + 1);
//            functionalError = functionalError.toString().substring(0, functionalError.toString().indexOf("expected"));
//        }
//        // adding below line to capture failed test cases in TestNG suite report
//        Assert.fail();
//    }

    public static String getText(By by) {
        try {
            utils.waitForAnObject(by, 10);
//			System.out.println("Returned text is " +driver.findElement(by).getText().trim());
            return driver.findElement(by).getText().trim();
        } catch (Exception e) {
            try {
                utils.waitForAnObject(by, 10);
                return driver.findElement(by).getText().trim();
            } catch (Exception e1) {
                return "0";
            }
        }
    }

    public static List<WebElement> getWebElements(By xpath) throws InterruptedException {
        return driver.findElements(xpath);
    }


    // Fluent Wait
    public static WebElement fluentWait(By xpath) {
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
        fluentWait.pollingEvery(Duration.ofMillis(3000));
        fluentWait.withTimeout(Duration.ofMillis(9000));
        fluentWait.ignoring(WebDriverException.class);
        fluentWait.ignoring(NoSuchElementException.class);

        WebElement msg = fluentWait.until(driver -> {
            System.out.println("in wait of fluent wait");
            return driver.findElement(xpath);
        });
        return msg;
    }

    // Fluent Wait
    public static WebElement selectByFluent(By locator, String string) {
        final Select droplist = new Select(driver.findElement(locator));
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofMillis(3000))
                .withTimeout(Duration.ofMillis(9000))
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class);

        WebElement msg = fluentWait.until(new java.util.function.Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return (WebElement) (droplist.getOptions());
                // return driver.findElement(locator);
            }
        });
        droplist.selectByVisibleText(string);
        return msg;
    }


    public static String getReportConfigPath() {
        String reportConfigPath = prop.getProperty("reportConfigPath");
        if (reportConfigPath != null) return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    //taking current system time
    public static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMdd_HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static int getRandomNumber() {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMdd_HH:mm:ss");
//		Date date = new Date();
//		return simpleDateFormat.format(date);
        Random random = new Random(System.nanoTime());

        int randomInt = random.nextInt(10000);

        return randomInt;
    }

    //taking current system date
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd");//("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();   //2014/08/06
        return dateFormat.format(date);
    }

    //taking system date for reports generation
    public static String getCurrentDateReports() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");//("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();   //2014/08/06
        return dateFormat.format(date);
    }

    public static String getCurrentDay2() {
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        LocalDate localDate = LocalDate.now();
        int todayDay = localDate.getDayOfMonth();
        System.out.println("Aaj ki Tariqh: " + todayDay + "\n");

        LocalDate lastdaofthemonthy = localDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate firstDayOfNextMonth = localDate.with(TemporalAdjusters.firstDayOfNextMonth());
        LocalDate firstDayOfNextYear = localDate.with(TemporalAdjusters.firstDayOfNextYear());
        LocalDate previousDayOfWeek = localDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));

        System.out.println("Aaj ki Tariqh: " + todayDay + "\n");
        System.out.println("lastdaofthemonthy ki Tariqh: " + lastdaofthemonthy.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "\n");
        System.out.println("firstDayOfNextMonth  ki Tariqh: " + firstDayOfNextMonth.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "\n");
        System.out.println("firstDayOfNextYear  ki Tariqh: " + firstDayOfNextYear.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "\n");
        System.out.println("previousDayOfWeek  ki Tariqh: " + previousDayOfWeek.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) + "\n");
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH) + 1;
        System.out.println("Today Int: " + todayInt + "\n");

        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        System.out.println("Today Str: " + todayStr + "\n");

        return todayStr;
    }

    public static String getCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        return new SimpleDateFormat("MMM").format(cal.getTime());
    }

    public static int getLastDayOfMonth() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();
        DateFormat sdf = new SimpleDateFormat("dd");
        return Integer.parseInt(sdf.format(lastDayOfMonth));
    }

    public static String getFirstDayOfNextMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        Date nextMonthFirstDay = calendar.getTime();
        return Integer.toString(nextMonthFirstDay.getDay());
    }

    public static int convertStringToInt(String value) {
        return Integer.parseInt(value);
    }

    public static float convertStringToFloat(String value) {
        return Float.parseFloat(value);
    }

    public static BigDecimal convertStringToDouble(String value) {
        double costBasis = Double.valueOf(value).doubleValue();    // Assume the string "12345.123456789088888" as the one read from the txtfield
        BigDecimal d = new BigDecimal(costBasis);
        return d.setScale(2, BigDecimal.ROUND_UP);
    }

    public static boolean waitForLoad() throws InterruptedException {
        try {
            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                }
            };
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(pageLoadCondition);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitForAjax() throws InterruptedException {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            if ((Boolean) executor.executeScript("return window.jQuery != undefined")) {
                while (!(Boolean) executor.executeScript("return jQuery.active == 0")) {
                    BrowserTest.sleep(1000);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitForJQuery() {
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
    }

    public static boolean waitForAnObject(WebElement elmt, Integer time) {
        String test = "";
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            test = elmt.toString().substring(elmt.toString().indexOf("//"));
            test = test.substring(0, test.lastIndexOf("]")).trim();
            wait.until(presenceOfElementLocated(By.xpath(test)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitForAnObject(By elmt, Integer time) {
        try {
//			utils.waitForLoad();
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(presenceOfElementLocated(elmt));
            return true;
        } catch (Exception e) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, time);
                wait.until(presenceOfElementLocated(elmt));
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }


    public static void waitForPageToLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(pageLoadCondition);
    }


    public static Function<WebDriver, WebElement> presenceOfElementLocated(final By locator) {
        return new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        };
    }

    public static boolean waitForAnListObject(List<WebElement> elmt, Integer time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            String test1 = elmt.toString().substring(elmt.toString().indexOf("//"));
            test1 = test1.substring(0, test1.lastIndexOf("]")).trim();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(test1)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitForAnObjectToBenVisible(By element, Integer time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
//			System.out.println("True");
            return true;
        } catch (Exception e) {
//			System.out.println("false");
            return false;
        }
    }

    public static boolean waitForAnObjectToBenVisible(WebElement element, Integer time) {
        String xpathElement = "";
        try {
            xpathElement = element.toString().substring(element.toString().indexOf("//"));
            xpathElement = xpathElement.substring(0, xpathElement.lastIndexOf("]")).trim();
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathElement)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String javaScriptGettext(By elmt) {
        return ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", driver.findElement(elmt)).toString();
    }

    public static void refrshPage() throws InterruptedException {
        driver.navigate().refresh();
    }

    public static boolean waitForAnObjectToBeClickable(WebElement element, Integer time) {
        String xpathElement = "";
        try {
            xpathElement = element.toString().substring(element.toString().indexOf("//"));
            xpathElement = xpathElement.substring(0, xpathElement.lastIndexOf("]")).trim();
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathElement)));
            return true;
        } catch (Exception e) {
            try {
                xpathElement = element.toString().substring(element.toString().indexOf("//"));
                xpathElement = xpathElement.substring(0, xpathElement.lastIndexOf("]")).trim();
                WebDriverWait wait = new WebDriverWait(driver, time);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathElement)));
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    public static boolean waitForAnObjectToBeClickable(By by, Integer time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception e) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, time);
                wait.until(ExpectedConditions.elementToBeClickable(by));
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    public static boolean waitForAnObjectToBeVisible(WebElement element, Integer time) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitForAnObjectToBeVisible(By element, Integer time) throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitForAnObjectToBeAvailable(By element, Integer time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static void waitForAnObjectToBeClickable(By loadingImg, By element, Integer time) throws InterruptedException {
        waitForAnObjectToBenVisible(loadingImg, time);
        waitForLoad();
        waitForAnObject(element, time);
        waitForAnObjectToBeAvailable(element, time);
    }

    //Atul's Functions
    public static WebElement findElement(final WebDriver driver, final WebElement locator, final int timeoutSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofMillis(3000))
                .withTimeout(Duration.ofMillis(9000))
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class);
        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return locator;
            }
        });
    }

    public static void waitForAnObject_TillUiIsBlocked() throws Exception, WebDriverException {
        while (ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("blockUI")).apply(driver) != null) {
        }
        ;
    }

    public static WebElement findElementTillClickable(final WebElement locator, final int timeoutSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofMillis(timeoutSeconds))
                .withTimeout(Duration.ofMillis(timeoutSeconds))
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class);
        return wait.until((Function<WebDriver, WebElement>) webDriver -> locator);
    }


    public static By findElementTillClickable(final By locator, final int timeoutSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofMillis(timeoutSeconds))
                .withTimeout(Duration.ofMillis(timeoutSeconds))
                .ignoring(WebDriverException.class)
                .ignoring(NoSuchElementException.class);
        return wait.until((Function<WebDriver, By>) webDriver -> locator);
    }

    public static void hit_Escape() throws Exception, WebDriverException {
        new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
    }

    public static void decodeValue(String base64encodedString) throws UnsupportedEncodingException {
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
//		System.out.println("Original String: " + new String(base64decodedBytes, "utf-8"));
    }


    public static boolean waitForAnObject(List<WebElement> dropdownValueList, int time) {
        String test1 = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            test1 = dropdownValueList.toString().substring(dropdownValueList.toString().indexOf("//"));
            test1 = test1.substring(0, test1.lastIndexOf("]")).trim();
            wait.until(presenceOfElementLocated(By.xpath(test1)));
            return true;
        } catch (Exception e) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, time);
                test1 = dropdownValueList.toString().substring(dropdownValueList.toString().indexOf("//"));
                test1 = test1.substring(0, test1.lastIndexOf("]")).trim();
                wait.until(presenceOfElementLocated(By.xpath(test1)));
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    public static void takeScreenshot(String filename, String keyword_execution_result) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotFolder = System.getProperty("user.dir") + "\\Screenshot";
//			System.out.println("screenshot Folder : "+screenshotFolder);
            if (!new File(screenshotFolder).exists()) {
                new File(screenshotFolder).mkdirs();
            }
            FileUtils.copyFile(srcFile, new File(screenshotFolder + "\\" + filename + ".jpg"));
        } catch (IOException ex) {
            ex.getMessage();
        }
    }


    public static void deleteReportingFolder(File folder) {
        try {
            //			System.out.println("Files "+folder.getAbsolutePath());
            FileUtils.deleteDirectory(folder);
            //			System.out.println("after deletion");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFolder(File src, File dest) throws IOException {
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }
            String files[] = src.list();
            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                copyFolder(srcFile, destFile);
            }
        } else {
            InputStream inputStream = new FileInputStream(src);
            OutputStream outputStream = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
//		System.out.println(" Path :: "+dir.getAbsolutePath());
        return dir.delete();
    }


    /***********************To Convert a String into WebElement 
     * @throws InterruptedException *************************************************************************/

    public static WebElement getElement(String findText) throws InterruptedException {
        BrowserTest.sleep(2000);
        WebElement element = driver.findElement(By.xpath(findText));
        return element;
    }
/*
    public static String getCurrentDate(String dateFormat) {
        String modifiedDate = null;
        try {
            Date date = new Date();
            modifiedDate = new SimpleDateFormat(dateFormat).format(date);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return modifiedDate;
    }

 */

    public static Date dateFormat(String dateFormat, String baseDate, int moveCount) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = sdf.parse(baseDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, moveCount);
        Date expectedDay = calendar.getTime();
        return expectedDay;

    }




}
