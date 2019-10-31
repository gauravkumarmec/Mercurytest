package com.mercury.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mercury.qa.Util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		 prop=new Properties();
		 try {
			FileInputStream jp=new FileInputStream("D:\\work\\FreeMercuryTest\\src\\main\\java\\com\\mercury\\qa\\Config\\config.Properties");
			try {
				prop.load(jp);
				}
			catch (IOException e) {
				e.printStackTrace();}
		} 
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\FF driver\\chromedriver.exe");
		driver=new ChromeDriver();
		}else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","D:\\FF driver\\gecko.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}
