package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class BankTest extends BaseTest {
    BankManagerLoginPage bankManagerLoginPage ;
    HomePage homePage;
    CustomerLoginPage customerLoginPage ;
    OpenAccountPage openAccountPage ;
    CustomerPage customerPage ;
    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        bankManagerLoginPage = new BankManagerLoginPage();
        homePage = new HomePage();
        customerLoginPage = new CustomerLoginPage();
        openAccountPage = new OpenAccountPage();
        customerPage = new CustomerPage();
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();

    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully()throws NullPointerException,InterruptedException {
        homePage.clickOnBankManagerButton();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.enterAddFirstName("Viral");
        addCustomerPage.enterAddLastName("Testing");
        addCustomerPage.enterPostCode("WD23 7AB");
        addCustomerPage.clickAfterAddingDetail();
        Thread.sleep(5000);
        Assert.assertEquals(bankManagerLoginPage.popUPTextVerify(), "Customer added successfully with customer id :6", "Not verify");
        bankManagerLoginPage.closePopUp();
        homePage.clickOnHomePage();
    }

    @Test(groups={"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException, StaleElementReferenceException {
        bankManagerShouldAddCustomerSuccessfully();
        homePage.clickOnBankManagerButton();
        bankManagerLoginPage.clickOnOpenAccount();
        Thread.sleep(2000);
        openAccountPage.searchCustomer("Viral Testing");
        openAccountPage.selectCurrency("Pound");
        openAccountPage.setClickOnProcess();
        Assert.assertEquals(openAccountPage.popUpText(), "Account created successfully with account Number :1016", "Not verify");
        openAccountPage.clickOnPopUp();
    }

    @Test(groups={"smoke","regression"})
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnCustomerLoginPage();
        customerLoginPage.searchCustomerOnCustomerLoginPage("Harry Potter");
        customerLoginPage.clickOnCustomerLoginOnCustomerLoginPage();
        Thread.sleep(400);
        Assert.assertEquals(customerPage.verifyLogoutText(), "Logout", "Not verify");
        customerPage.clickOnLogOut();
        Assert.assertEquals(customerPage.verifyYourNameText(), "Your Name :", "Not verify");
    }

    @Test(groups ="regression")
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        homePage.clickOnCustomerLoginPage();
        customerLoginPage.searchCustomerOnCustomerLoginPage("Harry Potter");
        customerLoginPage.clickOnCustomerLoginOnCustomerLoginPage();
        Thread.sleep(400);
        accountPage.clickOnDeposit();
        accountPage.enterDebitAmount("1000");
        accountPage.clickDepositButton();
        Assert.assertEquals(accountPage.verifyTextDepositSuccessfully(), "Deposit Successful", "Not verify");
    }

    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {

        homePage.clickOnCustomerLoginPage();
        customerLoginPage.searchCustomerOnCustomerLoginPage("Hermoine Granger");
        customerLoginPage.clickOnCustomerLoginOnCustomerLoginPage();
        Thread.sleep(400);
        accountPage.clickWithdraw();
        accountPage.setWithdrawAmount("50");
        accountPage.clickOnWithdrawButton();
        Assert.assertEquals(accountPage.verifyTextTransaction(), "Transaction successful", "Not verify");
    }

}
