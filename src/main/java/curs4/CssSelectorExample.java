package curs4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class CssSelectorExample extends BaseTest{
	
	
	
	//@Test
	public void cssSelector1() {
		
		WebElement loginPopup =  driver.findElement(By.cssSelector("a[class*='popup_link']"));
		loginPopup.click();
		
		//and
		WebElement element =  driver.findElement(By.cssSelector("input[id='log']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", element);
		
		//jse.executeScript("arguments[0].setAttribute('name', 'log3')", element);
		
		WebElement usernameField =  driver.findElement(By.cssSelector("input[id='log'][type='text'][name='log']"));
		usernameField.sendKeys("TestUser");
		
		//or
		WebElement elementPass =  driver.findElement(By.cssSelector("input[id='password']"));
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", elementPass);
		jse.executeScript("arguments[0].setAttribute('name', 'pwd3')", elementPass);

		
		WebElement paswordField = driver.findElement(By.cssSelector("input[id='password'],[type='password'],[name='pwd']"));
		paswordField.sendKeys("12345@67890");
		
		
		WebElement submitButton =  driver.findElement(By.cssSelector("input[class='submit_button'],[type='submit'],[value='Login']"));
		submitButton.click();
		
	}
	
	
	@Test
	public void cssSelector2() throws InterruptedException {
		
		//contains
		WebElement bookTitle =  driver.findElement(By.cssSelector("h3[class*='sc_title_regular']"));
		System.out.println(bookTitle.getText());
		
		//contains word
		WebElement buttonDiscoverMore =  driver.findElement(By.cssSelector("a[class~='sc_button_style_filled']"));
		System.out.println(buttonDiscoverMore.getText());
		
		//starting with
		WebElement bookStartingWith = driver.findElement(By.cssSelector("a[href^='its']"));
		System.out.println(bookStartingWith.getText());
	
		//ends with
		WebElement bookEndingWith =  driver.findElement(By.cssSelector("a[href$='garden']"));
		System.out.println(bookEndingWith.getText());
		
		
		//not
		//li[class*='sc_tabs_title']:not([aria-selected='true'])
		//li[class*='sc_tabs_title']:not([class*='ui-state-active'])
		//li[class*='sc_tabs_title']:not(.ui-state-active)
		List<WebElement> menuTabs = driver.findElements(By.cssSelector("li[class*='sc_tabs_title']:not([aria-selected='true'])"));
		
		//menuTabs.get(2);
		//xpath : (//li[contains(@class, 'sc_tabs_title' )])[3]
		//css : li[class*='sc_tabs_title']:nth-child(3)
		
		for(WebElement elem : menuTabs) {
			Thread.sleep(3000);
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:4px solid red;')", elem);
			System.out.println(elem.getText());
		}
		
		//nth-child
		WebElement thirdMenuEntry =  driver.findElement(By.cssSelector("li[class*='sc_tabs_title']:nth-child(3)"));
		jseExecutor.executeScript("arguments[0].setAttribute('style', 'background:green; border:4px solid black;')", thirdMenuEntry);

		
	}
	
	

}
