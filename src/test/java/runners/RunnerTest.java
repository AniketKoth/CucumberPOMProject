package runners;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"./src/test/resources/features/"},
		glue = {"stepdefinition", "AppHooks"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
)

public class RunnerTest extends AbstractTestNGCucumberTests{
	
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}

}
