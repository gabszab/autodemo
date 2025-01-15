package com.test.handlepageobjects;

import com.test.basicmethods.Base;
import org.openqa.selenium.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

public class Navigation extends Base {




    public Navigation(WebDriver driver, String pageName) {
        super(driver, pageName);
    }




    public void verifyPageURL(String expectedUrl) {
        wait.waitForAnyElementToBeVisible();
        wait.waitForSync(3);
        String actualUrl = webdriver.getCurrentUrl();
    }


}
