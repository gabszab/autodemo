package com.test.basicmethods;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class SmallTest extends TestBase{

    public void logMessage(String message) {
        Reporter.log(message, true);

    }

    @Test
    void pageUrl() {

        driver.get("https://demoqa.com/buttons");
        String url = driver.getCurrentUrl();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("buttons"));

        assertThat(url).contains("buttons");
        logMessage("User is on the expected page.");
    }

    @Test
    void doubleClickButton() throws InterruptedException {


        driver.get("https://demoqa.com/buttons");
        WebElement button = driver.findElement(By.cssSelector("#doubleClickBtn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();

        Thread.sleep(4000);

        }

    @Test
    void rightClickButton() throws InterruptedException {

        driver.get("https://demoqa.com/buttons");
        WebElement button = driver.findElement(By.cssSelector("#rightClickBtn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        Actions actions = new Actions(driver);
        actions.contextClick(button).perform();

        Thread.sleep(4000);
    }

    @Test
    void clickButton() throws InterruptedException {

        driver.get("https://demoqa.com/buttons");
        WebElement button = driver.findElement(By.xpath("//button[text()='Click Me']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        Actions actions = new Actions(driver);
        actions.click(button).perform();

        Thread.sleep(4000);
    }

}

