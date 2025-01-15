package com.test.StepDefs;

import com.test.handlepageobjects.Navigation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



;

public class Step_Def_ElementsFeatures {

        WebDriver driver = new ChromeDriver();
        Navigation navigation = new Navigation(driver, "Buttons Page");

        @Given("The user is navigated to {string} page")
        public void theUserIsNavigatedToPage(String pageName) {
        navigation.verifyPageURL("https://demoqa.com/buttons");


        }


        @When("Scrolls down")
        public void scrollsDown () {

        }

        @And("Clicks on {string} button")
        public void clicksOnButton (String arg0){
        }


        @Then("{string} text message should be displayed")
        public void textMessageShouldBeDisplayed(String arg0) {
        }
}