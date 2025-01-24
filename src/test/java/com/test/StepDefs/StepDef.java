package com.test.StepDefs;

import com.test.classes.TestBase;
import com.test.classes.TestElements;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
        System.out.println("random blah blah");
        testElements.pageUrl();
        /*testElements.pageUrl();*/
    }


    @Then("^The user double clicks on button$")
    public void the_user_double_clicks_on_button() {
        testElements.doubleClickButton();
    }
}