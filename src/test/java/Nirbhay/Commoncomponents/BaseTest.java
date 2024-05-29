package Nirbhay.Commoncomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import NirbhaySelenium.pageobjects.Landing_Page;

public class BaseTest {
	
	public WebDriver driver;
	public Landing_Page landingPage;
	public WebDriver intializingDriver() throws IOException {
		
		
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\NirbhaySelenium\\resources\\Globaldata.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			//Firefox 
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "D:\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		return driver;
		
 
	}
	
	public String getscreenshot(String testname, WebDriver driver ) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testname+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testname+".png";
	}
	
	public List<HashMap<String, String>> getJsonData(String FilePath) throws IOException
	{
		
		String jsonContent = FileUtils.readFileToString(new File(FilePath),
				StandardCharsets.UTF_8);
	
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
			});
		return data;
	
	}
	
	@BeforeMethod(alwaysRun=true)
	public Landing_Page lauchweb() throws IOException
	{
		driver = intializingDriver();
		landingPage = new Landing_Page(driver);
		landingPage.GoTo();
		return landingPage;
	}
	@AfterMethod(alwaysRun=true)
	public void closingBrowser()
	{
		driver.quit();
	}
	
	
}
