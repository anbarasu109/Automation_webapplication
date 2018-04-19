package automation.webapp.jenkins;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	FirefoxBinary firefoxBinary;
	FirefoxOptions firefoxOptions;
	FirefoxDriver driver;

    @Test
	public void testApp()
    {
    	try {
    	driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 	
		System.out.print(title);
		String domainName = (String) driver.executeScript("return document.domain");
		System.out.println(domainName);
    	} finally {
    		driver.quit();
    	}
    }
    @BeforeTest
	public void beforeTest() {	
    	firefoxBinary = new FirefoxBinary();
    	firefoxBinary.addCommandLineOptions("--headless");
    	System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.20.1/bin/geckodriver");
    	firefoxOptions = new FirefoxOptions();
    	firefoxOptions.setBinary(firefoxBinary);
    	driver = new FirefoxDriver(firefoxOptions);
	}			
}

