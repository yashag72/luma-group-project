package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BasePage {

    protected static WebDriver driver;
    protected SoftAssert softAssert;

    public BasePage(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "(//a[contains(text(), 'Sign In')])[1]")
    protected WebElement signInBtn;

    @FindBy(xpath = "(//a[contains(text(), 'Sign Out')])[1]")
    protected WebElement signOutBtn;
    @FindBy(xpath = "(//button[@data-action='customer-menu-toggle'])[1]")
    protected WebElement menuDropDown;
    @FindBy(xpath = "//a[contains(text(), 'Sign')]")
    protected WebElement signInLink;
    @FindBy(xpath = "(//span[@class='logged-in'])[1]")
    protected WebElement welcomeHeader;
    @FindBy(xpath = "//a[text()='Contact Us']")
    public WebElement contactUsLnk;
    public void signInBtn(){
        if (signInLink.isDisplayed()){
            signInLink.click();
        }
    }
    public void signOutOfLuma(){
        if (welcomeHeader.isDisplayed()){
            menuDropDown.click();
            signOutBtn.click();
        }
    }
    public String GetTodayDate(){

           // Create object of SimpleDateFormat class and decide the format
            DateFormat dateFormat = new SimpleDateFormat("MMMMMMMMMMM dd, yyyy");

            //get current date time with Date()
            Date date = new Date();

            // Now format the date
            String date1= dateFormat.format(date);

            // Print the Date

        return date1;
        }



    }



