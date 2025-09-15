package com.automation.login;

import com.automation.utils.CommonMethod;
import com.automation.utils.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends CommonMethod {
    Logger logger = Logger.getLogger(Login.class);

    public Login(){
        PageFactory.initElements(TestBase.getWebDriver(),this);
    }

    //login form
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement paaswordField;
    @FindBy(xpath = "//img[@class='object-cover w-9 h-9 rounded-full']")
    WebElement profileIcon;

    public void loadLoginPage(){
//        TestBase.getInstance();
        TestBase.getWebDriver().get("https://slot.yesno247.in/user/casino");
        logger.info("login page loaded...");
    }

    public void loginUser(){
        waitForVisibleElement(usernameField);
//        usernameField.sendKeys("Abhi01");
        usernameField.sendKeys("Abhi01");
        logger.info("Username enter...  "+getClass());
        waitForVisibleElement(paaswordField);
        paaswordField.sendKeys("Abhi@11223");
        logger.info("Password enter :: "+getClass());
    }

    public void clickSubmitBtn(String button){
        clickOnButtons(button);
        logger.info("Button clicked :: "+button);
    }

    public void verifyHomePage(){
        waitForVisibleElement(profileIcon);
        profileIcon.click();
        logger.info("Verify home screen :: ");
    }
}
