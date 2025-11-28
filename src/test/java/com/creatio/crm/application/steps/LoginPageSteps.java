package com.creatio.crm.application.steps;

import org.testng.Assert;

import com.creatio.crm.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements {
	
	public void verifyLoginPageDisplayed() {
		Assert.assertTrue(isElementDisplayed(loginPageHeader));		
	}
	
	public void enterCredentials(String username, String password) {
		enterText(usernameInputField, username);
		enterText(passwordInputField, password);
	}
	
	public void clickSignInButton() {
		click(signInBtn);
	}

}
