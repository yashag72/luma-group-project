package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }
    @FindBy (id = "email")
    protected WebElement emailField;
    @FindBy(id = "pass")
    protected WebElement passwordField;
    @FindBy(id = "send2")
    protected WebElement signInBtn;
    @FindBy(xpath = "//h1[@class='page-title']")
    protected WebElement custLoginHeader;
    @FindBy(xpath = "(//span[text()='Forgot Your Password?'])[1]")
    protected WebElement forgotPassword;

    @FindBy(xpath = "//div[@role='alert']")
    protected WebElement incorrectSignInMsg;
    @FindBy(xpath = "(//span[starts-with(text(),'Welcome')])[1]")
    protected WebElement welcomeUsrNameMsg;
    @FindBy(id = "email-error")
    protected WebElement emailErrorMsg;
    @FindBy(id = "pass-error")
    protected WebElement passErrorMsg;

    public void verifyCustLoginHeader(){
        softAssert.assertTrue(custLoginHeader.isDisplayed());
    }
    public void enterCustInfo(Map<String, String> data){
        emailField.sendKeys(data.get("Email"));
        passwordField.sendKeys(data.get("Password"));
        softAssert.assertTrue(signInBtn.isEnabled());
        softAssert.assertTrue(forgotPassword.isDisplayed());
        signInBtn.click();
    }
    public void enterCustInfoNeg(Map<String,String>data) throws InterruptedException {
        emailField.sendKeys(data.get("Email"));
        passwordField.sendKeys(data.get("IncPass"));
        signInBtn.click();
        softAssert.assertTrue(incorrectSignInMsg.isDisplayed());
        emailField.clear();
        passwordField.clear();
        emailField.sendKeys(data.get("IncEmail"));
        passwordField.sendKeys(data.get("IncPass"));
        signInBtn.click();
        softAssert.assertTrue(emailErrorMsg.isDisplayed());
        emailField.clear();
        passwordField.clear();
        signInBtn.click();
        softAssert.assertTrue(emailErrorMsg.isDisplayed());
        softAssert.assertTrue(passErrorMsg.isDisplayed());
    }
    public void verifyWelcomeUsrMsg(){
        softAssert.assertTrue(welcomeUsrNameMsg.isDisplayed());
    }




}
