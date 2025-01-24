package com.test.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class TestElements {

    WebDriver driver;

    public TestElements(WebDriver driver){
        this.driver = driver;
    }

    String userName = "Random Name";
    String email = "random@email.com";
    String curAddress = "Random City and Street";
    String perAddress = "Less Random City and Street";
    String newFirstName = "Not Cierra";

    public void navigateToUrl(String url) {
        driver.get(url);

    }

    public void logMessage(String message) {
        System.out.println(message);

    }



    public void pageUrl(String url) {
        navigateToUrl(url);
        String currentUrl = driver.getCurrentUrl();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains(url));
        assertThat(currentUrl).contains(url);
        logMessage("User is on the expected page.");
    }


    public void doubleClickButton() {
        WebElement doubleClickButton = driver.findElement(By.cssSelector("#doubleClickBtn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", doubleClickButton);
        Actions clickOn = new Actions(driver);
        clickOn.doubleClick(doubleClickButton).perform();
        logMessage("User clicked on the 'Double Click Me' button.");
    }

    public void doubleClickMessage(){
        WebElement doubleClickMessage = driver.findElement(By.cssSelector("#doubleClickMessage"));
        String messageText = doubleClickMessage.getText();
        assertThat(messageText).isEqualTo("You have done a double click");
        logMessage("'You have done a double click message' is displayed");
    }

    public void rightClickButton() {
        WebElement rightClickButton = driver.findElement(By.cssSelector("#rightClickBtn"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", rightClickButton);
        Actions clickOn = new Actions(driver);
        clickOn.contextClick(rightClickButton).perform();
        logMessage("User clicked on the 'Right Click Me' button.");
    }

    public void rightClickMessage(){
        WebElement rightClickMessage = driver.findElement(By.cssSelector("#rightClickMessage"));
        String messageText = rightClickMessage.getText();
        assertThat(messageText).isEqualTo("You have done a right click");
        logMessage("'You have done a right click' message is displayed");
    }

    public void clickButton() {
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", clickButton);
        Actions clickOn = new Actions(driver);
        clickOn.click(clickButton).perform();
        logMessage("User clicked on the 'Click Me' button.");
    }

    public void clickButtonMessage(){
        WebElement dynamicClickMessage = driver.findElement(By.cssSelector("#dynamicClickMessage"));
        String messageText = dynamicClickMessage.getText();
        assertThat(messageText).isEqualTo("You have done a dynamic click");
        logMessage("'You have done a dynamic click' message is displayed");
    }

    public void sendTextToTextBox() {
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
    }

    public void sendTextSubmitButton() {
        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Actions clickOn = new Actions(driver);
        clickOn.click(submitButton).perform();
        logMessage("User clicked on the 'Submit' button.");
    }

    public void verifySentText(){
        WebElement submitClickMessage = driver.findElement(By.cssSelector("#output"));
        String messageText = submitClickMessage.getText();
        assertThat(messageText)
                .contains(userName)
                .contains(email)
                .contains(curAddress)
                .contains(perAddress);
        logMessage("Submitted information is present in output box.");
    }

    public void clickRadioButtonYes(){
        WebElement yesRadio = driver.findElement(By.cssSelector("#yesRadio"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", yesRadio);
        Actions clickOn = new Actions(driver);
        clickOn.click(yesRadio).perform();
        logMessage("User clicked on the 'Click Me' button.");
    }

    public void yesButtonMessage(){
        WebElement yesMessage = driver.findElement(By.cssSelector("p.mt-3 span.text-success"));
        String messageText = yesMessage.getText();
        assertThat(messageText).contains("Yes");
        logMessage("'You have selected Yes' message is displayed");
    }

    public void clickRadioButtonImpressive(){
        WebElement impressiveRadio = driver.findElement(By.cssSelector("#impressiveRadio"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", impressiveRadio);
        Actions clickOn = new Actions(driver);
        clickOn.click(impressiveRadio).perform();
        logMessage("User clicked on the 'Click Me' button.");
    }

    public void impressiveButtonMessage(){
        WebElement impressiveMessage = driver.findElement(By.cssSelector("p.mt-3 span.text-success"));
        String messageText = impressiveMessage.getText();
        assertThat(messageText).contains("Impressive");
        logMessage("'You have selected Impressive' message is displayed");
    }

    /*public void clickRadioButtons() {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".custom-control-input"));
        for (WebElement radioButton : radioButtons) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", radioButton);
            Actions clickOn = new Actions(driver);
            clickOn.click(radioButton).perform();
            String radioButtonId = radioButton.getAttribute("id");
            if (radioButtonId.equals("yesRadio")) {
                logMessage("User clicked on the 'Yes' radio button.");
            } else if (radioButtonId.equals("impressiveRadio")) {
                logMessage("User clicked on the 'Impressive' radio button.");
            }

            radioButtonMessage(radioButtonId);
        }
    }

    public void radioButtonMessage(String radioButtonId){
            WebElement message = driver.findElement(By.cssSelector("p.mt-3"));
            String messageText = message.getText();
            if (radioButtonId.equals("yesRadio")) {
                assertThat(messageText).isEqualTo("You have selected Yes");
                logMessage("'You have selected Yes' message is displayed");
            } else if (radioButtonId.equals("impressiveRadio")) {
                assertThat(messageText).isEqualTo("You have selected Impressive");
                logMessage("'You have selected Impressive' message is displayed");
            }

    }*/
    public void clickAddButton() {
        WebElement addButton = driver.findElement(By.cssSelector("#addNewRecordButton"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addButton);
        Actions clickOn = new Actions(driver);
        clickOn.click(addButton).perform();
        logMessage("User clicked on the 'Add' button.");
    }

    public void addNewToWebTable() {

        String[] fieldNames = {"#firstName", "#lastName", "#userEmail", "#age", "#salary", "#department"};
        String[] fieldValues = {"Random", "Name", "random@email.com", "40", "1000000", "Doing Things Dept."};
        for (int i = 0; i < fieldNames.length; i++) {
            WebElement field = driver.findElement(By.cssSelector(fieldNames[i]));
            field.sendKeys(fieldValues[i]);
            logMessage("User entered " + fieldValues[i] + " in the field: " + fieldNames[i]);
        }
    }

    public void modalSubmit(){
        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Actions clickOn = new Actions(driver);
        clickOn.click(submitButton).perform();
        logMessage("User clicked on the 'Submit' button.");
    }

    public void deleteRecordFromWebTable() {
        WebElement deleteButton = driver.findElement(By.cssSelector("#delete-record-1"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", deleteButton);
        Actions clickOn = new Actions(driver);
        clickOn.click(deleteButton).perform();
        logMessage("User clicked on the 'Delete' button.");
    }

    public void clickOnEditButton(){
        WebElement editButton = driver.findElement(By.cssSelector("#edit-record-1"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", editButton);
        Actions clickOn = new Actions(driver);
        clickOn.click(editButton).perform();
        logMessage("User clicked on the 'Edit' button.");
    }

    public void verifyModal(){
        WebElement editModal = driver.findElement(By.cssSelector("#registration-form-modal"));
        String modalText = editModal.getText();
        assertThat(modalText).isEqualTo("Registration Form");
        logMessage("'Registration From' modal is displayed");
    }

    public void editFirstName() {
        WebElement modalFirstName = driver.findElement(By.cssSelector("#firstName"));
        modalFirstName.clear();
        modalFirstName.sendKeys(newFirstName);
        logMessage("User entered new 'First Name'.");
    }

    public void verifyNewName() {
        WebElement tableFirstName = driver.findElement(By.cssSelector(".rt-tr-group"));
        newFirstName = tableFirstName.getText();
        assertThat(newFirstName).contains("Not Cierra");
        logMessage("New 'First Name' is displayed in the table");
    }
}