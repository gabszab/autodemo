package com.test.StepDefs;

import com.test.handlepageobjects.Clicking;
import com.test.handlepageobjects.Navigation;
import com.test.handlepageobjects.Visibility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


;

public class Step_Def_ElementsFeatures {

        WebDriver driver;

        @Before
        public void setUp() {

                System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabor.szabo\\Downloads\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver();
        }

        @After
        public void tearDown() {
                if (driver != null) {
                        driver.quit();
                }
        }


        Navigation navigation = new Navigation(driver, "Buttons", "specFilePath");
        Visibility visibility = new Visibility(driver, "Buttons", "specFilePath");
        Clicking clicking = new Clicking(driver, "Buttons", "specFilePath");

        @Given("The user is navigated to {string} page")
        public void theUserIsNavigatedToPage(String pageName) {
        driver.get("https://demoqa.com/buttons");
        navigation.verifyPageURL("https://demoqa.com/buttons");





        }




        @And("Clicks on {string} button")
        public void clicksOnButton (String elementToken){
                clicking.clickOnClickMeButton("clickMe_button");
        }


        @Then("{string} text message should be displayed")
        public void textMessageShouldBeDisplayed() {
        }
}