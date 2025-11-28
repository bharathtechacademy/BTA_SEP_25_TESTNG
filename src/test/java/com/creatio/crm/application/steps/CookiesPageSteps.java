package com.creatio.crm.application.steps;

import org.testng.Assert;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements {
	
	public void verifyCookiesPopUpDisplayed() {
		Assert.assertTrue(isElementDisplayed(cookiesPopupHeader));
	}
	
	public void acceptCookies() {
		click(allowAllCookiesBtn);
	}

}
