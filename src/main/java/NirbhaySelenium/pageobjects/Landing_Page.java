package NirbhaySelenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commonmethods.Abstractclass.AbstractClass;

public class Landing_Page extends AbstractClass {

		WebDriver driver;
		
		public Landing_Page(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	//	driver.findElement(By.id("userPassword")).sendKeys("Selenium@123");
	//	driver.findElement(By.id("login")).click();
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement PasswordEle;
		
		@FindBy(id="login")
		WebElement Submit;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
		public productCatalouge loggingapp(String Email, String Passowrd)
		{
			userEmail.sendKeys(Email);
			PasswordEle.sendKeys(Passowrd);
			Submit.click();
			productCatalouge prodcat = new productCatalouge(driver);
			return prodcat;
		}
		
		public String getErrorMessage()
		{
			waitForWebElementsToAppear(errorMessage);
			return errorMessage.getText();
		}
		
		public void GoTo()
		{
			driver.get("https://rahulshettyacademy.com/client/");
		}


}
