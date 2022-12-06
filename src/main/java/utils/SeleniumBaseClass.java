package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class SeleniumBaseClass {

	public WebDriver driver;
	public Properties prop;

	@BeforeClass
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//resources//selenium.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + prop.getProperty("chromedriverpath"));
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefoxparth")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + prop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + prop.getProperty("iepath"));
			driver = new EdgeDriver();

		}

		driver.get(prop.getProperty("url"));

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		AssertJUnit.assertEquals(driver.getTitle(), "jQuery UI");

		return driver;
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
