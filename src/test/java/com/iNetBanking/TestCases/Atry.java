package com.iNetBanking.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Atry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
		driver.manage().deleteAllCookies();
		driver.findElement(By.name("uid")).sendKeys("mngr418630");
		driver.findElement(By.name("password")).sendKeys("unynuhA");
		driver.findElement(By.name("btnLogin")).click();
		
		driver.findElement(By.linkText("New Customer")).click();
		driver.navigate().back();
		driver.findElement(By.linkText("New Customer")).click();
		//WebElement dc=driver.findElement(By.xpath("//div[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0__container__']/iframe"));
	//	WebElement dc=driver.findElement(By.xpath("//body"));
	//	Actions act=new Actions(driver);
	//	act.doubleClick(dc);
		
	}

}
