package NirbhaySelenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commonmethods.Abstractclass.AbstractClass;
//driver.findElement(By.cssSelector(".totalRow button")).click();

public class ProductPage extends AbstractClass {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement CheckoutButton;
	
	public Boolean CheckProductMatch(String productname)
	{
		Boolean Match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equals(productname));
		return Match;
	}
	
	public PaymentScreen movetoCheckout()
	{
		CheckoutButton.click();
		PaymentScreen Placeorder = new PaymentScreen(driver);
		return Placeorder;
		
	}

}
