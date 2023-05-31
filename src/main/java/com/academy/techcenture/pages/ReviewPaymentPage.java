package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class ReviewPaymentPage extends BasePage{
    public ReviewPaymentPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }
    @FindBy(xpath = "//span[text()='Review & Payments']")
    protected WebElement reviewCheckLogo;
    @FindBy(xpath = "//div[text()='Payment Method']")
    protected WebElement paymMethodHeader;
    @FindBy(id = "billing-address-same-as-shipping-checkmo")
    protected WebElement myBillCheckbox;

    @FindBy(xpath = "//span[text()='Order Summary']")
    protected WebElement orderSummaryHeader;
    @FindBy(xpath = "//button[@title='Place Order']")
    protected WebElement placeOrderBtn;

    public void verifyReviewPayment() throws InterruptedException {
        softAssert.assertTrue(reviewCheckLogo.isDisplayed());
        Thread.sleep(1000);
        softAssert.assertTrue(paymMethodHeader.isDisplayed());
        Thread.sleep(1000);
        if(myBillCheckbox.isSelected() != true){
            myBillCheckbox.click();
        }
        softAssert.assertTrue(orderSummaryHeader.isDisplayed());
        Thread.sleep(1000);
        softAssert.assertTrue(placeOrderBtn.isEnabled());
        Thread.sleep(1000);
        placeOrderBtn.click();

    }





}
