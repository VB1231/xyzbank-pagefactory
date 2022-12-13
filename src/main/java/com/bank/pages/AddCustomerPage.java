package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
     @CacheLookup
    @FindBy(xpath = "//form/div[1]/input")
    WebElement enterFirstName;
    @CacheLookup
    @FindBy(xpath = "//form/div[2]/input")
    WebElement enterLastName;
    @CacheLookup
    @FindBy(xpath = "//form/div[3]/input")
    WebElement enterPostCode;
    @CacheLookup
    @FindBy(xpath = "//form/button")
    WebElement clickOnAddCustomer;
    public void enterAddFirstName(String firstName1){
        Reporter.log("enter firstName"+firstName1.toString());
        sendTextToElement(enterFirstName,firstName1);
    }
   public void enterAddLastName(String lastName1){
        Reporter.log("enter AddLastName"+lastName1.toString());
        sendTextToElement(enterLastName,lastName1);
    }
    public void enterPostCode(String postCode1){
        Reporter.log("enter postcode"+postCode1.toString());
        sendTextToElement(enterPostCode,postCode1);

    }
    public void clickAfterAddingDetail(){
        Reporter.log("click on Add Customer"+clickOnAddCustomer.toString());
         clickOnElement(clickOnAddCustomer);
    }

}
