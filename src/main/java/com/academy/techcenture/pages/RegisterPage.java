package com.academy.techcenture.pages;

import com.academy.techcenture.pojos.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import com.academy.techcenture.utils.CommonUtils;

import java.util.Map;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }
    private HomePage homePage;
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

    @FindBy (xpath = "//span[@class='base']")
    protected WebElement createAccountHeader;
    @FindBy (xpath = "//span[text()='Personal Information']")
    protected WebElement persInfo;
    @FindBy (xpath = "//span[text()='Sign-in Information']")
    protected WebElement signInInfo;
    @FindBy (xpath = "//button[@title='Create an Account']")
    protected WebElement createAcctBTN;
    @FindBy (xpath = "//input[@name='firstname']")
    protected WebElement firstName;
    @FindBy (xpath = "//input[@name='lastname']")
    protected WebElement lastName;
    @FindBy (xpath = "//div[@class='field choice newsletter']")
    protected WebElement newsLetterCheckBox;
    @FindBy (xpath = "//input[@name='email']")
    protected WebElement email;

    @FindBy (xpath = "//input[@name='password']")
    protected WebElement password;
    @FindBy (xpath = "//input[@name='password_confirmation']")
    protected WebElement passwordConfirmation;





    public void verifyTitle(){
        String regPageTitle = driver.getTitle();
        System.out.println("regPageTitle:= " + regPageTitle);
        softAssert.assertEquals(regPageTitle, "Create New Customer Account");
    }

    public void verifyTasksRegisterPage() {
        softAssert.assertTrue(createAccountHeader.isDisplayed());
        softAssert.assertTrue(persInfo.isDisplayed());
        softAssert.assertTrue(signInInfo.isDisplayed());
        softAssert.assertTrue(createAcctBTN.isDisplayed());
    }
    public void enterCustInfo(Map<String,String> data){
//        Customer customer = CommonUtils.getRandomCustomer();
//        String fName = customer.getFirstName();
        firstName.sendKeys(data.get("FirstName"));
//        String lName = customer.getLastName();
        lastName.sendKeys(data.get("LastName"));
        newsLetterCheckBox.click();
        email.sendKeys(data.get("Email"));
        password.sendKeys(data.get("Password"));
        passwordConfirmation.sendKeys(data.get("Password"));
        createAcctBTN.click();
    }




}
