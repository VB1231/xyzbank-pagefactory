package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManagerLoginButton;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homePageLink;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement  customerLogin;

    public void clickOnBankManagerButton()throws StaleElementReferenceException {

        Reporter.log("mouse hover and click on bank manager login button"+bankManagerLoginButton.toString());
        mouseHoverToElementAndClick(bankManagerLoginButton);

    }
    public void clickOnHomePage() {
        Reporter.log("click on home page "+homePageLink.toString());
        clickOnElement(homePageLink);
    }

     public void clickOnCustomerLoginPage() {
        Reporter.log("mouse hover and click on login"+customerLogin.toString());
        mouseHoverToElementAndClick(customerLogin);
    }

}
