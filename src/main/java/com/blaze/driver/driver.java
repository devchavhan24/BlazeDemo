package com.blaze.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class driver {	
	 public static WebDriver driver;
	@BeforeTest
	public static void getDriver()
	{
		if(Objects.isNull(driver)) {
			
		switch("chrome") 
		{
		case "chrome":
			 System.setProperty("webdriver.chrome.driver", "D:\\BrowserD\\chromedriver-win64\\chromedriver.exe");
			 driver =new ChromeDriver();
			 driver.navigate().to("https://blazedemo.com/index.php");  
			 break;
			 
		 case "Edge":
             System.setProperty("webdriver.edge.driver", "D:\\BrowserD\\edgedriver_win64\\edgedriver.exe");
             driver = new EdgeDriver();
             driver.navigate().to("https://blazedemo.com/index.php");
             break;
		}
		
	   
		}
		
		
	}
	@AfterTest
	public void quitdriver() {
		if(Objects.nonNull(driver)) {
			driver.quit();
		}
	}
	
}
