package com.test.StepDefs;

import com.test.classes.TestElements;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
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
        testElements.pageUrl("https://demoqa.com/buttons");

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


    @Given("^The user is navigated to Text Box page$")
    public void the_user_is_navigated_to_text_box_page(){
        testElements.pageUrl("https://demoqa.com/text-box");
    }


    @When("^The user enters data to the given fields$")
    public void the_user_enters_data_to_the_given_fields(){
        testElements.sendTextToTextBox();
    }

    @And("^Clicks on 'Submit' button$")
    public void clicks_on_submit_button(){
        testElements.sendTextSubmitButton();
    }

    @Then("^The user is able to see the entered data under the input fields$")
    public void the_user_is_able_to_see_the_entered_data_under_the_input_fields(){
        testElements.verifySentText();
    }

    @Given("^The user is navigated to Radio Buttons page$")
    public void the_user_is_navigated_to_radio_buttons_page() {
        testElements.pageUrl("https://demoqa.com/radio-button");
    }

    @When("^The user clicks on 'Yes' radio button$")
    public void the_user_clicks_on_yes_radio_button(){
        testElements.clickRadioButtonYes();
    }

    @Then("^The user sees an applied verifying message$")
    public void the_user_sees_an_applied_verifying_message(){
        testElements.yesButtonMessage();

    }

    @When("^The user clicks on 'Impressive' radio button$")
    public void the_user_clicks_on_impressive_radio_button(){
        testElements.clickRadioButtonImpressive();
    }

    @Then("^The user sees another applied verifying message$")
    public void the_user_sees_another_applied_verifying_message(){
        testElements.impressiveButtonMessage();
    }

    @Given("^The user is navigated to Web Tables page$")
    public void the_user_is_navigated_to_web_tables_page(){
        testElements.pageUrl("https://demoqa.com/webtables");
    }
}