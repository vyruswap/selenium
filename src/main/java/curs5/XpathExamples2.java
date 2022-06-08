package curs5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class XpathExamples2 extends BaseTest{
	
	//@Test
	public void xpathExample1() throws InterruptedException {
		
		//parent
		WebElement popupLink = driver.findElement(By.xpath("//a[contains(@class, 'popup_link')]/parent::li[@class='menu_user_login']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", popupLink);
		Thread.sleep(3000);
		popupLink.click();
		
		
		//child
		//form[contains(@class, 'popup_form')]/child::div[contains(@class, 'login_field')]/child::input[@id='log']		
		WebElement userField =  driver.findElement(By.xpath("//form[contains(@class, 'popup_form')]/child::div[contains(@class, 'login_field')]/child::input[@id='log']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", userField);
		Thread.sleep(3000);
		userField.sendKeys("TestUser");

		//descendant
		//  //form[contains(@class, 'popup_form')]/descendant::input[@id='password']
		WebElement passField =  driver.findElement(By.xpath(" //form[contains(@class, 'popup_form')]/descendant::input[@id='password']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", passField);
		Thread.sleep(3000);
		passField.sendKeys("12345@67890");
		
		//folloiwng-sibling
		////div[contains(@class, 'login_field' )]/following-sibling::div[contains(@class, 'remember_field')]/input
		WebElement rememberMeBox =  driver.findElement(By.xpath("//div[contains(@class, 'login_field' )]/following-sibling::div[contains(@class, 'remember_field')]/input"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", rememberMeBox);
		Thread.sleep(3000);
		rememberMeBox.click();
		
		//preceding
		////form[contains(@class, 'login_form')]/preceding::input[@class='submit_button']
		WebElement submitButton =  driver.findElement(By.xpath("//form[contains(@class, 'login_form')]/preceding::input[@class='submit_button']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", submitButton);
		Thread.sleep(3000);
		submitButton.click();
		
	}
	
	@Test
	public void xpathExample2() throws InterruptedException {
		
		WebElement popupLink = driver.findElement(By.xpath("//a[contains(@class, 'popup_link')]/parent::li[@class='menu_user_login']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", popupLink);
		Thread.sleep(3000);
		popupLink.click();
		
		//ancestor 
		////input[contains(@class, 'submit_button')]/ancestor::form/div[contains(@class, 'login_field')]/input
		////input[contains(@class, 'submit_button')]/ancestor::form/child::div[contains(@class, 'password_field')]
		WebElement username = driver.findElement(By.xpath("//input[contains(@class, 'submit_button')]/ancestor::form/div[contains(@class, 'login_field')]/input"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", username);
		Thread.sleep(3000);
		username.sendKeys("TestUser");
		
		////input[contains(@class, 'submit_button')]/ancestor::form/child::div[contains(@class, 'password_field')]
		WebElement password = driver.findElement(By.xpath("//input[contains(@class, 'submit_button')]/ancestor::form/child::div[contains(@class, 'password_field')]/input"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", password);
		password.sendKeys("12345@67890");
		Thread.sleep(3000);

		////input[contains(@class, 'submit_button')]/ancestor::form/preceding::input[@id='rememberme']
		WebElement rememeberMe = driver.findElement(By.xpath("//input[contains(@class, 'submit_button')]/ancestor::form/preceding::input[@id='rememberme']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:orange; border:4px solid red;')", rememeberMe);
		rememeberMe.click();
		Thread.sleep(3000);
		
		
	}

}
