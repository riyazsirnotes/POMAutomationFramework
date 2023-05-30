package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class LoginPage extends Page{
	
	//WebElement usernameTextbox=driver.findElements(By.xpath("//input[@name='username']"));
	
	
	@FindBy(xpath="//input[@name='username']") 
	WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']") 
	WebElement passwordTextbox;
	
	
	@FindBy(xpath="//input[@name='login']") 
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='New User Register Here']") 
	WebElement registerLink;
	
	public void usernameTextbox(String text)
	{
		usernameTextbox.sendKeys(text);
		test.log(Status.INFO, "Entered text"+text+" in usernameTextbox");
		
	}
	
	public void passwordTextbox(String text)
	{
		passwordTextbox.sendKeys(text);
		test.log(Status.INFO, "Entered text"+text+" in passwordTextbox");
	}
	
	public void loginButton()
	{
		loginButton.click();
		
		test.log(Status.INFO, "Clicked Button loginButton");
	}
	

}
