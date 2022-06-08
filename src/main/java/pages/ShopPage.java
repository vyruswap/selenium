package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShopPage {
	
	public WebDriver driver;
	public WebElement dropdown;
	public Select selectDropwdown;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;	
	}
	
	public By oderDropDown = By.name("orderby");
	
	
	public void filterByValue(String value) {
		dropdown = driver.findElement(oderDropDown);
		selectDropwdown =  new Select(dropdown);
		selectDropwdown.selectByValue(value);	
	}
	
	public void filterByIndex(int index) {
		dropdown = driver.findElement(oderDropDown);
		selectDropwdown =  new Select(dropdown);
		selectDropwdown.selectByIndex(index);	
	}
	
	public void filterByVisibleText(String visibleText) {
		dropdown = driver.findElement(oderDropDown);
		selectDropwdown =  new Select(dropdown);
		selectDropwdown.selectByVisibleText(visibleText);
	}
	
	
	public String getCurrentSelectedOption() {
		dropdown = driver.findElement(oderDropDown);
		selectDropwdown =  new Select(dropdown);
		return selectDropwdown.getFirstSelectedOption().getText();
		
	}
	
	

}
