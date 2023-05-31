package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.security.PublicKey;
import java.util.Map;
import java.util.Objects;

public class ContactUsPage extends BasePage{
    public ContactUsPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }
    @FindBy(xpath = "//h1/span")
    protected WebElement contactUsHdr;
    @FindBy(xpath = "//p[@class='cms-content-important']")
    protected WebElement topMsg;
    @FindBy(xpath = "//span[@class='contact-info-number']")
    protected WebElement phoneNum;
    @FindBy(id = "name")
    protected WebElement nameFld;
    @FindBy(id = "email")
    protected WebElement emailFld;
    @FindBy(id = "telephone")
    protected WebElement phoneFld;
    @FindBy(xpath = "//textarea[@id='comment']")
    protected WebElement commentFld;
    @FindBy(xpath = "//span[text()='Submit']")
    protected WebElement submitBtn;
    @FindBy(xpath = "//div[@role='alert']")
    protected WebElement successToolTip;

    public void verifyContactUsPageTitle(){
        String contactUsPageTitle = driver.getTitle();
        softAssert.assertEquals(contactUsPageTitle, "Contact Us");
    }
    public void verifyOnContactUsPage(Map<String,String> data){
        softAssert.assertTrue(contactUsHdr.isDisplayed());
        softAssert.assertTrue(topMsg.isDisplayed());
        softAssert.assertTrue(phoneNum.isDisplayed());
        System.out.println("Name Field Text: " + nameFld.getAttribute("value"));
        System.out.println("Email Text: " + emailFld.getAttribute("value"));
        softAssert.assertNotNull(nameFld.getAttribute("value"));
        softAssert.assertNotNull(emailFld.getAttribute("value"));
        phoneFld.sendKeys(data.get("Phone"));
        commentFld.sendKeys(data.get("Text"));
        softAssert.assertTrue(submitBtn.isEnabled());
        submitBtn.click();
    }
    public void verifyToolTip(){
       softAssert.assertTrue(successToolTip.isDisplayed());
    }

}

