package tek.sdet.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailHomeSteps extends CommonUtility{

	private POMFactory factory = new POMFactory();
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekSchoolLogo));
		logger.info("user is on retail website");
		logger.info("Actual Title " + actualTitle + " Equals " + "ExpectedTitle" + expectedTitle);
	}
	
	@When("User search for {string} product")
	public void userSearchForProduct(String productValue) {
		sendText(factory.homePage().searchBar, productValue);
		click(factory.homePage().searchButton);
		logger.info("user searched for product "+ productValue);
		
	}
	
	@Then("The product should be displayed")
	public void theProductShouldBeDisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().pokemanProductImage));
        logger.info("the Product is displayed on home page");
	}
	
		
		@When("User click on All section")
		public void userClickOnAllSection() {
		    click(factory.homePage().sideBarAllButton);
		    logger.info("User clicked on All Departments");
		}
		@Then("User below options are present in Shop by department sidebar")
		public void userBelowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
			List<List<String>> expectedSideBar =dataTable.asLists(String.class);
			List<WebElement> actualSideBar = factory.homePage().departments;
				for(int i=0; i<expectedSideBar.get(0).size(); i++) {
			Assert.assertEquals(actualSideBar.get(i).getText(),expectedSideBar.get(0).get(i) );
			 logger.info(actualSideBar.get(i).getText() +"is equal to "+ expectedSideBar.get(0).get(i));
				}
//			Assert.assertEquals(expectedSideBar.get(0).get(0), factory.homePage().electronic.getText());
//			Assert.assertEquals(expectedSideBar.get(0).get(1), factory.homePage().computer.getText());
//			Assert.assertEquals(expectedSideBar.get(0).get(2), factory.homePage().smartHome.getText());
//			Assert.assertEquals(expectedSideBar.get(0).get(3), factory.homePage().sport.getText());
//			Assert.assertEquals(expectedSideBar.get(0).get(4), factory.homePage().automative.getText());
//			logger.info("The actual value is equal expected ");
			}
		@When("User is on {string}")
		public void userIsOnDepartment(String department) {
		List<WebElement> sideBarOptions = factory.homePage().departments;
		for(WebElement option : sideBarOptions) {
			if(option.getText().equals(department)) {
				click(option);
			try {
				logger.info(option.getText()+"user was on all department");
			}catch(StaleElementReferenceException e){
					
			}
			break;
			}
		}
		}
		@Then("below options are present in department")
		public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		  List<List<String>> expectedDepartmentOptions = dataTable.asLists(String.class);
		  List<WebElement> actualDepartmentOptions = factory.homePage().departments;
		  for(int i= 0;i<expectedDepartmentOptions.get(0).size();i++) {
			  for(WebElement option : actualDepartmentOptions) {
				  if(option.getText().equals(expectedDepartmentOptions.get(0).get(i))) {
					  Assert.assertTrue(isElementDisplayed(option));
					  logger.info(option.getText() +" is present");
					  
				  }
			  }
			  
		  }
		}
		
		
		}
		
	
