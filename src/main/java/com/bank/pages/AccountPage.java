package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {
    //click on Deposit
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[2]")
    WebElement deposit;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement enterAmount;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement clickDepositButton;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement verifyTextDeposit;
    @CacheLookup
    @FindBy(xpath = "//div[@class='center']/button[3]")
    WebElement withdraw;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement setWithdrawAmount;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement clickWithdrawButton;
    @CacheLookup
    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement verifyTextTransaction;

    public void clickOnDeposit() {
        Reporter.log("clicking on deposit link"+deposit.toString());
        clickOnElement(deposit);
    }

    public void enterDebitAmount(String debitAmount) {
        Reporter.log("enter deposit amount"+enterAmount.toString());
        sendTextToElement(enterAmount, debitAmount);
    }

    public void clickDepositButton() {
        Reporter.log("clicking on deposit button"+clickDepositButton.toString());
        clickOnElement(clickDepositButton);
    }

    public String verifyTextDepositSuccessfully() {
        Reporter.log("get verify deposit success message"+verifyTextDeposit.toString());
        return getTextFromElement(verifyTextDeposit);
    }

    public void clickWithdraw() {
        Reporter.log("clicking on withdraw "+withdraw.toString());
        mouseHoverToElementAndClick(withdraw);
    }

    public void setWithdrawAmount(String a) {

        Reporter.log("Set withdraw Amount"+setWithdrawAmount.toString());
        sendTextToElement(setWithdrawAmount, a);
    }

    public void clickOnWithdrawButton() {
        Reporter.log("Click on Withdraw Button"+clickWithdrawButton.toString());
        clickOnElement(clickWithdrawButton);
    }

    public String verifyTextTransaction() {
        Reporter.log("get Text from Transaction"+verifyTextTransaction.toString());
        return getTextFromElement(verifyTextTransaction);
    }

}
