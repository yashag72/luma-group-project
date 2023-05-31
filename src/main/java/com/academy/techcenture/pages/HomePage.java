package com.academy.techcenture.pages;

import com.academy.techcenture.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.Map;
//    1. Navigate to https://magento.softwaretestingboard.com/
//    2. Verify the title of the home page
//    3. Verify ‘Create an Account’ is displayed
//    4. Click on ‘Create an Account’ link

public class HomePage extends BasePage{
    public HomePage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy (xpath = "//a[text()='Create an Account']")
    protected WebElement createAccountLink;
    @FindBy(id = "newsletter")
    protected WebElement newsletterField;
    @FindBy(xpath = "//span[text()='Subscribe']")
    protected WebElement subscribeBtn;
    @FindBy(xpath = "//div[contains(text(), 'Thank you')]")
    protected WebElement successMessage;
    @FindBy(xpath = "//div[contains(text(), 'already')]")
    protected WebElement notSuccessMesg;

    public void navigateToUrl(){
    driver.get(ConfigReader.getProperty("url"));
    }
    public void verifyHomePageTitle(){
        String homePageTitle = driver.getTitle();
        softAssert.assertEquals(homePageTitle, "Home Page");
    }
    public void verifySignInLink(){
        softAssert.assertTrue(signInLink.isDisplayed());
    }
    public void verifyHomePageCreateAccountLink(){
        softAssert.assertTrue(createAccountLink.isDisplayed());
    }
    public void createAccountClick(){
        createAccountLink.click();
    }
    public void registerForNewsletter(Map<String ,String> data) throws InterruptedException {
        navigateToUrl();
        verifyHomePageTitle();
        softAssert.assertTrue(newsletterField.isDisplayed());
        newsletterField.sendKeys(data.get("Newsletter"));
        Thread.sleep(1000);
        softAssert.assertTrue(subscribeBtn.isEnabled());
        subscribeBtn.click();
        softAssert.assertTrue(successMessage.isDisplayed());
    }
    public void registerForNewsletterNeg(Map<String ,String> data) throws InterruptedException {
        navigateToUrl();
        verifyHomePageTitle();
        softAssert.assertTrue(newsletterField.isDisplayed());
        newsletterField.sendKeys(data.get("Newsletter"));
        Thread.sleep(1000);
        softAssert.assertTrue(subscribeBtn.isEnabled());
        subscribeBtn.click();
        softAssert.assertTrue(notSuccessMesg.isDisplayed());
    }




}
