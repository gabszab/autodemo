package com.test.basicmethods;

import io.cucumber.java.en.Given;


public class Step_Def_ElementsFeatures extends TestElements {




        @Given("^The user is navigated to Buttons page$")
        public void the_user_is_navigated_to_buttons_page() {
                pageUrl();
        }




}