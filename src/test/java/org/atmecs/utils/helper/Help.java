package org.atmecs.utils.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Help {
	public WebDriver click(String locators, WebDriver webdriver) {
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement click_operation = webdriver.findElement(By.xpath(locators));
		click_operation.click();
		return webdriver;
	}

	public WebDriver sendkeysString(String locators, WebDriver webdriver, String variable) {
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement click_operation = webdriver.findElement(By.xpath(locators));
		click_operation.sendKeys(variable);
		return webdriver;
	}

	public WebDriver sendkeysInt(String locators, WebDriver webdriver, String variable) {
		WebElement click_operation = webdriver.findElement(By.xpath(locators));
		click_operation.sendKeys(variable);
		return webdriver;
	}

	public WebDriver dropdown(String locators, WebDriver webdriver, int index) {
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement dropdown = webdriver.findElement(By.xpath(locators));
		Select select = new Select(dropdown);
		select.selectByIndex(index);
		return webdriver;
	}

	public boolean returnbool(String locators, WebDriver webdriver) {
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement bool = webdriver.findElement(By.xpath(locators));
		boolean boo = bool.isSelected();
		return boo;
	}

	public WebDriver sendkeysdropdown(String locators, WebDriver webdriver, String variable)
			throws InterruptedException {
		WebElement dropdown = webdriver.findElement(By.xpath(locators));
		dropdown.sendKeys(variable);
		Thread.sleep(2000);
		WebElement options = webdriver.findElement(By.xpath(locators));
		options.sendKeys(Keys.ENTER);
		return webdriver;

	}
}
