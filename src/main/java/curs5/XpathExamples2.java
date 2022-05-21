package curs5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExamples2 extends BaseTest{
	
	@Test
	public void xpathExample1() throws InterruptedException {
		
		//parent
		WebElement popupLink = driver.findElement(By.xpath("//a[contains(@class, 'popup_link')]/parent::li[@class='menu_user_login']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", popupLink);
		popupLink.click();
		
		Thread.sleep(3000);
		

		
		//child
		//form[contains(@class, 'popup_form')]/child::div[contains(@class, 'login_field')]/child::input[@id='log']		
		WebElement userField =  driver.findElement(By.xpath("//form[contains(@class, 'popup_form')]/child::div[contains(@class, 'login_field')]/child::input[@id='log']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", userField);
		userField.sendKeys("TestUser");
		Thread.sleep(3000);

		//descendant
		//  //form[contains(@class, 'popup_form')]/descendant::input[@id='password']
		WebElement passField =  driver.findElement(By.xpath(" //form[contains(@class, 'popup_form')]/descendant::input[@id='password']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", passField);
		passField.sendKeys("12345@67890");
		Thread.sleep(3000);
		
		
	}

}
