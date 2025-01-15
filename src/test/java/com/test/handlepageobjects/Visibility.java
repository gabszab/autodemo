package com.test.handlepageobjects;

import com.test.basicmethods.Base;
import org.openqa.selenium.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.Assert.assertTrue;


public class Visibility extends Base {

    public Visibility(WebDriver driver, String pageName) {
        super(driver, pageName);
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
