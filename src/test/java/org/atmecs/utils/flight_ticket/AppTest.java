package org.atmecs.utils.flight_ticket;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.atmecs.utils.constants.Filepath;
import org.atmecs.utils.helper.Help;
import org.atmecs.utils.testbase.Presetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends Presetup {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 * @throws IOException
	 */
	// App app = new App();

	/*
	 * @DataProvider(name = "data") public String[][] getdata() throws IOException {
	 * String array[][] = null; array = app.returnLocator(Filepath.input_file);
	 * return array; }
	 */
	Help help = new Help();

	@Test(priority = 0)
	public void flightticket() throws IOException, InterruptedException {

		Properties prop = property(Filepath.config_file);
		Properties prop1 = property(Filepath.locator_file);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(prop1.getProperty("loc.radiobtn.rtrip.xpath"))));
		driver = help.click(prop1.getProperty("loc.radiobtn.rtrip.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.dropdown.from.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.options.from.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.dropdown.to.xpath"), driver);
		driver = help.sendkeysString(prop1.getProperty("loc.dropdown.to.xpath"), driver, "chennai");
		driver = help.click(prop1.getProperty("loc.options.to.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.date.depart.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.day.depart.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.date.return.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.day.return.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.dropdown.passenger.xpath"), driver);
		int initial = 0;
		while (initial < 4) {
			driver = help.click(prop1.getProperty("loc.btn.passup.xpath"), driver);
			initial++;
		}
		WebElement btn = driver.findElement(By.xpath(prop1.getProperty("loc.btn.passcountdone.xpath")));
		js.executeScript("arguments[0].click();", btn);
		driver = help.click(prop1.getProperty("loc.dropdown.currencyrupee.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.dropdown.currencydollar.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.radiobtn.family.xpath"), driver);
		driver = help.click(prop1.getProperty("loc.submitbtn.searchflight"), driver);

	}

	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void testApp() {

		AssertJUnit.assertTrue(true);
	}
}
