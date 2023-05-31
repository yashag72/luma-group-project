package com.academy.techcenture.pages;

import com.academy.techcenture.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class MyAccountPage extends BasePage{
// 16. Verify My Account page title
// 17. Verify Account information on this page including:
//    First Name, Last Name, email
// 18. Verify Menu Items on the right side:
//    My Account, My Orders, My Downloadable Products, My Wish List, Address Book,
//    Account Information, Stored Payment Methods, My Product Reviews, Newsletter Subscriptions
// 19. Click on Address Book link from the right menu
    public MyAccountPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }


    @FindBy (xpath = "//span[@class='base']")
    protected WebElement myAccountTitle;
    @FindBy (xpath = "//div/p")
    protected WebElement firstLastEmailInfo;

    @FindBy (xpath = "//strong[text()='My Account']")
    protected WebElement myAccountHeaderRight;

    @FindBy (xpath = "//a[text()='My Orders']")
    protected WebElement myOrdersHeaderRight;

    @FindBy (xpath = "//a[text()='My Downloadable Products']")
    protected WebElement myDownloadableHeaderRight;

    @FindBy (xpath = "//a[text()='My Wish List']")
    protected WebElement myWishListHeaderRight;

    @FindBy (xpath = "//a[text()='Address Book']")
    protected WebElement myAddressBookHeaderRight;

    @FindBy (xpath = "//a[text()='Account Information']")
    protected WebElement accountInfoHeaderRight;

    @FindBy (xpath = "//a[text()='Stored Payment Methods']")
    protected WebElement storedPaymMethodsHeaderRight;

    @FindBy (xpath = "//a[text()='My Product Reviews']")
    protected WebElement myProductReviewsHeaderRight;

    @FindBy (xpath = "//a[text()='Newsletter Subscriptions']")
    protected WebElement newsLetterSubHeaderRight;
    @FindBy(id = "company")
    protected WebElement company;
    @FindBy(id = "telephone")
    protected WebElement telephone;
    @FindBy(id = "street_1")
    protected WebElement street;
    @FindBy(id = "city")
    protected WebElement city;
    @FindBy(xpath = "//select[@id='region_id']")
    protected WebElement state;
    @FindBy(id = "zip")
    protected WebElement zip;
    @FindBy (xpath = "//span[contains(text(), 'Save')]")
    protected WebElement saveAddressBtn;
    @FindBy (xpath = "(//a[contains(text(), 'Sign Out')])[1]")
    protected WebElement signOutBtn;
    @FindBy (xpath = "(//button[@class='action switch'])[1]")
    protected WebElement dropDownBtn;
    @FindBy(xpath = "(//li[@class='greet welcome'])[1]")
    protected WebElement welcomeUserMsg;




    public void verifyMyAccountPageTitle(){
        String myAccountPageTitle = driver.getTitle();
        softAssert.assertEquals(myAccountPageTitle, "My Account");
    }

    public void verifyTasksMyAccountPage() {
        softAssert.assertTrue(myAccountTitle.isDisplayed());
        softAssert.assertTrue(firstLastEmailInfo.isDisplayed());
        softAssert.assertTrue(myAccountHeaderRight.isDisplayed());
        softAssert.assertTrue(myOrdersHeaderRight.isDisplayed());
        softAssert.assertTrue(myDownloadableHeaderRight.isDisplayed());
        softAssert.assertTrue(myWishListHeaderRight.isDisplayed());
        softAssert.assertTrue(myAddressBookHeaderRight.isDisplayed());
        softAssert.assertTrue(accountInfoHeaderRight.isDisplayed());
        softAssert.assertTrue(storedPaymMethodsHeaderRight.isDisplayed());
        softAssert.assertTrue(myProductReviewsHeaderRight.isDisplayed());
        softAssert.assertTrue(newsLetterSubHeaderRight.isDisplayed());
        myAddressBookHeaderRight.click();

    }
    public void fillAddressBook(Map<String,String> data){
        Select select = new Select(state);
        company.sendKeys(data.get("Company"));
        telephone.sendKeys(data.get("Phone"));
        street.sendKeys(data.get("StreetAddress"));
        city.sendKeys(data.get("City"));
        select.selectByValue("61");
        zip.sendKeys(data.get("Zip"));
        softAssert.assertTrue(saveAddressBtn.isEnabled());
        saveAddressBtn.click();
    }
    public void verifyWelcomeUserMsg() throws InterruptedException {
       softAssert.assertTrue(welcomeUserMsg.isDisplayed());
    }



}
