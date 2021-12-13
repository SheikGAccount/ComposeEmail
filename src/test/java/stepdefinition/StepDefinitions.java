package stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.FrameworkBase;
import framework.StartUpClass;
import pageobject.ComposeEmailPage;
import pageobject.LoginPage;

public class StepDefinitions extends FrameworkBase {

	public StartUpClass startUpClass;
	public LoginPage loginPage;
	public ComposeEmailPage composeEmailPage;

	@Given("^User Launch the Chrome Browser and navigates to Gmail Login Page$")
	public void User_Launch_the_Chrome_Browser_and_navigates_to_Gmail_Login_Page() throws Throwable {
		startUpClass = initialize(StartUpClass.class);
		startUpClass.launchBrowser();
		loginPage = startUpClass.goToWebsite("https://www.gmail.com", LoginPage.class);
	}

	@When("^User enters Username \"([^\"]*)\" and Click Next$")
	public void User_enters_Username_and_Click_Next(String userName) throws Throwable {
		loginPage.setEmail(userName);
		loginPage.clickemailNext();
	}

	@When("^User enters Password \"([^\"]*)\" and Click Next$")
	public void User_enters_Password_and_Click_Next(String password) throws Throwable {
		loginPage.setPassword(password);
		loginPage.clickpswdNext();
	}

	@Then("^User successfully logged in Gmail account")
	public void User_successfully_logged_in_Gmail_account() throws Throwable {
		loginPage.verifyLoginSuccessful();
	}

	@When("^User navigates to Compose Mail Page$")
	public void User_navigates_to_Compose_Mail_Page() throws Throwable {
		composeEmailPage = loginPage.goToComposeEmailPage();
	}

	@When("^User Enters To Address as \"([^\"]*)\"$")
	public void User_Enters_To_Address_as(String emailTo) throws Throwable {
		composeEmailPage.setEmailTo(emailTo);
	}

	@When("^User Enters Subject as \"([^\"]*)\"$")
	public void User_Enters_Subject_as(String subject) throws Throwable {
		composeEmailPage.setSubject(subject);
	}

	@When("^User Enters the Email Body as \"([^\"]*)\"$")
	public void User_Enters_the_Email_Body_as(String emailBody) throws Throwable {
		composeEmailPage.setEmailBody(emailBody);
	}

	@When("^User Clicks Send$")
	public void User_Clicks_Send() throws Throwable {
		composeEmailPage.clickSend();
	}

	@Then("^Verify Email Sent$")
	public void Verify_Email_Sent() throws Throwable {
		composeEmailPage.verifyEmailSent(); 
	}

	@After
	public void teardown() {
		getDriver().manage().deleteAllCookies();
		getDriver().quit();
	}

}
