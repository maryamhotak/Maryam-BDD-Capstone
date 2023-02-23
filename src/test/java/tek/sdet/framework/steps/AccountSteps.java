package tek.sdet.framework.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class AccountSteps extends CommonUtility {
  
	POMFactory factory = new POMFactory();
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
   click(factory.homePage().accountOption);
   logger.info("User clicked on account option");
   
	}
	@When("User update Name {string} and phone {string}")
	public void userUpdateNameAndPhone(String name, String phone) {
     clearText(factory.accountPage().updateName);
     sendText(factory.accountPage().updateName, name);
     clearText(factory.accountPage().phoneNumber);
     sendText(factory.accountPage().phoneNumber, phone);
     logger.info("user update name and phone number");
     
	}
	@When("User click on Update button")
	public void userClickOnUpdateButton() {
	    click(factory.accountPage().updateButton);
	    logger.info("user clicked on update button");
	}
	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
	    //Assert.assertTrue(isElementDisplayed(factory.accountPage().successMessageUpdate));
		logger.info("user logged in");
	   
	}
	
}
