package com.creatio.crm.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.creatio.crm.framework.web.commons.WebCommons;

public class LoginPageElements extends WebCommons {
	
	public WebElement loginPageHeader = driver.findElement(By.xpath("//h2[text()='Sign in to your account']"));
	
	public WebElement usernameInputField = driver.findElement(By.id("username"));
	
	public WebElement passwordInputField = driver.findElement(By.id("password"));
	
	public WebElement signInBtn = driver.findElement(By.id("loginButton"));

}
