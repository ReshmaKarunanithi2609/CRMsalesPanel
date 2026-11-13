package Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Feature",
		glue = { "StepDefinition", "hooks" },
		plugin = { "pretty",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:test-output/cucumber-report.html" },
		
		monochrome = false)
public class Testrunner {

	
	
	}


