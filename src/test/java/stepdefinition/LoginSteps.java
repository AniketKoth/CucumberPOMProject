package stepdefinition;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;
	
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	    //System.out.println("Inside Given");
		
		DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	}

	@When("User gets the title of the Page")
	public void user_gets_the_title_of_the_Page() {
		//System.out.println("Inside When");

		title = loginPage.getLoginPageTitle();
		System.out.println(" Page title is:"+title);
	}

	@Then("Title is {string}")
	public void title_is(String expectedTitle) {
		//System.out.println("Title is : " +string);
		

		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		//System.out.println("Inside Forgot");
		Assert.assertTrue(loginPage.forgotPassLinkDisplayed());
	}
	
	@When("User enters email id as {string}")
	public void user_enters_email_id_as(String username) {
	   //System.out.println("Mail id is: "+string);
		
		loginPage.enterUsername(username);
		
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String password) {
		//System.out.println("password is: "+string);
		loginPage.enterPassword(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
	  //System.out.println("Clicked");
		loginPage.clickLogin();
	}

//	@Then("User gets the title of the Page")
//	public void user_gets_the_title_of_the_page() {
//	   // System.out.println("Done");
//	}
}
