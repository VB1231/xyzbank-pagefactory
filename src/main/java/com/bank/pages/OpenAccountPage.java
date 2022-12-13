package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//form/div[1]/select[1]")
    WebElement customerName;
    @CacheLookup
    @FindBy(id = "currency")
    WebElement selectCurrency;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement clickOnProcess;

    public void searchCustomer(String name) {
        Reporter.log("enter customer name "+customerName.toString());
               selectByVisibleTextFromDropDown(customerName,name);
    }
    public void selectCurrency(String p) {
      Reporter.log("select currency"+selectCurrency.toString());
        selectByVisibleTextFromDropDown(selectCurrency,p);
    }
    public void setClickOnProcess() {
        Reporter.log("mouse hover and click on process"+clickOnProcess.toString());
        mouseHoverToElementAndClick(clickOnProcess);
    }

    public String popUpText() {
        Reporter.log("get text fro alert");
        return getTextFromAlert();
    }

    public void clickOnPopUp() {
        Reporter.log("click on pop up");
        acceptAlert();
    }

}
