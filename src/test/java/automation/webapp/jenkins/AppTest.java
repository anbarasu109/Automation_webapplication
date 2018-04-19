package automation.webapp.jenkins;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	HtmlUnitDriver driver;

    @Test
	public void testApp()
    {
    	driver.get("http://demo.guru99.com/test/guru99home/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 	
		String domainName = (String) driver.executeScript("return document.domain");
    }
    @BeforeTest
	public void beforeTest() {	
    
    	driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_11);
    	driver.setJavascriptEnabled(true);
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}	
}
