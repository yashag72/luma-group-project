package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class ShippingPage extends BasePage{
    public ShippingPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }
    Actions action = new Actions(driver);
    @FindBy(xpath = "//span[text()='Shipping']")
    protected WebElement shippingCheck;
    @FindBy(xpath = "(//div[@class=\"step-title\"])[1]")
    protected WebElement shippingAddrHeader;

    @FindBy(xpath = "(//td/input)[1]")
    protected WebElement shippingMethodFixedRadioBtn;
    @FindBy(xpath = "//button[@class='button action continue primary']")
    protected WebElement nextBtn;



    public void verifyShippingPage() throws InterruptedException {
        String shippingPageTitle = driver.getTitle();
        System.out.println("shipping page Title: " + shippingPageTitle);
        softAssert.assertEquals(shippingPageTitle,"Checkout");
        Thread.sleep(1000);
        softAssert.assertTrue(shippingCheck.isDisplayed());
        softAssert.assertTrue(shippingAddrHeader.isDisplayed());
        shippingMethodFixedRadioBtn.click();
        softAssert.assertTrue(nextBtn.isEnabled());
        nextBtn.click();
    }

}
