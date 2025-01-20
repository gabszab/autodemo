package com.test.basicmethods;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

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
