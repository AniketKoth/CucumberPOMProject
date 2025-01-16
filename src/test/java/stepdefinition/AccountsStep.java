package stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsStep {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;

	@Given("user has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable dataTable) {

		List<Map<String, String>> credList = dataTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver()
				.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountPageTitle();
		System.out.println("Account page title is:"+title);

	}

	@Then("user gets the accounts section")
	public void user_gets_the_accounts_section(DataTable sectiontable) {
		List<String> sectionList = sectiontable.asList();
		System.out.println("Expected List:" + sectionList);
		
		List<String> actsectionList = accountsPage.getAccountSectionList();
		System.out.println("Actual List:"+ actsectionList);
		
		Assert.assertTrue(sectionList.containsAll(actsectionList));

	}

	@Then("user section count is {int}")
	public void user_section_count_is(Integer count) {
		int actcount = accountsPage.getAccountsListCount();
		Assert.assertTrue(actcount == count);

	}
}
