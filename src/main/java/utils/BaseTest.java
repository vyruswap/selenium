package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;

import pages.NavMenuPage;

public class BaseTest {
	
	public WebDriver driver;
	public JavascriptExecutor jseExecutor; 
	public NavMenuPage navMenu;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		//driver.get("https://the-internet.herokuapp.com/login");
		driver.get("https://keybooks.ro/");
		jseExecutor =  (JavascriptExecutor)driver;
		navMenu =  new NavMenuPage(driver);
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	@AfterMethod
	public void recordFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus() ) {
			
			TakesScreenshot poza = (TakesScreenshot)driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			
			try {
				Files.copy(picture, new File("screenshots/"+ result.getName()+"__"+timeStamp +".png"));
				System.out.println("Picture saved");
			} catch (IOException e) {
				System.out.println("Picture could not be saved");
				e.printStackTrace();
			}		
		}	
	}
	
	

}
