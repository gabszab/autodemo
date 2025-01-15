package com.test.runners;



import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.test.StepDefs",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests{
}
