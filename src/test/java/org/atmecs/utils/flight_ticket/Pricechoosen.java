package org.atmecs.utils.flight_ticket;

import java.io.IOException;
import java.util.Properties;

import org.atmecs.utils.constants.Filepath;
import org.atmecs.utils.helper.Help;
import org.atmecs.utils.testbase.Presetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Pricechoosen extends Presetup {
	Help help = new Help();

	@Test(priority = 1)
	public void price() throws IOException {
		Properties prop = property(Filepath.next_file);
		driver.switchTo().frame("destination_publishing_iframe_indigoaviation_0");
		WebElement btn1 = driver.findElement(By.xpath(prop.getProperty("loc.btn.t&c.xpath")));
		btn1.click();

		driver.close();

	}

}
