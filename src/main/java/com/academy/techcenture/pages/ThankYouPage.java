package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class ThankYouPage extends BasePage{
    public ThankYouPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }
    @FindBy(xpath = "//span[@class='base']")
    protected WebElement thankYouMsg;
    @FindBy(xpath = "//a[@class='order-number']")
    protected WebElement orderNumberLink;
    @FindBy(xpath = "//span[@class='order-status']")
    protected WebElement status;
    @FindBy(xpath = "(//div[@class='order-date']/span)[2]")
    protected WebElement orderDate;
    @FindBy(xpath = "//strong[@class='product name product-item-name']")
    protected WebElement productNameSign;

    @FindBy(xpath = "//td[@class='col sku']")
    protected WebElement sku;
    @FindBy(xpath = "//span[@class='price']")
    protected WebElement price;
    @FindBy(xpath = "//span[@class='content']")
    protected WebElement quantity;
    @FindBy(xpath = "//td[@class='col subtotal']")
    protected WebElement subTotal;
    @FindBy(xpath = "//dl[@class='item-options]/dd[2]")
    protected WebElement color;
    @FindBy(xpath = "//dl[@class='item-options']/dd")
    protected WebElement size;
    @FindBy(xpath = "//a[@class='logo']")
    protected WebElement logoHomePage;



    public void verifyThankYouPage() throws InterruptedException {
        Thread.sleep(1000);
        softAssert.assertTrue(thankYouMsg.isDisplayed());
        Thread.sleep(1000);
        softAssert.assertTrue(orderNumberLink.isDisplayed());
        Thread.sleep(1000);
        orderNumberLink.click();
        System.out.println("order date from the page: " + orderDate.getText());
        System.out.println("Todays date: " + GetTodayDate());
        softAssert.assertEquals(orderDate.getText(),GetTodayDate().trim());
        softAssert.assertEquals(status.getText(),"PENDING");
        softAssert.assertTrue(productNameSign.isDisplayed());
        softAssert.assertTrue(sku.isDisplayed());
        softAssert.assertTrue(price.isDisplayed());
        softAssert.assertTrue(quantity.isDisplayed());
        softAssert.assertTrue(subTotal.isDisplayed());
        softAssert.assertTrue(price.isDisplayed());
        softAssert.assertTrue(size.isDisplayed());
        signOutOfLuma();
        logoHomePage.click();
    }
}
