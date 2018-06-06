package stepDef;

import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingStepsDef {

	private int budget = 0;

	/*public ShoppingStepsDef() {*/

		/*Given("I have (\\d+) in my wallet$", (Integer money) -> budget = money);
		
		When("I buy .* with (\\d+)$", (Integer price) -> budget -= price);
		
		Then("I should have (\\d+) in my wallet$", (Integer finalBudget) -> 
        assertEquals(budget, finalBudget.intValue()));*/
	
	/*}*/
		
		@Given("^I have (\\d+) in my wallet$")
		public void i_have_in_my_wallet(int money){
			budget = money;
		}
		
		@When("^I buy milk with (\\d+)$")
		public void i_buy_milk_with(int price){
			budget -= price;
		}
		
		@Then("^I should have (\\d+) in my wallet$")
		public void i_should_have_in_my_wallet(int finalBudget){
			assertEquals(budget, finalBudget, "Pass the test");
		}
	
}
