package com.creatio.crm.application.tests;

import org.testng.annotations.Test;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;

public class ApplicationTest extends BaseTest {	
	
	public CookiesPageSteps cookiesPage = new CookiesPageSteps();
	public LoginPageSteps loginPage = new LoginPageSteps();
	public HomePageSteps homePage = new HomePageSteps();

	
	//Test Case 1: Verify application login functionality.
	@Test
	public void testLoginFunctionality() {
		cookiesPage.launchApplication();
		cookiesPage.verifyCookiesPopUpDisplayed();
		cookiesPage.acceptCookies();
		loginPage.verifyLoginPageDisplayed();
		loginPage.enterCredentials("testuser", "password123");
		loginPage.clickSignInButton();
		homePage.verifyHomePageDisplayed();
	}
	
	

}
