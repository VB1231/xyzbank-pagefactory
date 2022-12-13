package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement customerSearch;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement clickOnCustomerLoginOnCustomerLoginPage;

    public void searchCustomerOnCustomerLoginPage(String s) {
        Reporter.log("search customer"+customerSearch.toString());
        selectByVisibleTextFromDropDown(customerSearch, s);
    }

    public void clickOnCustomerLoginOnCustomerLoginPage() {
        Reporter.log("click on customer Login Customer Login Page"+clickOnCustomerLoginOnCustomerLoginPage.toString());
        clickOnElement(clickOnCustomerLoginOnCustomerLoginPage);
    }


}
