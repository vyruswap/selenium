package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage {
	
	public WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//form elements
	public By inputName = By.cssSelector("input[name='your-name']");
	public By inputEmail = By.cssSelector("input[name='your-email']");
	public By inputSubject = By.cssSelector("input[name='your-s']");
	public By textareaMessage = By.cssSelector("textarea[name='your-message']");
	public By sendMessageButton = By.cssSelector("input[value='Send Message']");
	//sucess-warrning messages
	public By emptyFieldMessage = By.cssSelector("span[class='wpcf7-not-valid-tip']");
	public By messageSentText = By.cssSelector("div[class='wpcf7-response-output']");
	

	
	public void sendMessage(String name, String email, String subject, String message) {
		
		driver.findElement(inputName).sendKeys(name);
		driver.findElement(inputEmail).sendKeys(email);
		driver.findElement(inputSubject).sendKeys(subject);
		driver.findElement(textareaMessage).sendKeys(message);
		
		driver.findElement(sendMessageButton).click();

	}
	
	public boolean emptyFieldWarringMessage() {
		
		try {
			WebElement message =  driver.findElement(emptyFieldMessage);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElement(message, "The field is required."));//hardcoded text
			return true;
			
		}catch(NoSuchElementException e) {
			return false;
		}
		
		
	}
	
	public boolean returnMessageSentInfo(String texttoBePresent ) {
		try {
			WebElement message =  driver.findElement(messageSentText);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElement(message, texttoBePresent ));
			return true;
			
		}catch(NoSuchElementException e) {
			return false;
		}
		
		
	}
	
	
	
	
	
}
