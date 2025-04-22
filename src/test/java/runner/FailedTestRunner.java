package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failed_scenarios.text",
                 glue="Steps",
               
                		 monochrome = true, // Optional: Makes the console output more readable
                		 plugin = {
                			        "pretty", // This prints detailed information to the console  
                			        "html:target/cucumber-reports/html-report.html", // Generates an HTML report
                			        "json:target/cucumber-reports/cucumber.json", // Generates a JSON report
                			        "junit:target/cucumber-reports/cucumber.xml", // Generates a JUnit report
                			        
                			        })


public class FailedTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
