package com.test.basicmethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.Assert.assertTrue;

public class Base {

    protected WebDriver webdriver;
    String pageName;

    protected List<WebElement> listEls = new ArrayList<>();
    protected List<String> all = new ArrayList<>();
    public SeleniumWait wait;

    public Base(WebDriver driver, String pageName) {

        this.webdriver = driver;
        this.pageName = pageName;
        this.wait = new SeleniumWait(driver, 30);
    }

    public WebElement element(String elementToken) {

        return element(elementToken);
    }

    public void logMessage(String message) {
        Reporter.log(message, true);
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

    public void waitForAnyElementToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*")));
    }



}


