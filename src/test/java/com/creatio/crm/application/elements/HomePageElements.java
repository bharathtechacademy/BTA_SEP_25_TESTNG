package com.creatio.crm.application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.creatio.crm.framework.web.commons.WebCommons;

public class HomePageElements extends WebCommons {
	
	public WebElement homePageHeader = driver.findElement(By.xpath("//h1[text()='Welcome to Creatio']"));

}
