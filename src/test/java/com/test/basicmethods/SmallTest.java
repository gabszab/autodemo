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
    void test() {

        driver.get("https://demoqa.com/");
        String title = driver.getTitle();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleContains("DEMOQA"));

        assertThat(title).contains("DEMOQA");
        logMessage("Page contains proper expression.");
    }

    @Test
    void testSecond() throws InterruptedException {


        driver.get("https://demoqa.com/buttons");
        WebElement button = driver.findElement(By.cssSelector(".btn-primary"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();

        Thread.sleep(4000);

        }


}

