package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements {
	
	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	//Verify whether the login page is displayed.
	public void verifyLoginPageIsDisplayed() {
		waitForElement(loginPageHeader);
		log("info", "Login page is displayed successfully.");
	}
	
	//Enter business email and password.
	public void enterBusinessEmailAndPassword(String email, String password) {
		waitForElement(businessEmailTextbox);
		enterText(businessEmailTextbox, email);
		enterText(passwordTextbox, password);
		log("info", "Entered business email and password successfully.");
	}
	
	//Click on login button.
	public void clickOnLoginButton() {
		waitForElement(loginButton);
		click(loginButton);
		log("info", "Clicked on login button successfully.");
	}
	
	// Verify whether the forgot password link is displayed.
	public void verifyForgotPasswordLinkIsDisplayed() {
		waitForElement(forgotPasswordLink);
		log("info", "Forgot password link is displayed successfully.");
	}
	
	//Verify sign-up link is displayed.
	public void verifySignUpLinkIsDisplayed() {
		waitForElement(signUpLink);
		log("info", "Sign-up link is displayed successfully.");
	}
	
	//Verify social media links displayed within the login page.
	public void verifySocialMediaLinksAreDisplayed() {
		waitForElement(linkedInIcon);
		waitForElement(googleIcon);
		waitForElement(facebookIcon);
		log("info", "Social media links are displayed successfully.");
	}
	
	//Click on sign-up link.
	public void clickOnSignUpLink() {
		waitForElement(signUpLink);
		click(signUpLink);
		log("info", "Clicked on sign-up link successfully.");
	}
	
	//Click on forgot password link.
	public void clickOnForgotPasswordLink() {
		waitForElement(forgotPasswordLink);
		click(forgotPasswordLink);
		log("info", "Clicked on forgot password link successfully.");
	}
	
	//Verify whether reset password confirmation is displayed
	public void verifyResetPasswordConfirmationIsDisplayed() {
		waitForElement(resetPasswordConfirmation);
		log("info", "Reset password confirmation is displayed successfully.");
	}


}
