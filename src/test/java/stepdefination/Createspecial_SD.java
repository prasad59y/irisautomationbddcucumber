package stepdefination;

import com.UtilTestBaseFramework.Utils;
import com.pages.CreateSpecialorder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Createspecial_SD {
    private CreateSpecialorder createSpecialOrder;

    public Createspecial_SD(){
        this.createSpecialOrder = new CreateSpecialorder();
    }
    
        @Then("Attach the Quote here and add to basket")
        public void attachTheQuoteHereAndAddToBasket() throws Exception {
            //WebElement uploadElement = driver.findElement(By.id("uploadfile"));
          WebElement uploadFile =  Utils.uploadFile(By.xpath("//input[@id=\"MainContent_fluAttachment\"]"));
            uploadFile.sendKeys("C:\\Users\\yarlagaddap\\Desktop\\test.jpg");
            Utils.BrowserTest.sleep(2000);
            Utils.clickFunction(By.xpath("//a[@id=\"MainContent_AddToBasket\"]"));

        }

    @And("click on Create Special Order")
    public void clickOnCreateSpecialOrder() {
        try {
            Utils.clickFunction(By.xpath("//a[contains(text(),'Create Special Order')]"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("Enter all required mandatory details")
    public void enterAllRequiredMandatoryDetails(DataTable enterSpecialDetails) throws Exception {
        createSpecialOrder.enterspecialOrderDetails(enterSpecialDetails);
    }


    @Then("validate the show standard view and filter by authoriser options")
    public void validateTheShowStandardViewAndFilterByAuthoriserOptions() throws Exception {
      //  Utils.clickFunction(By.xpath("//a[contains(text(),'Show Standard View')]"));
        Utils.isElementExist(By.xpath("//a[contains(text(),'Show Standard View')]"));
    }
}

