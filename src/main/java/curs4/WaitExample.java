package curs4;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.BaseTest;

public class WaitExample extends BaseTest{
	
	
	@Test
	public void testWait() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.tagName("button")).click();
		WebElement finish = driver.findElement(By.id("finish"));
	//	Thread.sleep(5000);
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.textToBePresentInElement(finish, "Hello World!"));
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(6))
				.pollingEvery(Duration.ofMillis(200))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.textToBePresentInElement(finish, "Hello World!"));
		
		
		assertEquals(finish.getText(), "Hello World!");
		
	}

}
