package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = "src/test/java/features/", 
glue = "stepDefinitions",
tags = "@testcase3")
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
