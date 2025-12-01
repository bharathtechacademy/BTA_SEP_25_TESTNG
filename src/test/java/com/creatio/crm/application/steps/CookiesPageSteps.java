package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements {
	
	public CookiesPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	
	//Method to verify cookies popup is getting displayed.
	public void verifyCookiesPopupIsDisplayed() {
		waitForElement(cookiesHeader);
		log("info","Cookies popup is displayed successfully.");
	}
	
	//Verify Cookies Pop-up Content message.
	public void verifyCookiesPopupContentMessage(String expectedMessage) {
		waitForElement(cookiesContent);
		String actualMessage = getElementText(cookiesContent);
		Assert.assertEquals(actualMessage, expectedMessage, "Cookies popup content message does not match the expected message.");
		log("info","Cookies popup content message is verified successfully.");		
	}
	
	//Verify cookie pop-up logos.
	public void verifyCookiesPopupLogos() {
		waitForElement(creatioLogo);
		Assert.assertTrue(isElementDisplayed(creatioLogo), "Creatio logo is not displayed on the cookies popup.");
		waitForElement(cookieBotLogo);
		Assert.assertTrue(isElementDisplayed(cookieBotLogo), "Cookiebot logo is not displayed on the cookies popup.");
		log("info","Cookies popup logos are verified successfully.");
	}
	
	//Verify Cookie Selection buttons displayed on the Cookies popup.
	public void verifyCookieSelectionButtons() {
		waitForElement(allowAllButton);
		Assert.assertTrue(isElementDisplayed(allowAllButton), "Allow All button is not displayed on the cookies popup.");
		waitForElement(allowSelectionButton);
		Assert.assertTrue(isElementDisplayed(allowSelectionButton), "Allow Selection button is not displayed on the cookies popup.");
		waitForElement(denyButton);
		Assert.assertTrue(isElementDisplayed(denyButton), "Deny button is not displayed on the cookies popup.");
		log("info","Cookie selection buttons are verified successfully on the cookies popup.");
	}
	
	//Verify Cookie Preference Switch buttons displayed on the Cookies popup.
	public void verifyCookiePreferenceSwitchButtons() {
		waitForElement(necessarySwitchButton);
		Assert.assertTrue(isElementDisplayed(necessarySwitchButton), "Necessary switch button is not displayed on the cookies popup.");
		waitForElement(preferencesSwitchButton);
		Assert.assertTrue(isElementDisplayed(preferencesSwitchButton), "Preferences switch button is not displayed on the cookies popup.");
		waitForElement(statisticsSwitchButton);
		Assert.assertTrue(isElementDisplayed(statisticsSwitchButton), "Statistics switch button is not displayed on the cookies popup.");
		waitForElement(marketingSwitchButton);
		Assert.assertTrue(isElementDisplayed(marketingSwitchButton), "Marketing switch button is not displayed on the cookies popup.");
		log("info","Cookie preference switch buttons are verified successfully on the cookies popup.");
	}
	
	//Verify Show Details link on the Cookies popup.
	public void verifyShowDetailsLink() {
		waitForElement(showDetailsLink);
		Assert.assertTrue(isElementDisplayed(showDetailsLink), "Show Details link is not displayed on the cookies popup.");
		log("info","Show Details link is verified successfully on the cookies popup.");
	}
	
	//Click on Show Details link to expand the Cookies popup.
	public void clickOnShowDetailsLink() {
		waitForElement(showDetailsLink);
		click(showDetailsLink);
		log("info","Clicked on Show Details link successfully to expand the cookies popup.");
	}
	
	//Verify Cookies Pop-up expanded view is displayed.
	public void verifyCookiesPopupExpandedViewIsDisplayed() {
		waitForElement(cokkiesPopUpExpandedView);
		Assert.assertTrue(isElementDisplayed(cokkiesPopUpExpandedView), "Cookies popup expanded view is not displayed after clicking on Show Details link.");
		log("info","Cookies popup expanded view is displayed successfully after clicking on Show Details link.");
	}
	
	//Click on cookies selection buttons
	public void clickOnCookiesSelectionButton(String buttonName) {
		switch (buttonName.toLowerCase()) {
			case "allow all":
				waitForElement(allowAllButton);
				click(allowAllButton);
				log("info","Clicked on Allow All button successfully.");
				break;
			case "allow selection":
				waitForElement(allowSelectionButton);
				click(allowSelectionButton);
				log("info","Clicked on Allow Selection button successfully.");
				break;
			case "deny":
				waitForElement(denyButton);
				click(denyButton);
				log("info","Clicked on Deny button successfully.");
				break;
			default:
				log("error","Invalid button name provided: " + buttonName);
				throw new IllegalArgumentException("Invalid button name: " + buttonName);
		}
	}
	
	// Verify the cookies pop-up is disappeared from the page.
	public void verifyCookiesPopupIsDisappeared() {
		waitForElementToDisappear(cookiesHeader);
		log("info", "Cookies popup is disappeared from the page successfully.");
	}

}
