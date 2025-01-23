package com.test.classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class TestBase {

    WebDriver driver;




    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        System.out.println("setupTest() metódus lefutott");
    }

    @After
    public void tearDown() {
        driver.quit();
    }




    public void navigateToUrl(String url) {
        driver.get(url);

    }

    public void logMessage(String message) {
        System.out.println(message);

    }



}