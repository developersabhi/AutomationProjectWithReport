package com.automation.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethod {
    Logger logger = Logger.getLogger(CommonMethod.class);
    WebDriverWait wait = new WebDriverWait(TestBase.getWebDriver(), Duration.ofMillis(10000));
    TestBase testBase = TestBase.getInstance();

    //login form
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement paaswordField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;


    public CommonMethod() {
        PageFactory.initElements(TestBase.getWebDriver(), this);
    }

    public void explicitWait(long time) {
        try {
            logger.info("Waiting for " + time);
            Thread.sleep(time);
        } catch (Exception e) {
            logger.error("Getting error while doing explicit wait:: " + e.getMessage());
        }
    }

    public void waitForVisibleElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static TestBase getTestBase() {
        return new TestBase();
    }

    public void enterText(String inputArea){
        switch (inputArea.toLowerCase()){
            case "username":
                usernameField.sendKeys("abhi01");
                break;
//            case "":
//                break;
//            case "":
//                break;
            default:
        }
    }

    public void clickOnButtons(String button) {
        switch (button.toLowerCase()) {
            case "submit":
                waitForVisibleElement(submitBtn);
                submitBtn.click();
                logger.info("Button Clicked :: "+button + "  "+getClass());
                break;
//            case "":
//                break;
//            case "":
//                break;
//            case "":
//                break;
//            case "":
//                break;
            default:
                logger.error("Button not found.." + button);
        }
    }

}
