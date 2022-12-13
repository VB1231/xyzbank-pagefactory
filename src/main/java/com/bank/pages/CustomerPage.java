package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement clickOnLogin;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement logOutText;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement verifyYourName;

    public void clickOnLogin() {
        Reporter.log("click on Login"+clickOnLogin.toString());
        clickOnElement(clickOnLogin);
    }

    public String verifyLogoutText() {
        Reporter.log("get text from log out "+logOutText.toString());
        return getTextFromElement(logOutText);
    }

    public void clickOnLogOut() {
        Reporter.log("mouse hover and click on log out text"+logOutText.toString());
        mouseHoverToElementAndClick(logOutText);
    }

    public String verifyYourNameText() {
        Reporter.log("get text from verify your name" +verifyYourName.toString());
        return getTextFromElement(verifyYourName);
    }

}
