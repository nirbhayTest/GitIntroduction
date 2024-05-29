package Nirbhay.Stepdefination;

import java.io.IOException;

import org.testng.Assert;

import Nirbhay.Commoncomponents.BaseTest;
import NirbhaySelenium.pageobjects.Landing_Page;
import NirbhaySelenium.pageobjects.PaymentScreen;
import NirbhaySelenium.pageobjects.ProductPage;
import NirbhaySelenium.pageobjects.ThankYouScreen;
import NirbhaySelenium.pageobjects.productCatalouge;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinationimpl extends BaseTest {
	
	public Landing_Page landingPage;
	public productCatalouge prodcat;
	public ProductPage prodpg;
	public ThankYouScreen ThankYouMess;
	//public String string2;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingPage = lauchweb();
	}
	
	@Given("^Logged in with (.+) and (.+)$")
	public void Logger_in_with_username_and_password(String username, String password)
	{
		prodcat =landingPage.loggingapp(username,password);
	}
	
	 
	 @When("^I add the product (.+) to Cart$")
	 public void I_add_the_product_to_Cart(String productName) throws InterruptedException
	 {
		 prodcat.addToCart(productName);
			Thread.sleep(3000);
	 }
	 
	 @And("^Checkout (.+) and submit the order by selecting (.+)$")
	 public void Checkout_and_submit_the_order(String productName, String countryName) throws InterruptedException
	 {
		 prodpg  = prodcat.SelectCart();
			
			Thread.sleep(3000);
			
			Boolean match = prodpg.CheckProductMatch(productName);
			Assert.assertTrue(match);
			PaymentScreen Placeorder = prodpg.movetoCheckout();
			ThankYouMess = Placeorder.placeOrderOnPaymentPage(countryName);
	 }
	 
	 @Then("{string} message is displayed in Confirmationpage")
	 public void THANKYOU_message_is_displayed_in_Confirmationpage(String string)
	 {
		 String confirmMessage =  ThankYouMess.getMessageText();
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
			closingBrowser();
	 }
	 
	 @Then("{string} message is displayed in ErrorPage")
	 public void Error_message_is_displayed_in_ErrorPage(String string)
	 {
		 String Error = landingPage.getErrorMessage();
			Assert.assertEquals(Error, string);
			closingBrowser();
	 }

}












