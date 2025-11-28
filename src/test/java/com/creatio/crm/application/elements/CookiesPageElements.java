package com.creatio.crm.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class CookiesPageElements extends WebCommons{
	
	public WebElement cookiesPopupHeader = driver.findElement(By.xpath("//div[@class='cookie-popup__header']"));
	
	public WebElement allowAllCookiesBtn = driver.findElement(By.xpath("//button[@class='cookie-popup__accept-btn']"));
	
	public WebElement denyCookiesBtn = driver.findElement(By.xpath("//button[@class='cookie-popup__deny-btn']"));
	
	@FindBy(xpath="//a[@class='cookie-popup__settings-link']")
	public WebElement cookiesPopupHeaderElement;

}
