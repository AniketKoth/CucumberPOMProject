package stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.ContactUsPage;
import com.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsStep {

	private ContactUsPage contactusPage = new ContactUsPage(DriverFactory.getDriver());
	
	@Given("User navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		
		DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=contact");
		contactusPage.getContactusPageTitle();
	   
	}

	@When("User fills the form with sheetname {string}  and rownnumber {int}")
	public void user_fills_the_form_with_sheetname_and_rownnumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader excelReader = new ExcelReader();
		 List<Map<String , String>> reader = excelReader.getData("/Users/aniketkothawade/eclipse-workspace/CucumberPOMPractice/src/main/java/com/testdata/Automation.xlsx", sheetName);
		 
		 String heading = reader.get(rowNumber).get("heading");
		 String email = reader.get(rowNumber).get("email");
		 String order = reader.get(rowNumber).get("orderref");
		 String message = reader.get(rowNumber).get("message");
		 
		 contactusPage.fillcontactForm(email, order, message, heading);
	
	}

	
	@When("User clicks on send button")
	public void user_clicks_on_send_button() {
		contactusPage.clickOnSendButton();

		
	}

	@Then("User gets successful message {string}")
	public void user_gets_successful_message(String exmsg) {
		
		String acmsg = contactusPage.successfulMessage();
		Assert.assertTrue(exmsg.equals(acmsg));
	   
	}
}
