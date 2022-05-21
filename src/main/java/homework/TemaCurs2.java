package homework;

import org.testng.annotations.*;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import utils.BaseTest;

public class TemaCurs2 extends BaseTest {
	
	@Test
	public void findElements() throws InterruptedException {
		
		WebElement loginButton = driver.findElement(By.cssSelector("a[class*='popup_link popup_login_link icon-user inited']"));
		assertEquals(loginButton.isDisplayed(), true);
		WebElement loginWindow = driver.findElement(By.id("log"));
		assertEquals(loginWindow.isDisplayed(), false);
		WebElement passwordField = driver.findElement(By.id("password"));
		assertEquals(passwordField.isDisplayed(), false);

		loginButton.click();
		Thread.sleep(3000);
		
		loginWindow = driver.findElement(By.id("log"));
		assertEquals(loginWindow.isDisplayed(), true);
		passwordField = driver.findElement(By.id("password"));
		assertEquals(passwordField.isDisplayed(), true);
	}

}
