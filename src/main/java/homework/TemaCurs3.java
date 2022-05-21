package homework;

import static org.testng.Assert.*;
import java.util.List;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import utils.BaseTest;

public class TemaCurs3 extends BaseTest {

	@Test
	public void findTheBook() throws InterruptedException {

		List<WebElement> list = driver.findElements(By.cssSelector("li[class*='sc_tabs_title'][aria-selected='true']"));

		for (WebElement menu : list) {
			menu.click();
			System.out.println("Clicked on menu: " + menu.getText());
			Thread.sleep(3000);
			WebElement theForestBook = driver.findElement(By.linkText("The forest"));
			assertEquals(theForestBook.isDisplayed(), true);

			if (theForestBook != null) {
				theForestBook.click();
				assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-forest/");
			}

		}

	}

}