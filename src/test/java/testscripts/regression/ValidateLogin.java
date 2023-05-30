package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;

public class ValidateLogin extends BasePage{
	
	
	@Test
	public void validateLoginTest()
	{
		
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		
		lp.usernameTextbox("reyaz0617");
		
		lp.passwordTextbox("reyaz123");
		
		lp.loginButton();
		
	}

}
