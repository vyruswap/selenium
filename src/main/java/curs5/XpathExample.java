package curs5;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExample extends BaseTest {
	
	
	
	@Test
	public void xpathExample1() throws InterruptedException {
		
		
		//css --> li[class='menu_user_login']
		//xpath --> //li[@class='menu_user_login']
		
		WebElement loginMenu = driver.findElement(By.xpath("//li[@class='menu_user_login']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", loginMenu);
		loginMenu.click();
		Thread.sleep(2000);
		WebElement userField  =  driver.findElement(By.xpath("//input[@id='log' or @name='log']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", userField);
		userField.sendKeys("TestUser");
		Thread.sleep(2000);
		
		//WebElement passField =  driver.findElement(By.xpath("//input[@id='password'][@name='pwd']"));
		WebElement passField =  driver.findElement(By.xpath("//input[@id='password' and @name='pwd']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", passField);
		passField.sendKeys("12345@67890");
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='rememberme']"));
		checkBox.click();
		
		WebElement submitButton =  driver.findElement(By.xpath("//input[@class='submit_button']"));
		submitButton.click();
				
		WebElement userName =  driver.findElement(By.xpath("//span[@class='user_name']"));
		assertEquals(userName.getText(), "Test User");

	}
	
	@Test(priority=1)
	public void xpathExample2() throws InterruptedException {
		WebElement userName =  driver.findElement(By.xpath("//span[@class='user_name']"));
		userName.click();
		
		WebElement settingsLink = driver.findElement(By.xpath("//a[contains(text(), 'Settings')]"));
		settingsLink.click();
		
		////a[contains(text(), 'Settings')]
		
		WebElement recentOrdersLink = driver.findElement(By.xpath("//a[contains(text(), 'recent')]"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", recentOrdersLink);
		recentOrdersLink.click();
		Thread.sleep(2000);
		
		////th[contains(@class, 'woocommerce-orders-table__header' )]/span[contains(text(), 'Order')]
		//(//th[contains(@class, 'woocommerce-orders-table__header' )]/span)[1]
		
		WebElement orderTabelHeader = driver.findElement(By.xpath("//th[contains(@class, 'woocommerce-orders-table__header' )]/span[contains(text(), 'Order')]"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", orderTabelHeader);

		Thread.sleep(2000);

		WebElement statusTabelHeader = driver.findElement(By.xpath("(//th[contains(@class, 'woocommerce-orders-table__header' )]/span)[3]"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", statusTabelHeader);

		Thread.sleep(2000);

		//xpath --> //td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(), '1653')]
		//css   --> td[class*='woocommerce-orders-table__cell'][data-title='Order']>a[href*='1653']
		
		WebElement orderNr = 
				driver.findElement(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[contains(text(), '1653')]"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", orderNr);

		orderNr.click();
		Thread.sleep(2000);
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/account/view-order/1653/");

		
	}


}
