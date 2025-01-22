package com.test.classes;

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

    public void until(ExpectedCondition<WebElement> webElementExpectedCondition) {
    }

    public void waitForAnyElementToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//*")));
    }

    public void waitForSync(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
