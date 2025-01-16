package com.test.handlepageobjects;

import com.test.basicmethods.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.Assert.assertTrue;


public class Visibility extends Base {

    Base base;

    public Visibility(WebDriver driver, String pageName, String specFilePath) {
        super(driver, pageName,specFilePath);
        base = new Base(driver, pageName, specFilePath);
    }


    public boolean isElementDisplayed(String elementName) {
        boolean result = false;
        try {
            wait.waitForElementToBeVisible(element(elementName));
            result = element(elementName).isDisplayed();
            assertTrue(result, "TEST FAILED: element '" + elementName + "' is not displayed.");
            logMessage("TEST PASSED: element " + elementName + " is displayed.");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }


}
