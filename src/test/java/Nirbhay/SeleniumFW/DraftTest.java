package Nirbhay.SeleniumFW;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Nirbhay.Commoncomponents.BaseTest;
import NirbhaySelenium.pageobjects.Landing_Page;
import NirbhaySelenium.pageobjects.OrderPage;
import NirbhaySelenium.pageobjects.PaymentScreen;
import NirbhaySelenium.pageobjects.ProductPage;
import NirbhaySelenium.pageobjects.ThankYouScreen;
import NirbhaySelenium.pageobjects.productCatalouge;


public class DraftTest extends BaseTest {

	@Test(dataProvider ="getData", groups= {"PurchaseOrder"})
	
	public void SubmitOrder(HashMap<String,String> input ) throws InterruptedException, IOException
	{
		//String productname = "ZARA COAT 3";
		String CountryName = "Indi";
		productCatalouge prodcat =landingPage.loggingapp(input.get("email"), input.get("Password"));
		prodcat.addToCart(input.get("productname"));
		Thread.sleep(3000);
		ProductPage prodpg  = prodcat.SelectCart();
		
		Thread.sleep(3000);
		
		Boolean match = prodpg.CheckProductMatch(input.get("productname"));
		Assert.assertTrue(match);
		PaymentScreen Placeorder = prodpg.movetoCheckout();
		ThankYouScreen ThankYouMess = Placeorder.placeOrderOnPaymentPage(CountryName);
		String confirmMessage =  ThankYouMess.getMessageText();
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Thankyou for the order.')]")));
//		String confirmMessage = driver.findElement(By.xpath("//h1[contains(text(),'Thankyou for the order.')]")).getText();
	//	System.out.println(confirmMessage);
		//
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		closingBrowser();
		
	}


		@Test(dependsOnMethods = {"SubmitOrder"})
		public void OrderPageTest() throws InterruptedException
		{
			String productname2 = "zara coat 3";
			productCatalouge prodcat =landingPage.loggingapp("Abcd123@gmail.com", "Selenium@123");
			OrderPage ordpg = prodcat.Selectorder();
			Thread.sleep(3000);
			Boolean match = ordpg.CheckOrderMatch(productname2);
			Assert.assertTrue(match);
			
		}
		
		
		@DataProvider
		public Object[][] getData() throws IOException
		{
			HashMap<String,String> map = new HashMap<String,String>();
			map.put("email", "Abcd123@gmail.com");
			map.put("Password", "Selenium@123");
			map.put("productname", "ZARA COAT 3");
			
			HashMap<String,String> map1 = new HashMap<String,String>();
			map1.put("email", "Efgh123@gmail.com");
			map1.put("Password", "Selenium@123");
			map1.put("productname", "ADIDAS ORIGINAL");
			
			
			List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\Nirbhay\\Data\\Data.json");
			return new Object [] [] {{data.get(0)} , {data.get(1)}};
		}
		
}
	
	
	




