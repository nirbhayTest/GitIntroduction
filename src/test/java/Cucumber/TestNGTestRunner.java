package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber", glue="Nirbhay.Stepdefination",monochrome=true, tags="@Regression_cucumber" , plugin = {"html:target/reports.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
