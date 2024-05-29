package NirbhaySelenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commonmethods.Abstractclass.AbstractClass;

public class PaymentScreen extends AbstractClass {
	
	WebDriver driver;
	
	public PaymentScreen(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By CountryBy = By.cssSelector(".ta-item");
	
	@FindBy(css="[placeholder = 'Select Country']")
	WebElement Country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement SelectCountry;
	
	@FindBy(css=".action__submit")
	WebElement PlaceOrder;
	
	public ThankYouScreen placeOrderOnPaymentPage(String CountryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(Country, CountryName).build().perform();
		waitForElementsToAppear(CountryBy);
		SelectCountry.click();
		a.scrollByAmount(0, 100).build().perform();
		PlaceOrder.click();
		ThankYouScreen ThankYouMess = new ThankYouScreen(driver);
		return ThankYouMess;
		
	}

}
