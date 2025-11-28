package com.creatio.crm.application.tests;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;

public class BaseTest {
	
	public CookiesPageSteps cookiesPage = new CookiesPageSteps();
	public LoginPageSteps loginPage = new LoginPageSteps();
	public HomePageSteps homePage = new HomePageSteps();
	

}
