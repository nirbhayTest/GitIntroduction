package NirbhaySelenium.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commonmethods.Abstractclass.AbstractClass;

public class productCatalouge extends AbstractClass {

		WebDriver driver;
		
		public productCatalouge(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	//	driver.findElement(By.id("userPassword")).sendKeys("Selenium@123");
	//	driver.findElement(By.id("login")).click();
	//	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		@FindBy(css=".mb-3")
		List<WebElement> Products;
		
		@FindBy(css=".ng-animating")
		WebElement Spinner;
		
		@FindBy(css="[routerlink*='cart']")
		WebElement CartButton;
		
		
		By productsby = By.cssSelector(".mb-3");
		By AddToCart = By.cssSelector(".card-body button:last-of-type");
		By ToastMeessage = By.cssSelector("#toast-container");
		By Clickcart = By.cssSelector("[routerlink*='cart']");
		
		public List<WebElement> getList()
		{
			waitForElementsToAppear(productsby);
			return Products;
			
		}
		
		public WebElement getDesiredProduct(String productname)
		{
			WebElement Prod =	getList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
			return Prod;
		}
		
		
		public void addToCart(String productname)
		{
			WebElement Prod = getDesiredProduct(productname);
			Prod.findElement(AddToCart).click();
			waitForElementsToAppear(ToastMeessage);
		//	waitForElementsToDisappear(Spinner);
		}
		
		public ProductPage SelectCart()
		{
			//waitForElementsToClickable(Clickcart);
			CartButton.click();
			ProductPage prodpg = new ProductPage(driver);
			return prodpg;
		
			
		}
		
	
		

}
