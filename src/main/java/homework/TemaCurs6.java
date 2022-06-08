package homework;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utils.BaseTest;

public class TemaCurs6 extends BaseTest{

	
	@Test
	public void tema6() throws InterruptedException {
		
		WebElement author = driver.findElement(By.linkText("SINGLE AUTHOR"));
		author.click();
//		WebDriverWait wait =  new WebDriver(driver, 10);
		Thread.sleep(5000);
		
		WebElement drama = driver.findElement(By.xpath("//div[contains(@class, 'sc_skills_count')]/child::div[@data-stop='95']"));
		assertTrue(drama.getText().contains("95%"));
		WebElement biography = driver.findElement(By.xpath("//div[contains(@class, 'sc_skills_count')]/child::div[@data-stop='75']"));
		assertTrue(biography.getText().contains("75%"));
		WebElement cookbooks = driver.findElement(By.xpath("//div[contains(@class, 'sc_skills_count')]/child::div[@data-stop='82']"));
		assertTrue(cookbooks.getText().contains("82%"));
	}
}