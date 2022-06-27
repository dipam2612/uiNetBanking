package com.iNetBanking.TestCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.iNetBanking.utility.SeleniumUtility;

public class Login_tc extends SeleniumUtility{

	WebDriver driver;
	SeleniumUtility su=new SeleniumUtility();
	
	@Test
	public void m()
	{
		driver=su.setUp("chrome", "https://demo.guru99.com/V1/index.php");
		
		driver.findElement(By.name("uid")).sendKeys("mngr418630");
		driver.findElement(By.name("password")).sendKeys("unynuhA");
		driver.findElement(By.name("btnLogin")).click();
		
	}
	
	@Test
	public void n() throws InterruptedException
	{
		driver.findElement(By.linkText("New Customer")).click();
		Thread.sleep(300);//div#ad_position_box//#dismiss-button
		driver.navigate().back();
		driver.findElement(By.linkText("New Customer")).click();
				
		//	driver.findElement(By.xpath("//body")).click();
		//WebElement iframe=driver.findElement(By.id("ad_iframe"));
		//driver.switchTo().frame(iframe);
		//driver.findElement(By.cssSelector("#dismiss-button")).click();
		//driver.switchTo().defaultContent();
		Thread.sleep(300);
		
		
		driver.findElement(By.name("name")).sendKeys("abc");
		driver.findElement(By.name("rad1")).click();
	//	driver.findElement(By.name("dob")).click();
		driver.findElement(By.name("addr")).sendKeys("address");
		driver.findElement(By.name("city")).sendKeys("city");
		driver.findElement(By.name("state")).sendKeys("state");
		driver.findElement(By.name("pinno")).sendKeys("123456");
		driver.findElement(By.name("telephoneno")).sendKeys("1234567890");
		
		WebElement email=driver.findElement(By.name("emailid"));
		String emailpath=rString()+"@gmail.com";
		email.sendKeys(emailpath);
	
	}
	
	public String rString()
	{
		String ralphabet= RandomStringUtils.randomAlphabetic(8);
		return ralphabet;
	}
	
}
