package extentreports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BasePage;

public class ExtentManager extends BasePage {
	
	static String reportsFolderPath ;
	
	public static  ExtentReports getReports()
	{
		
		reportsFolderPath=System.getProperty("user.dir")+"\\reports";
		
		if(reports==null)
		{
		
			reports=new ExtentReports();
			
			File reportsFolder=new File(reportsFolderPath);
			
			reportsFolder.mkdir();
			
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String date = simpleDateFormat.format(new Date());
			System.out.println(date);
			
			date=date.replace(":", "-");
			
			System.out.println(date);
			
			String FilePath=reportsFolder+"\\"+date+".html";
			
			//File reportFile=new File(FilePath);
			
			ExtentSparkReporter reporter=new ExtentSparkReporter(FilePath);
			
			reporter.config().setDocumentTitle("Adactin QA Regression Results");
			
			reporter.config().setReportName("Regresion Reports");
			
			reporter.config().setTheme(Theme.DARK);
					
			reports.attachReporter(reporter);
			
		}
		
		return reports;
	}

}
