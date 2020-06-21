package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public WebDriver driver;

	public WebDriver getBrowser() throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream("C:\\ide-ws\\esp\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		System.out.println("getScreenShotPath "+ testCaseName + "  " + driver);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		String destFile = System.getProperty("C:\\ide-ws\\esp\\reports\\" + testCaseName + ".png");
		FileUtils.copyFile(source, new File(destFile));
		System.out.println(destFile);
		System.out.println("getScreenShotPath "+ testCaseName + "  " + driver);
		return destFile;
	}
}
