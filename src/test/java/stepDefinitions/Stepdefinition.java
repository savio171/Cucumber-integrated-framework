package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

@RunWith(Cucumber.class)
public class Stepdefinition extends Base{


@Given("^Initialize the browser with chrome$")
public void initialize_the_browser_with_chrome() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver=initializeDriver();
}

@Given("^Navigate to \"([^\"]*)\" site$")
public void navigate_to_site(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.get(prop.getProperty(arg1));
}

@Given("^Click on login link in homepage and navigate to secure signin page$")
public void click_on_login_link_in_homepage_and_navigate_to_secure_signin_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	LandingPage l=new LandingPage(driver);
	l.getLogin();
	
	}

@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	LoginPage lp=new LoginPage(driver);
	lp.getEmail().sendKeys(arg1);
	lp.getPassword().sendKeys(arg2);
	//System.out.println(text);
		lp.submit().click();
}

@Then("^Verify that user is successfully logged in$")
public void verify_that_user_is_successfully_logged_in() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

}