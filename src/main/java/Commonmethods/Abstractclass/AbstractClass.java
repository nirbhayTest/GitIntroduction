package Commonmethods.Abstractclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import NirbhaySelenium.pageobjects.OrderPage;
import NirbhaySelenium.pageobjects.ProductPage;

public class AbstractClass {
	
	public WebDriver driver;
	public OrderPage ordpg;
	
	
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrderButton;
	
	public AbstractClass(WebDriver driver) {
		this.driver=driver;
	}

	public void waitForElementsToAppear(By Findby)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Findby));
	}
	
	public void waitForWebElementsToAppear(WebElement Webby)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(Webby));
	}
	
	public void waitForElementsToDisappear(WebElement Elem)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(Elem));
	}
	
	public void waitForElementsToClickable(By Clickby)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(Clickby));
	}
	
	public OrderPage Selectorder()
	{
		//waitForElementsToClickable(Clickcart);
		OrderButton.click();
		ordpg = new OrderPage(driver);
		return ordpg;
	}
	
	
	


}
