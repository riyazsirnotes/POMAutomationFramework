package testscripts.regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://imgur.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void fileUploadTest()
	{
		
		driver.findElement(By.xpath("//a[@class='Button upload']")).click();
		
		driver.findElement(By.xpath("//label[text()='Choose Photo/Video']/img")).click();
		
		
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		
	}

}
