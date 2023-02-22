package com.cucumberpom.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\main\\java\\com\\cucumberpom\\features",
		glue = {"com\\cucumberpom\\stepDefinitions"},
		plugin= {"pretty","html:reports/test-output.html","json:reports/test-output.json","junit:reports/test-output.xml"},
		dryRun = false,
		monochrome = true
		//tags = "@Regression"
		//tags = "@End2End and @SmokeTest"
		//tags = "@End2End or @SmokeTest"
		)
public class TestRunner {

}
