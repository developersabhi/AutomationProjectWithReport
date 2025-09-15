package com.automation.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class TestBase {
    Logger logger = Logger.getLogger(TestBase.class);
    protected static WebDriver driver = null;
    private static TestBase instance;

    //first step
    public void init() {
        try {
            if (driver == null) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                logger.info("Driver init :: " + getClass());
            }
        } catch (Exception e) {
            logger.error("Driver not init :: " + e.getMessage());
        }
    }

    //Second Step
    public static WebDriver getWebDriver() {
        return driver;
    }

    //3rd step => pure project m ek hi object create krne k liye "Singleton Design Pattern" ka use  krte h
    public static TestBase getInstance() {
        if (instance == null) {
            instance = new TestBase();
        }
        return instance;
    }

    //4th step ye constructor h
    public TestBase(){
        init();
        logger.info("Driver init using TestBase Constructor :: "+getClass());
        PageFactory.initElements(getWebDriver(),this);
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("Driver closed successfully.");
        }
    }
}
