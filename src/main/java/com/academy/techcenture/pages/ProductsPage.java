package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProductsPage extends BasePage{
    public ProductsPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }
    Actions action = new Actions(driver);

    @FindBy(id = "ui-id-5")
    protected WebElement menCategory;
    @FindBy(id = "ui-id-17")
    protected WebElement topsCategory;
    @FindBy(id = "ui-id-19")
    protected WebElement jacketsCategory;
    @FindBy(xpath = "(//span[text()='Jackets'])[3]")
    protected WebElement jacketsHeader;
    @FindBy(xpath = "(//select[@id='sorter'])[1]")
    protected WebElement sortByBtn;
    @FindBy(xpath = "(//select[@id='sorter'])[1]/option[@value='name']")
    protected WebElement sortByProductNameBtn;
    @FindBy(xpath = "(//li[1]/div/div/strong/a)[1]")
    protected WebElement beaumontJacket;
    @FindBy(xpath = "(//li[11]/div/div/strong/a)[1]")
    protected WebElement typhonJacket;
    @FindBy(xpath = "//*[@id=\"product-price-270\"]/span")
    protected WebElement firstProductPrice;
    @FindBy(xpath = "//span[@id='product-price-334']/span")
    protected WebElement lastProductPrice;
    @FindBy (xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img")
    protected WebElement firstProductByPrice;
    @FindBy (xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1/span")
    protected WebElement firstProductNameVerify;
    @FindBy (id = "option-label-size-143-item-168")
    protected WebElement firstProductSizeM;
    @FindBy (id = "option-label-color-93-item-60")
    protected WebElement firstProductColorY;
    @FindBy (id = "qty")
    protected WebElement firstProductQuantity;
    @FindBy (id = "product-addtocart-button")
    protected WebElement addToCartBtn;
    @FindBy (xpath = "//div[contains(text(),'You added')]")
    protected WebElement addedToCartMsg;
    @FindBy (xpath = "//a[@class='action showcart']")
    protected WebElement cart;
    @FindBy (xpath = "//span[@class='counter-number']")
    protected WebElement cartQuantity;
    @FindBy (id = "top-cart-btn-checkout")
    protected WebElement cartCheckOutBtn;
    @FindBy (xpath = "(//a[@href='#'])[1]")
    protected WebElement deleteBtn;
    @FindBy (xpath = "/html/body/div[3]/aside[2]/div[2]/footer/button[2]")
    protected WebElement deleteOkBtn;


    public void goToJackets() throws InterruptedException {
        action.moveToElement(menCategory).perform();
        action.moveToElement(topsCategory).perform();
        action.moveToElement(jacketsCategory).perform();
        jacketsCategory.click();
        softAssert.assertTrue(jacketsHeader.isDisplayed());
    }
    public void chooseJacketByName() throws InterruptedException {
        Select sortDropDown = new Select(sortByBtn);
        action.moveToElement(sortByBtn).perform();
        sortByBtn.click();
        sortDropDown.selectByValue("name");
        System.out.println("beaumontJacket-text: " + beaumontJacket.getText());
        System.out.println("typhonJacket-text: " + typhonJacket.getText());
        softAssert.assertEquals(beaumontJacket.getText(),"Beaumont Summit Kit");
        softAssert.assertEquals(typhonJacket.getText(),"Typhon Performance Fleece-lined Jacket");
    }
    public void chooseJacketByPrice() throws InterruptedException {
        Select sortDropDown = new Select(sortByBtn);
        action.moveToElement(sortByBtn).perform();
        sortByBtn.click();
        sortDropDown.selectByValue("price");
        Thread.sleep(1000);
        //System.out.println("firstProductPrice Text: " + firstProductPrice.getText());
        Thread.sleep(1000);
        softAssert.assertEquals(firstProductPrice.getText(),"$42.00");
        Thread.sleep(1000);
        //System.out.println("lasttProductPrice Text: " + lastProductPrice.getText());
        Thread.sleep(1000);
        softAssert.assertEquals(lastProductPrice.getText(),"$99.00");
    }
    public void orderFirstProduct() throws InterruptedException {
        firstProductByPrice.click();
        Thread.sleep(1000);
        softAssert.assertEquals(firstProductNameVerify.getText(),"Beaumont Summit Kit");
        Thread.sleep(1000);
        softAssert.assertEquals(firstProductPrice.getText(),"$42.00");
        Thread.sleep(1000);
        firstProductSizeM.click();
        firstProductColorY.click();
        firstProductQuantity.clear();
        firstProductQuantity.sendKeys("1");
        Thread.sleep(1000);
        softAssert.assertTrue(addToCartBtn.isEnabled());
        addToCartBtn.click();
        Thread.sleep(1000);
        softAssert.assertTrue(addedToCartMsg.isDisplayed());
        cart.click();
        Thread.sleep(1000);
        softAssert.assertEquals(cartQuantity.getText(),"1");
        Thread.sleep(1000);
        softAssert.assertTrue(cartCheckOutBtn.isEnabled());
        cartCheckOutBtn.click();
    }



}
