package com.iNetBanking.TestCases;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.iNetBanking.pageObject.LoginPage;
import com.iNetBanking.utility.ExtentReporting;
import com.iNetBanking.utility.UtilitySelenium;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TC_loginPage_001 extends UtilitySelenium {

	WebDriver driver=null;
	LoginPage login=null;
	//Logger logger; //eerror deto haa ttyala tikdech public static banvvav lagel
	
	ExtentReporting er=new ExtentReporting();
	ExtentReports report=er.instanceofExtentReport();

	ExtentTest test;
	
	@BeforeTest
	public void openBrower(){
		driver=setUp("chrome", "https://demo.guru99.com/V1/index.php");
		login=new LoginPage(driver);
	}

	@Test
	public void login() throws IOException
	{
		login.enteruid(username); 
		logger.info("Username is entered...!");
		//username ki value utilityselenium se aa rahein hai 
		//jiske liye readconfig file banayain jisme value 
		//property file se load ho rahein hai
		
		login.enterpwd("unynuhA");
		logger.info("password is entered...!");
		login.clickbtn();
		
		test=report.startTest("eBanking")
				.assignAuthor("shailesh Kumar")
				.assignCategory("smoke test");

		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			test.log(LogStatus.PASS, test.addScreenCapture(screenShot (driver)),"title is validated");
			logger.info("title is passed");
		}
		else
		{
			Assert.assertTrue(false);
		//	test.log(LogStatus.FAIL, test.addScreenCapture(screenShot (driver)),"title is not validated");
		//	test.log(LogStatus.FAIL, test.addScreenCapture(screenShot (driver)),);
			logger.info("title is not passed");
		}
	}

	@AfterMethod
	public void logout() throws InterruptedException
	{
		Thread.sleep(1200);
		report.flush();
		driver.close();
		//logger.info("browser is closed");
	}

}
