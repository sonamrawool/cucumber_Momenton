package stepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reusableFunctions.reusableFunctions;


public class stepdefclass extends reusableFunctions{

	//reusableFunctions ReusableFunctions = new reusableFunctions();	

	@Given("^user  is on Homepage url \"([^\"]*)\"$")
	public void user_is_on_Homepage_url(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    homePage(url);
	}


	@When("^user is able to Login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_is_able_to_Login_with_username_and_password(String username, String password) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		login(username, password);    
	}

	@Then("^user is able to place order$")
	public void user_is_able_to_place_order() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		placeOrder();

	}

	@Then("^user is able to update order$")
	public void user_is_able_to_update_order() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		updateOrder();

	}

	@Then("^user is able to delete order$")
	public void user_is_able_to_delete_order() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		deleteOrder();

	}

	@Then("^user is able to logout$")
	public void user_is_able_to_logout() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		logOut();
		ScreenshotToPDf();

	}
	
	@Given("^Set testcase name to \"([^\"]*)\"$")
	public void set_testcase_name_to(String testcase) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 
		 TestcaseName = testcase ;
	}

}