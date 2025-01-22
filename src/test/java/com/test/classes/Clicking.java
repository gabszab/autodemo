package com.test.classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Clicking extends Base {

    Base base;

    public Clicking(WebDriver driver, String pageName, String specFilePath) {
        super(driver, pageName, specFilePath);
        base = new Base(driver, pageName, specFilePath);
    }


    public void clickByJavaScript(WebElement element){
        scrollDown(element);
        waitForToLoad();
        wait.waitForElementToBeVisible(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickOnClickMeButton(String string) {
        waitForToLoad();
        scrollToElement(element("clickMe_button"));
        wait.waitForElementToBeClickable(element("clickMe_button"));
        clickByJavaScript(element("clickMe_button"));
        logMessage("User clicked on Click Me button");
    }
}
