package com.test.basicmethods;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestElements extends TestBase{

    public void logMessage(String message) {
        Reporter.log(message, true);

    }

    @Test
    public void pageUrl() {

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
        logMessage("'You have done a right click' message is displayed");

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
        logMessage("'You have done a dynamic click' message is displayed");

        Thread.sleep(4000);


    }
    @Test
    void sendTextToTextBox() throws InterruptedException{

        driver.get("https://demoqa.com/text-box");

        String userName = "Random Name";
        String email = "random@email.com";
        String curAddress = "Random City and Street";
        String perAddress = "Less Random City and Street";

        WebElement nameInputField = driver.findElement(By.cssSelector("#userName"));
        nameInputField.sendKeys(userName);
        logMessage("User entered name.");
        WebElement emailInputField = driver.findElement(By.cssSelector("#userEmail"));
        emailInputField.sendKeys(email);
        logMessage("User entered email address.");
        WebElement curAddressField = driver.findElement(By.cssSelector("#currentAddress"));
        curAddressField.sendKeys(curAddress);
        logMessage("User entered current address.");
        WebElement perAddressField = driver.findElement(By.cssSelector("#permanentAddress"));
        perAddressField.sendKeys(perAddress);
        logMessage("User entered permanent address.");

        WebElement button = driver.findElement(By.cssSelector("#submit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        Actions actions = new Actions(driver);
        actions.click(button).perform();
        logMessage("User clicked on the 'Submit' button.");

        WebElement submitClickMessage = driver.findElement(By.cssSelector("#output"));
        String messageText = submitClickMessage.getText();
        assertThat(messageText)
                .contains(userName)
                .contains(email)
                .contains(curAddress)
                .contains(perAddress);
        logMessage("Submitted information is present in output box.");

        Thread.sleep(4000);

    }


    void checkBox(){

    }



    @Test
    void radioButtons() throws InterruptedException {
        driver.get("https://demoqa.com/radio-button");


        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".custom-control-input"));


        for (WebElement radioButton : radioButtons) {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", radioButton);


            Actions actions = new Actions(driver);
            actions.click(radioButton).perform();

            String radioButtonId = radioButton.getAttribute("id");
            if (radioButtonId.equals("yesRadio")) {
                logMessage("User clicked on the 'Yes' radio button.");
            } else if (radioButtonId.equals("impressiveRadio")) {
                logMessage("User clicked on the 'Impressive' radio button.");
            }

            WebElement message = driver.findElement(By.cssSelector("p.mt-3"));
            String messageText = message.getText();


            if (radioButton.getAttribute("id").equals("yesRadio")) {
                assertThat(messageText).isEqualTo("You have selected Yes");
                logMessage("'You have selected Yes' message is displayed");
            } else if (radioButton.getAttribute("id").equals("impressiveRadio")) {
                assertThat(messageText).isEqualTo("You have selected Impressive");
                logMessage("'You have selected Impressive' message is displayed");
            }


        }

        Thread.sleep(4000);
    }



    @Test
    void webTables() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");


        WebElement addButton = driver.findElement(By.cssSelector("#addNewRecordButton"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addButton);
        Actions actions = new Actions(driver);
        actions.click(addButton).perform();
        logMessage("User clicked on the 'Add' button.");


        String[] fieldNames = {"#firstName", "#lastName", "#userEmail", "#age", "#salary", "#department"};
        String[] fieldValues = {"Random", "Name", "random@email.com", "40", "1000000", "Doing Things Dept."};


        for (int i = 0; i < fieldNames.length; i++) {
            WebElement field = driver.findElement(By.cssSelector(fieldNames[i]));
            field.sendKeys(fieldValues[i]);
            logMessage("User entered " + fieldValues[i] + " in the field: " + fieldNames[i]);
        }


        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        actions.click(submitButton).perform();
        logMessage("User clicked on the 'Submit' button.");

        Thread.sleep(4000);
    }

}

