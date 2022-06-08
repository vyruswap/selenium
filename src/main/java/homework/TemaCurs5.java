package homework;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import static org.testng.Assert.*;
import utils.BaseTest;

public class TemaCurs5 extends BaseTest {
	

	@Test
	public void tema5() throws InterruptedException {

		WebElement book = driver.findElement(By.xpath("//a[@href='the-forest']"));
		book.click();

		WebElement reviews = driver.findElement(By.xpath("//a[@href='#tab-reviews']"));
		reviews.click();

		WebElement checkbox = driver.findElement(By.xpath("//input[@id='wp-comment-cookies-consent']"));
		assertFalse(checkbox.isSelected());

		WebElement comment = driver.findElement(By.xpath("//textarea[@id='comment']"));
		String review = "the best book";
		comment.sendKeys(review);

		WebElement name = driver.findElement(By.xpath("//input[@name='author']"));
		name.sendKeys("anonim");

		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("user" + Math.random() + "@example.com");

		checkbox.click();
		assertTrue(checkbox.isSelected());
		
		WebElement rating = driver.findElement(By.xpath("//a[@class='star-5']"));
		rating.click();

		WebElement submit = driver.findElement(By.xpath("//input[@class='submit']"));
		submit.click();

		WebElement description = driver.findElement(By.xpath("//div[@class='description']"));

		if (description.getText().equals(review)) {
			WebElement approval = driver
					.findElement(By.xpath("//em[@class='woocommerce-review__awaiting-approval']"));
			assertEquals(approval.getText(), "Your review is awaiting approval");
		}

	}

}