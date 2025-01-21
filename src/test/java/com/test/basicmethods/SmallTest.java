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
        logMessage("User clicked on the 'Double Click Me' button.");

        WebElement doubleClickMessage = driver.findElement(By.cssSelector("#doubleClickMessage"));
        String messageText = doubleClickMessage.getText();
        assertThat(messageText).isEqualTo("You have done a double click");
        logMessage("'You have done a double click message' is displayed");


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
        logMessage("User clicked on the 'Right Click Me' button.");

        WebElement rightClickMessage = driver.findElement(By.cssSelector("#rightClickMessage"));
        String messageText = rightClickMessage.getText();
        assertThat(messageText).isEqualTo("You have done a right click");
        logMessage("'You have done a right click message' is displayed");

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
        logMessage("User clicked on the 'Click Me' button.");

        WebElement dynamicClickMessage = driver.findElement(By.cssSelector("#dynamicClickMessage"));
        String messageText = dynamicClickMessage.getText();
        assertThat(messageText).isEqualTo("You have done a dynamic click");
        logMessage("'You have done a dynamic click message' is displayed");

        Thread.sleep(4000);


    }

}

