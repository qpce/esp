package Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;

public class HomePage extends base {

	@BeforeTest

	public void homePageTest() throws IOException {

		driver = getBrowser();
		driver.get("http://qaclickacademy.com");
	}
	
	@Test

	public void homePageTitleTest() throws IOException {

		String actual = "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy";
		String expected = driver.getTitle();
		Assert.assertEquals(actual,expected);
	}
}
