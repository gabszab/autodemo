package com.test.handlepageobjects;

import io.cucumber.junit.CucumberOptions;


import org.openqa.selenium.WebDriver;


import static com.test.automation.handlepageobjects.ObjectFileReader.getPageTitleFromFile;
import static com.test.automation.handlepageobjects.automation.getpageobjects.ObjectFileReader.getTier;
import static com.test.automation.basicmethods.ConfigPropertyReader.getProperty;
import static com.test.basicmethods.YamlReader.getYamlValue;
import static com.test.basicmethods.SeleniumWait.waitForElementToBeClickable;
import static org.testng.Assert.assertTrue;


import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;




import java.io.FileInputStream;


import org.openqa.selenium.support.PageFactory;
import com.test.basicmethods.SeleniumWait;




public class ActionsUI {

    private static final String String = null;
    protected static WebDriver driver;
    protected SeleniumWait wait;
    private String pageName;


    protected String email, password, lastname, generatedemail, email1;
    static Response response, response_activatedUser;
    Response response_token;
    RequestSpecification resSpec;
    RequestSpecification resSpec_token;
    String generatedToken;
    FileInputStream fileInputStream;
    public static String guid;




    protected ActionsUI(WebDriver driver, String pageName) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.pageName = pageName;
        this.wait = new SeleniumWait(driver, Integer.parseInt(getProperty(
                "Config.properties", "timeout")));
    }

}