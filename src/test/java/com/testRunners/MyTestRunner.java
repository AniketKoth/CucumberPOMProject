package com.testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/com/features/LoginPage.feature"},
		glue = {"stepdefinition", "AppHooks"},
		plugin = {"pretty"}
		
)

public class MyTestRunner {

}
