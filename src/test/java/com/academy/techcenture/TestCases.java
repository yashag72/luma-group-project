package com.academy.techcenture;

import com.academy.techcenture.pages.*;
import com.academy.techcenture.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class TestCases extends BaseTest{
//5. Verify the title of the Register page
//6. Verify the ‘Create New Customer Account’ header
//7. Verify the ‘Personal Information’ header
//8. Enter First Name and Last Name
//9. Check Sign Up for Newsletter checkbox
//10. Verify Sign-in information header
//11. Enter Email address
//12. Enter Password
//13. Enter Confirm Password
//14. Verify Create an Account button is displayed.
//15. Click on Create an Account button.
    private RegisterPage registerPage;
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ShippingPage shippingPage;
    private ReviewPaymentPage reviewPaymentPage;
    private ThankYouPage thankYouPage;
    private ContactUsPage contactUsPage;

    @Test(dataProvider = "CustomerInfo")

    public void registerPageTest1Positive(Map<String,String> data) throws InterruptedException {
        homePage = new HomePage(driver, softAssert);
        registerPage = new RegisterPage(driver,softAssert);
        myAccountPage = new MyAccountPage(driver, softAssert);
        homePage.navigateToUrl();
        homePage.createAccountClick();
        registerPage.verifyTasksRegisterPage();
        registerPage.enterCustInfo(data);
        myAccountPage.verifyMyAccountPageTitle();
        myAccountPage.verifyTasksMyAccountPage();
        myAccountPage.fillAddressBook(data);
        Thread.sleep(3000);
        homePage.signOutOfLuma();



    }
    @Test(dataProvider = "CustomerInfo")
    public void subscribtionTest2(Map<String,String> data) throws InterruptedException {
        homePage = new HomePage(driver, softAssert);
        homePage.registerForNewsletter(data);
    }
    @Test(dataProvider = "CustomerInfo")
    public void subscribtionTest2Neg(Map<String,String> data) throws InterruptedException {
        homePage = new HomePage(driver, softAssert);
        homePage.registerForNewsletterNeg(data);
    }

    @Test(dataProvider ="CustomerInfo" )
    public void signInTest3(Map<String,String> data) throws InterruptedException {
        homePage = new HomePage(driver, softAssert);
        loginPage = new LoginPage(driver, softAssert);
        myAccountPage = new MyAccountPage(driver,softAssert);
        homePage.navigateToUrl();
        homePage.verifyHomePageTitle();
        homePage.signInBtn();
        loginPage.verifyCustLoginHeader();
        loginPage.enterCustInfo(data);
        myAccountPage.verifyWelcomeUserMsg();
        homePage.signOutOfLuma();
    }
    @Test(dataProvider = "CustomerInfo")
    public void incorrectLoginTest4Neg(Map<String,String>data) throws InterruptedException {
        homePage = new HomePage(driver, softAssert);
        loginPage = new LoginPage(driver, softAssert);
        myAccountPage = new MyAccountPage(driver,softAssert);
        homePage.navigateToUrl();
        homePage.verifyHomePageTitle();
        homePage.verifySignInLink();
        homePage.signInBtn();
        loginPage.enterCustInfoNeg(data);
    }
    @Test(dataProvider = "CustomerInfo")
    public void chooseJacketTest5Pos(Map<String,String>data) throws InterruptedException {
        homePage = new HomePage(driver, softAssert);
        loginPage = new LoginPage(driver, softAssert);
        myAccountPage = new MyAccountPage(driver, softAssert);
        productsPage = new ProductsPage(driver, softAssert);
        shippingPage = new ShippingPage(driver, softAssert);
        reviewPaymentPage = new ReviewPaymentPage(driver, softAssert);
        thankYouPage = new ThankYouPage(driver, softAssert);

        homePage.navigateToUrl();
        homePage.verifyHomePageTitle();
        homePage.verifySignInLink();
        homePage.signInBtn();
        loginPage.verifyCustLoginHeader();
        loginPage.enterCustInfo(data);
        loginPage.verifyWelcomeUsrMsg();
        productsPage.goToJackets();
        productsPage.chooseJacketByName();
        productsPage.chooseJacketByPrice();
        productsPage.orderFirstProduct();
        shippingPage.verifyShippingPage();
        reviewPaymentPage.verifyReviewPayment();
        thankYouPage.verifyThankYouPage();
    }
    @Test(dataProvider = "CustomerInfo")
    public void contactUs6Pos(Map<String,String>data) throws InterruptedException {
        homePage = new HomePage(driver, softAssert);
        loginPage = new LoginPage(driver, softAssert);
        contactUsPage = new ContactUsPage(driver, softAssert);
        homePage.navigateToUrl();
        homePage.verifyHomePageTitle();
        homePage.verifySignInLink();
        homePage.signInBtn();
        loginPage.verifyCustLoginHeader();
        loginPage.enterCustInfo(data);
        loginPage.verifyWelcomeUsrMsg();
        loginPage.contactUsLnk.click();
        contactUsPage.verifyContactUsPageTitle();
        contactUsPage.verifyOnContactUsPage(data);
        contactUsPage.verifyToolTip();
        contactUsPage.signOutOfLuma();




    }
    @DataProvider(name = "CustomerInfo")
    public Object[][] getCreateCustomerData(){
        Object[][] reader = new ExcelReader("src/main/resources/LumaData.xlsx","customer").getData();
        return reader;
    }

    @Test(dataProvider = "CustomerInfo")
    public void test1(Map<String,String> data){
        System.out.println(data);
    }
}
