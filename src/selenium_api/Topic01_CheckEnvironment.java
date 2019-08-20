package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Topic01_CheckEnvironment {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		System.out.println("Run Pre-condition - Step 01: Init Chrome Browser");
		System.setProperty("webdriver.chrome.driver", ".\\library\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Run Pre-condition - Step 02: Wait for page loading success");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Run Pre-condition - Step 03: Open Google url");
		driver.get("https://www.google.com/");
		
	}

	@Test
	public void TC_01_Check_Homepage_Url() {
		System.out.println("TC_01 - Step 01: Get current URL");
		String homePageUrl = driver.getCurrentUrl();
		System.out.println("TC_01 - Step 02: Verify expected url matching vs actual url");
		Assert.assertEquals(homePageUrl, "https://www.google.com/");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Run Post-condition");
		driver.quit();
		
	}

}
