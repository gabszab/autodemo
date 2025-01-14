package com.test.basicmethods;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


public class SeleniumWait {
    WebDriver driver;
    WebDriverWait wait;

    int timeout;

    public SeleniumWait(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        this.timeout = timeout;
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return (WebElement) wait.until(ExpectedConditions.visibilityOf(element));
    }

}
