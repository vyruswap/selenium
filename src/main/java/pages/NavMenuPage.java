package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavMenuPage {
	
	public WebDriver driver;
	
	public NavMenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public By loginLink = By.linkText("Login");
	public By homeLink = By.linkText("HOME");
	public By shopLink = By.linkText("BOOKS");
	public By contactsLink = By.linkText("CONTACTS");
	
	public By loggedUsername = By.cssSelector("span[class='user_name']");
	
	//metoda 1
	public void navigateToLogin() {
		driver.findElement(loginLink).click();
	}
	
	public void navigateToHome() {
		driver.findElement(homeLink).click();
	}
	//metoda 2
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}
	
	//metoda 3
	public LoginPage navToLogin() {
		driver.findElement(loginLink).click();
		return new LoginPage(driver);
	}
	
	public ShopPage navToShop() {
		driver.findElement(shopLink).click();
		return new ShopPage(driver);
	}
	
	public ContactsPage navToContacts() {
		
		driver.findElement(contactsLink).click();
		return new ContactsPage(driver);
	}
	
	
	
	
	public String getLoggedUser() {
		
		return driver.findElement(loggedUsername).getText();
	}
	

}
