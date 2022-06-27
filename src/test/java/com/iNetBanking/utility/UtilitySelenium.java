package com.iNetBanking.utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilitySelenium {
	public WebDriver driver;
	public static Logger logger;
	
	ReadConfig rc=new ReadConfig();
	public String username = rc.getUsername();
	
	public WebDriver setUp(String browserName, String appUrl) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		logger= Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		driver.get(appUrl);
		logger.info("Url is Opened");
		return driver;
	}
	
	public static String screenShot(WebDriver driver) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Destn = new File(".//screenShot/" + System.currentTimeMillis()+ ".png");
		FileUtils.copyFile(source, Destn);
		return Destn.getAbsolutePath();
		}
	
}
