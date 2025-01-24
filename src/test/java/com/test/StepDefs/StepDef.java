package com.test.StepDefs;

import com.test.classes.TestElements;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class StepDef {

    WebDriver driver;
    TestElements testElements;



    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        System.out.println("setupTest() method is running");

        testElements = new TestElements(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("^The user is navigated to Buttons page$")
    public void the_user_is_navigated_to_buttons_page(){
        testElements.pageUrl();

    }

    @When("^The user double clicks on corresponding button$")
    public void the_user_double_clicks_on_corresponding_button() {
        testElements.doubleClickButton();
    }

    @Then("^'You have done a double click' message is displayed$")
    public void you_have_done_a_double_click_message_is_displayed(){
        testElements.doubleClickMessage();
    }




    @When("^The user right clicks on corresponding button$")
    public void the_user_right_clicks_on_corresponding_button(){
        testElements.rightClickButton();
    }

    @Then("^'You have done a right click' message is displayed$")
    public void you_have_done_a_right_click_message_is_displayed(){
        testElements.rightClickMessage();
    }



    @When("^The user clicks on corresponding button$")
    public void the_user_clicks_on_corresponding_button(){
        testElements.clickButton();
    }

    @Then("^'You have done a dynamic click' message is displayed$")
    public void you_have_done_a_dynamic_click_message_is_displayed(){
        testElements.clickButtonMessage();
    }

}