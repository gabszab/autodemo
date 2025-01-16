package com.test.basicmethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import static org.testng.Assert.assertTrue;

public class Base {

    public WebDriver driver;
    String pageName;
    String specFilePath;

    public List<WebElement> listEls = new ArrayList<>();
    public List<String> all = new ArrayList<>();
    public SeleniumWait wait;



    public SpecFileReader specFileReader;

    public Base(WebDriver driver, String pageName, String specFilePath) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabor.szabo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        this.driver = driver;
        this.pageName = pageName;
        this.specFilePath = (specFilePath != null) ? specFilePath : "C:\\Users\\gabor.szabo\\autodemo\\src\\test\\resources\\PageObjects";
        this.wait = new SeleniumWait(driver, 30);
        this.specFileReader = new SpecFileReader(this.specFilePath);



    }




    public WebElement element(String elementToken) {
        String xpath = specFileReader.getXPath(elementToken);
        if (xpath != null) {
            return driver.findElement(By.xpath(xpath));
        } else {
            throw new NoSuchElementException("Element token '" + elementToken + "' not found in spec file.");
        }
    }

    public void logMessage(String message) {
        Reporter.log(message, true);

    }




    public void waitForToLoad() {
        wait.waitForSync(3);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(" + element.getLocation().x + "," + element.getLocation().y + ")");
        logMessage("scrolled to the element: " + element.toString());
    }

    public void scrollDown(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(false);", element);

    }


}


