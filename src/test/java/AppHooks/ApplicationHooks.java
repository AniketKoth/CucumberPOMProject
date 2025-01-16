package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverfactory;
	private WebDriver driver;
	ConfigReader configReader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_properties();
		
	}
	
	@Before(order =1)
	public void launchBrowser() {
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(prop.getProperty("browser"));
		
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit(); 
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePth = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcePth, "image/png", screenShotName);
		}
	}
	
}
