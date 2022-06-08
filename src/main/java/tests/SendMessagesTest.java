package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ContactsPage;
import utils.BaseTest;
import utils.ScreenShots;

public class SendMessagesTest extends BaseTest {
	
	
	@Test
	public void sendMessageReturnsSucessMessage() {
		ContactsPage contactsPage = navMenu.navToContacts();
		contactsPage.sendMessage("Test", "Test@ceva.test", "Test subject", "Test message");
		assertTrue(contactsPage.returnMessageSentInfo("Thank you for your message. It has been sent."));	
	}
	
	@Test
	public void sendMessageWithoutNameReturnsFalse() {
		ContactsPage contactsPage = navMenu.navToContacts();
		try {
			contactsPage.sendMessage("", "Test@ceva.test", "Test subject", "Test message");

		}catch(Exception e) {
			
			ScreenShots shot =  new ScreenShots();
			shot.screenshot(driver);
		}
		
		assertTrue(contactsPage.emptyFieldWarringMessage());
		assertTrue(contactsPage.returnMessageSentInfo("One or more fields have an error. Please check and try again."));


	}
	@Test
	public void sendMessageWithoutMessageReturnsFalse() {
		ContactsPage contactsPage = navMenu.navToContacts();
		contactsPage.sendMessage("Test", "Test@ceva.test", "Test subject", "");
		assertTrue(contactsPage.emptyFieldWarringMessage());
		assertTrue(contactsPage.returnMessageSentInfo("One or more fields have an error. Please check and try again."));	

	}

}
