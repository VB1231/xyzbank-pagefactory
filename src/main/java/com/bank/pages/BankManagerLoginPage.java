package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {
     @CacheLookup
     @FindBy(xpath = "//div/button[2][@ng-click='openAccount()']")
    WebElement openAccount;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-lg tab'and @ng-click='addCust()']")
    WebElement addCustomer;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-click ='showCust()']")
    WebElement clickCustomerTab;
    public void clickOnOpenAccount(){
        Reporter.log("click on Open Account"+openAccount.toString() );
        clickOnElement(openAccount);
    }
     public void clickOnAddCustomer(){
        Reporter.log("Click on Add Customer"+addCustomer.toString());
        clickOnElement(addCustomer);
    }
      public void clickOnCostumerTab(){
        Reporter.log("Click on Customer Tab"+clickCustomerTab.toString());
        mouseHoverToElementAndClick(clickCustomerTab);
    }
    //popup display
     //	click on "ok" button on popup.
    public String popUPTextVerify(){
        Reporter.log("get text from Alert");
        return getTextFromAlert();
    }
    public void closePopUp(){
        Reporter.log("close pop up");
        acceptAlert();
    }

}
