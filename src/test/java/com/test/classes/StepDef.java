package com.test.classes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class StepDef {

    private final TestElements testElements = new TestElements();

        @Given("^The user is navigated to Buttons page$")
           public void the_user_is_navigated_to_buttons_page(){
                testElements.pageUrl();
        }


        @Then("^The user double clicks on button$")
            public void the_user_double_clicks_on_button() {
                testElements.doubleClickButton();
        }
}