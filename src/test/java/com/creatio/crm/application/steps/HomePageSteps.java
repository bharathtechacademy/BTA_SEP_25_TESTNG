package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements{
	
	public HomePageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	//Verify whether the landing page is displayed.
	public void verifyApplicationLandingPageIsDisplayed(){
		waitForElement(applicationHubLink);
		log("info","Application Landing page is displayed successfully.");
	}
	
	//Verify user profile icon is getting displayed
	public void verifyUserProfileIconIsDisplayed(){
		waitForElement(userProfileIcon);
		log("info","User profile icon is displayed successfully.");
	}
	
	//Click on user profile icon
	public void clickOnUserProfileIcon(){
		click(userProfileIcon);
		log("info","Clicked on user profile icon successfully.");
	}
	
	//Click on logout button
	public void clickOnLogoutButton(){
		waitForElement(logoutButton);
		click(logoutButton);
		log("info","Clicked on logout button successfully.");
	}
	
	


}
