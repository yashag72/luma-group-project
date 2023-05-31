package com.academy.techcenture;

import com.academy.techcenture.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected static WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
        softAssert.assertAll();
    }
}
