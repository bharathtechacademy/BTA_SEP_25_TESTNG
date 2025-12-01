package com.creatio.crm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.constants.Web;
import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.utilities.PropUtil;

public class WebCommons {
	
	/**
	 * This class will contain all the common methods related to web application automation by using Selenium.
	 * 
	 */
	
	public WebDriver driver = BasePage.getDriver();
	public Properties prop = PropUtil.readData("Config.properties");
	
	//Common method to launch the application and verify the title of the application.
	public void launchApplication() {
		driver.get(prop.getProperty("APP_URL"));
		String expectedTitle = prop.getProperty("APP_TITLE");
		String actualTitle = driver.getTitle();
		if(!actualTitle.equals(expectedTitle)) {
			Assert.fail("This is not the expected application page. Expected: " + expectedTitle + " but found: " + actualTitle);
		}
	}
	
	//Common method to scroll to the element.
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);		
	}
	
	//Common method to click on the element.
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}
	
	//Common method to click on the element using JavaScript executor.(hidden elements)
	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	//Common method to perform double-click on the element.
	public void doubleClick(WebElement element) {
		scrollToElement(element);
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	//Common method to perform right-click on element.
	public void rightClick(WebElement element) {
		scrollToElement(element);
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	//Common method to hover on the element.
	public void hoverOnElement(WebElement element) {
		scrollToElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	//Common method to enter text in the text field.
	public void enterText(WebElement element, String text) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(text);
	}
	
	//Common method to select the checkbox.
	public void selectCheckbox(WebElement checkbox, boolean status) {
		scrollToElement(checkbox);
		if(checkbox.isSelected() !=status) {
			checkbox.click();
		}
	}
	
	// Common method to Select the option from drop-down.
	public void selectDropdownOption(WebElement dropdown, String option, String selectBy) {
		scrollToElement(dropdown);
		Select select = new Select(dropdown);
		switch (selectBy.toLowerCase()) {
		case "visibletext":
			select.selectByVisibleText(option);
			break;
		case "value":
			select.selectByValue(option);
			break;
		case "index":
			select.selectByIndex(Integer.parseInt(option));
			break;
		default:
			Assert.fail("Invalid selection criteria provided: " + selectBy);
		}
	}
	
	//Common method to get the text of the element.
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	//Common method to get the attribute value of the element.
	public String getElementAttribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	//Common method to get the current URL from the web page.
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	//Common method to refresh the page.
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	//Common method to navigate to a specific URL.
	public void navigateToURL(String url) {
		driver.navigate().to(url);
	}
	
	//Common method to verify element display status.
	public boolean isElementDisplayed(WebElement element) {
		try {
			scrollToElement(element);
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	//Common method to verify element enabled status.
	public boolean isElementEnabled(WebElement element) {
		try {
			scrollToElement(element);
			return element.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}
	
	//Common method to get the window handle ID.
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}
	
	// Method to capture screenshot of browser window
	public static String getWindowScreenshot(WebDriver driver, String fileName) throws IOException {
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(destination));
		return destination;
	}

	// Method to capture screenshot of webelement
	public static String getElementScreenshot(WebElement element, String fileName) throws IOException {
		String destination = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(destination));
		return destination;
	}
	
	// Common method to wait by using Java wait.
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Common Method to wait by using Implicit wait
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Web.IMPLICIT_WAIT));
	}
	
	// Common Method to wait by using Explicit wait
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Web.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Common Method to wait by using Explicit wait
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Web.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	// Common Method to wait until element is disappeared
	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Web.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	// Common Method to wait until element is clickable
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Web.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	// Common Method to handle alert pop-up
	public void handleAlert(boolean accept) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Web.EXPLICIT_WAIT));
			wait.until(ExpectedConditions.alertIsPresent());
			if(accept) {
				driver.switchTo().alert().accept();
			} else {
				driver.switchTo().alert().dismiss();
			}
		} catch (Exception e) {
			Assert.fail("No alert is present to handle.");
		}
	}
	
	// Common method to switch to frame.
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// Common method to switch to frame.
	public void switchToFrame(String frameNameOrId) {
		driver.switchTo().frame(frameNameOrId);
	}
	
	// Common method to switch back to main window from frame.
	public void switchToMainWindow() {
		driver.switchTo().defaultContent();
	}
	
	// Common method to print message in extent reports
	public void log(String status, String message) {
		if(status.equalsIgnoreCase("info")) {
			Reports.logger.info(message);
		} else if(status.equalsIgnoreCase("pass")) {
			Reports.logger.pass(message);
		} else if(status.equalsIgnoreCase("fail")) {
			Reports.logger.fail(message);
		} else if(status.equalsIgnoreCase("warning")) {
			Reports.logger.warning(message);
		} else {
			Reports.logger.info(message);
		}
	}

}
