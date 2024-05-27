package NirbhaySelenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commonmethods.Abstractclass.AbstractClass;
//driver.findElement(By.cssSelector(".totalRow button")).click();

public class OrderPage extends AbstractClass {
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> Orderproducts;
	

	
	public Boolean CheckOrderMatch(String productname)
	{
		Boolean Match = Orderproducts.stream().anyMatch(Orderproduct->Orderproduct.getText().equalsIgnoreCase(productname));
		
		//String Match = Orderproducts.stream().filter(Orderproduct->Orderproduct.getText()).forEach(Orderproduct->System.out.println(Orderproduct));
		return Match;
	}
	

}
