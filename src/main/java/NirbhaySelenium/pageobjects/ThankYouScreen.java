package NirbhaySelenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commonmethods.Abstractclass.AbstractClass;

public class ThankYouScreen extends AbstractClass {

WebDriver driver;
	
	public ThankYouScreen(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By MessageBy = By.xpath("//h1[contains(text(),'Thankyou for the order.')]");
	
	@FindBy(xpath="//h1[contains(text(),'Thankyou for the order.')]")
	WebElement confirmMessage;
	
	public String getMessageText()
	{
		waitForElementsToAppear(MessageBy);
		return confirmMessage.getText();
	}
	
}



