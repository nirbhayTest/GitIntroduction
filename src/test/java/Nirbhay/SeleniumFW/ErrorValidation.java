package Nirbhay.SeleniumFW;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Nirbhay.Commoncomponents.BaseTest;
import NirbhaySelenium.pageobjects.Landing_Page;
import NirbhaySelenium.pageobjects.PaymentScreen;
import NirbhaySelenium.pageobjects.ProductPage;
import NirbhaySelenium.pageobjects.ThankYouScreen;
import NirbhaySelenium.pageobjects.productCatalouge;


public class ErrorValidation extends BaseTest {

	@Test (groups = {"ErrorHandling"})
	
	public void ErrorValidation() throws InterruptedException, IOException
	{
		
		//<div class="ng-tns-c4-8 ng-star-inserted ng-trigger ng-trigger-flyInOut 
		//ngx-toastr toast-error" toast-component="" style="opacity: 1;" xpath="1">
		String productname = "ZARA COAT 3";
		String CountryName = "Indi";
		productCatalouge prodcat =landingPage.loggingapp("Abcd123@gmail.com", "Seleni@123");
		String Error = landingPage.getErrorMessage();
		Assert.assertEquals(Error, "Incorrect email password.");			
		
	}
	
	@Test
	
	public void ErrorValidationOnCart() throws InterruptedException, IOException
	{
		
		String productname = "ZARA COAT 3";
		String CountryName = "Indi";
		productCatalouge prodcat =landingPage.loggingapp("Abcd123@gmail.com", "Selenium@123");
		prodcat.addToCart(productname);
		Thread.sleep(3000);
		
		ProductPage prodpg  = prodcat.SelectCart();
		
		Thread.sleep(3000);
		
		Boolean match = prodpg.CheckProductMatch("ZARA COAT 33");
		Assert.assertFalse(match);		
		
	}
	

}





