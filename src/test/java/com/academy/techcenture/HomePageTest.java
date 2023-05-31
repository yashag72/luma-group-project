package com.academy.techcenture;

import com.academy.techcenture.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
//    1. Navigate to https://magento.softwaretestingboard.com/
//    2. Verify the title of the home page
//    3. Verify ‘Create an Account’ is displayed
//    4. Click on ‘Create an Account’ link
    private HomePage homePage;
    @Test
    public void homePagePositive(){
        homePage = new HomePage(driver, softAssert);
        homePage.navigateToUrl();
        homePage.verifyHomePageTitle();
        homePage.verifyHomePageCreateAccountLink();
        homePage.createAccountClick();

    }
}
