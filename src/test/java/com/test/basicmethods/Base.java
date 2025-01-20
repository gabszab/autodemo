package com.test.basicmethods;

import org.openqa.selenium.*;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class Base {

    public WebDriver driver;
    String pageName;
    String specFilePath;

    public List<WebElement> listEls = new ArrayList<>();
    public List<String> all = new ArrayList<>();
    public SeleniumWait wait;



    public SpecFileReader specFileReader;

    public Base(WebDriver driver, String pageName, String specFilePath) {

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


