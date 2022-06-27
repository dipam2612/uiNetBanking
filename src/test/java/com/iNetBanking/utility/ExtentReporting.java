package com.iNetBanking.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;


public class ExtentReporting {

	ExtentReports report;
	
	
	public ExtentReports instanceofExtentReport()
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
				.format(new Date());
		
		String rName="testReport_"+timestamp+".html" ;
		
		report=new ExtentReports(".//extentReport//"+rName);
		
		report
		.addSystemInfo("UserName", "dipam")
		.addSystemInfo("Host Name", "pavan");
		
		return report;
	}
	
}
