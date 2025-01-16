package com.test.handlepageobjects;

import com.test.basicmethods.Base;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.test.basicmethods.SeleniumWait;

public class Navigation extends Base {
    Base base;

    private static final Log log = LogFactory.getLog(Navigation.class);

    public Navigation(WebDriver driver, String pageName, String specFilePath) {
        super(driver, pageName, specFilePath);
        base = new Base(driver, pageName, specFilePath);
    }



    public void verifyPageURL(String expectedUrl) {
        wait.waitForAnyElementToBeVisible();
        wait.waitForSync(3);
        String actualUrl = driver.getCurrentUrl();
        logMessage("User is on expected page");
    }


}
