package com.iNetBanking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File source = new File("./configuration/readconfiguration.properties");

		try {
			FileInputStream fis = new FileInputStream(source);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getUsername() {
		String username=pro.getProperty("username");
		return username;
	}
}
