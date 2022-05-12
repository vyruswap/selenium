package curs3;

import static org.testng.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class LocatorsExample extends BaseTest {

	
	@Test(priority=0)
	public void tagNameLocator() {
		//JavascriptExecutor jseExecutor =  (JavascriptExecutor)driver;
		WebElement emText =  driver.findElement(By.tagName("em"));
		System.out.println("Text : " + emText.getText());
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", emText);
		assertEquals(emText.getText(), "Discover");	
	}
	
	@Test(priority =1)
	public void linkTextLocator() {
		// <a href="https://keybooks.ro/shop/" aria-current="page">Books</a>
		WebElement booksLink = driver.findElement(By.linkText("BOOKS"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", booksLink);
		booksLink.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");
			
	}
	@Test(priority = 2)
	public void partialLinkTextLocator() throws InterruptedException {
		Thread.sleep(2000);
		//<a href="https://keybooks.ro/shop/cooking-with-love/">Cooking with love</a>
		WebElement cookingBook =  driver.findElement(By.partialLinkText("Cooking"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", cookingBook);
		cookingBook.click();
		assertEquals(driver.getTitle(), "Cooking with love – Booklovers");	
	}
	
	@Test(priority =3)
	public void classNameLocator() {
		WebElement productPrice = driver.findElement(By.className("price")); 
		System.out.println(productPrice.getText());
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", productPrice);
		assertTrue(productPrice.getText().contains("20.55"));
		assertEquals(productPrice.getText(), "$20.55");	
		String price =  productPrice.getText().substring(2, 4);
		System.out.println(price);
				//$20.55
				//012345

	}
	
	@Test(priority = 4)
	public void idLocator () {
		//<li class="reviews_tab active" id="tab-title-reviews" role="tab" aria-controls="tab-reviews">
		WebElement tabReview = driver.findElement(By.id("tab-title-reviews"));
		tabReview.click();
		WebElement comment  =  driver.findElement(By.id("comment-6"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", comment);
		assertTrue(comment.isDisplayed());	
	}

	
	@Test(priority = 5)
	public void checkBoxTest() throws InterruptedException {
		//<input id="wp-comment-cookies-consent" name="wp-comment-cookies-consent" type="checkbox" value="yes" >
		WebElement checkbox =  driver.findElement(By.id("wp-comment-cookies-consent"));
		
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", checkbox);

		
		//jseExecutor.executeScript("arguments[0].setAttribute('disabled', '')", checkbox);
		Thread.sleep(4000);
		
		assertTrue(checkbox.isEnabled());// functioneaze pe input
		//Is the element currently enabled or not? 
		//This will generally return true for everything but disabled input elements.
		
		checkbox.click();
		assertTrue(checkbox.isSelected());//functioneaza doar pe type="checkbox"
		
	}
	
	@Test(priority = 6)
	public void xpathLocator() throws InterruptedException {
		WebElement commentField = driver.findElement(By.xpath("//textarea[@id='comment']"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", commentField);
		commentField.sendKeys("My comment");

	}
	@Test(priority = 7)
	public void nameLocator() throws InterruptedException {
		WebElement nameField =  driver.findElement(By.name("author"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", nameField);
		nameField.sendKeys("John Doe");
		Thread.sleep(4000);
		nameField.clear();
		Thread.sleep(4000);
		nameField.sendKeys("Johnny Bravo");
		Thread.sleep(4000);
	}
		
	//<input name="submit" type="submit" id="submit" class="submit" value="Submit">
	// name locator --> name="submit"
	// id locator --> id="submit"
	// className locator --> class="submit"
	//xpath --> //input[@type='submit']
	//cssSelector --> input[value='Submit']

	
	@Test(priority = 8)
	public void cssSelector() throws InterruptedException {
		WebElement emailField =  driver.findElement(By.cssSelector("input[type='email']"));
		emailField.sendKeys("johnny.bravo@disney.com");
		WebElement submitButton = driver.findElement(By.cssSelector("input[name='submit']"));
		submitButton.click();
		
		// Alerte JS
		Alert alertJs = driver.switchTo().alert();
		alertJs.accept();

		WebElement rating3Starts =  driver.findElement(By.cssSelector("a[class='star-3']"));
		rating3Starts.click();
		
		submitButton.click();
		
	}
	
	
	

}
