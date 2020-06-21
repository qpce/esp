package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import resources.base;

public class HomePage extends base {

	@Test

	public void basePageNavigation() throws IOException {

		driver = getBrowser();
		String actual = "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy";
		driver.get("http://qaclickacademy.com");
		String expected = driver.getTitle();
		Assert.assertEquals(actual,expected);
	}
}
