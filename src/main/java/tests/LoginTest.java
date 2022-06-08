package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest{
	
	
	
	@Test(groups = "Login")
	public void loginTest() {
		//NavMenuPage navMenu = new NavMenuPage(driver);
		
		  //navMenu.navigateToLogin();
		  
		  //alta metoda de a face acelasi lucru navMenu.navigateTo(navMenu.homeLink);
		  
		 // LoginPage loginPage = new LoginPage(driver);
		 // loginPage.setUsername("TestUser"); 
		 // loginPage.setPassword("12345@67890");
		 // loginPage.clickSubmit(); 
		 // assertEquals(navMenu.getLoggedUser(), "Test User");
		 
		LoginPage loginPage = navMenu.navToLogin();
		loginPage.loginInApp("TestUser", "12345@67890");
		assertEquals(navMenu.getLoggedUser(), "Test User");

		
		
	}
	
	

}
