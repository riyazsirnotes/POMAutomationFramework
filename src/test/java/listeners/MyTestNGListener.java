package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BasePage;

public class MyTestNGListener extends BasePage implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		
		String testName=result.getMethod().getMethodName();
		
		String screenShotFolderpath=System.getProperty("user.dir")+"\\screenshots";
		
		File screenShotFolder=new File(screenShotFolderpath);
		
		screenShotFolder.mkdir();
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		
		date=date.replace(":", "-");
		
		System.out.println(date);
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File(screenShotFolderpath+"\\"+testName+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenShotFolderpath+"\\"+testName+date+".png");
		test.log(Status.FAIL, testName+" is Failed");
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

	
	

}
