package Nirbhay.SeleniumFW;

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

import NirbhaySelenium.pageobjects.Landing_Page;


public class SeleniumFramework {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		String productname = "ZARA COAT 3";
		driver.get("https://rahulshettyacademy.com/client/");
		Landing_Page landingPage = new Landing_Page(driver);
		driver.findElement(By.id("userEmail")).sendKeys("random123456@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Random@123456");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
	//	findElement(By.xpath("//button[text()=' Add To Cart']")
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));
		List<WebElement> Products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement Prod =	Products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		Prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[routerlink*='cart']")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		Thread.sleep(3000);
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean Match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equals(productname));
		Assert.assertTrue(Match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder = 'Select Country']")), "Indi").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
		
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		a.scrollByAmount(0, 100).build().perform();
	//	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Thankyou for the order.')]")));
		String confirmMessage = driver.findElement(By.xpath("//h1[contains(text(),'Thankyou for the order.')]")).getText();
	//	System.out.println(confirmMessage);
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		driver.quit();
				
		
	}

}





