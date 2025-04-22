package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src\\test\\resources\\features",
    glue = "Steps",
    tags = "@all",
    monochrome = true,
    plugin = {
        "pretty",
        "html:target/cucumber-reports/html-report.html",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml",
        "rerun:target/failed_scenarios.text"
    }
)

//AbstractTestNGCucumberTests is a base class from the io.cucumber.testng package that integrates Cucumber with TestNG.
//It provides the necessary methods for running Cucumber features with TestNG.{

public class Regrunner extends AbstractTestNGCucumberTests {
   
    //@DataProvider annotation is a TestNG feature that provides data to the test methods.
    //It can be used to pass different sets of data to a single test method.
	
    //parallel is set to true, TestNG will run the test methods in parallel 
    //(i.e., each scenario from Cucumber will be executed in a different thread, improving the speed of test execution).
	@Override
	@DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();// super.scenarios() to call the original scenarios() method from the parent class (AbstractTestNGCucumberTests)
                                //to get the scenarios provided by Cucumber.
        //So, in Regrunner, you override the scenarios() method to apply parallel execution, but you still call 
        //the parent class's method using super.scenarios() to get the original list of scenarios. After that, you return the list as it is to TestNG,
        //which then handles the parallel execution as specified by the annotation.
    }
}
