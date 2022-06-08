package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By usernameField = By.id("log");
	public By passwordField = By.id("password");
	public By submitButton = By.cssSelector("input[class='submit_button']");
	
	//driver.findEelement(By.id("log"))
	//driver.findElement(usernameField)
	
	public void setUsername(String user) {
		driver.findElement(usernameField).sendKeys(user);
	}
	
	public void setPassword(String pass) {
		driver.findElement(passwordField).sendKeys(pass);
	}
	
	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}
	
	
	public void loginInApp(String user, String pass) {
		driver.findElement(usernameField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(submitButton).click();

	}
	

}
