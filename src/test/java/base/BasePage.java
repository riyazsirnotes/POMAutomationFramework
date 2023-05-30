package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extentreports.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	

	public static WebDriver driver;
	public FileInputStream fis1;
	public static Properties configProp;
	public FileInputStream fis2;
	public static Properties locatorsProp;
	
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@AfterTest
	public void exitTest(ITestContext context)
	{
		//reports=(ExtentReports)context.getAttribute("report");
		
		if(reports!=null)
		{
			reports.flush();
		}
	}
	
	@BeforeTest
	public void fileSetUp(ITestContext context) throws IOException, InterruptedException
	{
		fis1= new FileInputStream("Properties\\config.properties");
		
		configProp=new Properties();
		
		configProp.load(fis1);
		
		reports=ExtentManager.getReports();
		
		test=reports.createTest(context.getCurrentXmlTest().getName());
		
		context.setAttribute("report", "reports");
		
		context.setAttribute("test", "test");
						
	}
	
	@BeforeMethod
	public void setUp()
	{
		
		
		
		  String browserName=configProp.getProperty("browser");
		  
		  if(browserName.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup();
		  
		  driver=new ChromeDriver(); } else if(browserName.equalsIgnoreCase("firefox"))
		  { WebDriverManager.firefoxdriver().setup();
		  
		  driver=new FirefoxDriver(); } else if(browserName.equalsIgnoreCase("edge")) {
		  WebDriverManager.edgedriver().setup();
		  
		  driver=new EdgeDriver(); }
		  
		  driver.get(configProp.getProperty("url"));
		  
		  driver.manage().window().maximize();
		  
		  driver.manage().timeouts().implicitlyWait(Long.parseLong(configProp.
		  getProperty("implicitWaitTime")), TimeUnit.SECONDS);
		 
		 
	}
	
	@AfterMethod
	public void teardown()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.quit();
		
	}
	

}
