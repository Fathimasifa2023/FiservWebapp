package com.qa.webapp.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import com.qa.webapp.factory.DriverFactory;
import com.qa.webapp.pages.HomePage;
import com.qa.webapp.pages.SearchResultsPage;

public class BaseTest {

	public DriverFactory df;
	public Properties prop;
	public WebDriver driver;
	public HomePage homePage;	
	public SearchResultsPage searchResultsPage;
	public SoftAssert softAssert;
	

	@Parameters({ "browser", "browserversion" })
	@BeforeTest
	public void setup(String browser, String browserVersion) {
		df = new DriverFactory();
		prop = df.init_prop();

		
		if (browser != null) {
			prop.setProperty("browser", browser);
			prop.setProperty("browserversion", browserVersion);
		}

		driver = df.init_driver(prop);
		homePage = new HomePage(driver);
		
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
