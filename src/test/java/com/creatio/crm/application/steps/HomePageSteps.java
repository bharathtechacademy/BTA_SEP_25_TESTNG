package com.creatio.crm.application.steps;

import com.creatio.crm.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements{
	
	public void verifyHomePageDisplayed() {
		isElementDisplayed(homePageHeader);
	}

}
