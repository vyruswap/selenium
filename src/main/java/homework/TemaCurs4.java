package homework;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import utils.BaseTest;

public class TemaCurs4 extends BaseTest {

	@Test
	public void searchStore() throws InterruptedException {

		WebElement searchButton = driver.findElement(By.cssSelector("button[title='Open search']"));
		searchButton.click();
		
		WebElement searchInput = driver.findElement(By.cssSelector("input[class='search_field']"));
		WebElement searchSubmit = driver.findElement(By.cssSelector("button.search_submit"));
		searchInput.sendKeys("The story about me");
		searchSubmit.click();
		
		WebElement loadMore = driver.findElement(By.cssSelector("#viewmore"));
		loadMore.click();
		Thread.sleep(3000);
		
		WebElement clickOnTheBook = driver.findElement(By.cssSelector("div[data-title=\"The story about me\"]"));
		clickOnTheBook.click();
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/the-story-about-me/");
		
		WebElement addToCart = driver.findElement(By.cssSelector("button[name='add-to-cart']"));
		addToCart.click();
		
		WebElement addToCartAlert = driver.findElement(By.cssSelector(".woocommerce-message"));
		assertTrue(addToCartAlert.getText().contains("“The story about me” has been added to your cart."));
		
		WebElement viewCart = driver.findElement(By.cssSelector("div.woocommerce-message .wc-forward"));
		viewCart.click();
		
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/cart/");

	}

	@Test
	public void updateAndCheckOut() {
		
		WebElement quantity = driver.findElement(By.cssSelector("input[title='Qty']"));
		quantity.clear();
		quantity.sendKeys("2");
		
		WebElement updateCart = driver.findElement(By.cssSelector("button[name='update_cart']"));
		updateCart.click();
		
		WebElement cartUpdate = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
		assertTrue(cartUpdate.getText().contains("Cart updated."));
		
		WebElement checkout = driver.findElement(By.cssSelector("a[class*='checkout-button']"));
		checkout.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/checkout/");
		
		assertTrue(driver.findElement(By.cssSelector("div[class='woocommerce-billing-fields'] h3")).getText().contentEquals("Billing details"));
		assertTrue(driver.findElement(By.cssSelector("div[class='woocommerce-additional-fields'] h3")).getText().contentEquals("Additional information"));
			
	}

}