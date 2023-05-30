package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidateSearchHotelUsingDataProvider extends BasePage {
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][1];
		
		data[0][0]	 =	 UtilKit.getTestData("TC-102");
		
		return data;
		
	}
	
	@Test(dataProvider = "getData")
	public void ValidateSearchHotelTest(HashMap<String, String> hMap)
	{
		
		
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		
		lp.usernameTextbox(hMap.get("Username"));
		
		lp.passwordTextbox(hMap.get("Password"));
		
		lp.loginButton();
		
		Assert.assertEquals(lp.getTitle(),hMap.get("Expected Title1") );
		
		SearchHotelPage searchHotelPage=PageFactory.initElements(driver, SearchHotelPage.class);
		
		
		searchHotelPage.locationDropdown(hMap.get("Location"));
		
		searchHotelPage.hotelsDropdown(hMap.get("Hotels "));
		
		searchHotelPage.roomTypeDropdown(hMap.get("Room Type"));
		
		searchHotelPage.noOfRoomsDropdown(hMap.get("Number of Rooms"));
		
		searchHotelPage.checkInDateTextBox(hMap.get("Check In Date"));
		
		searchHotelPage.checkOutDateTextBox(hMap.get("Check Out Date"));
		
		searchHotelPage.adultsPerRoomDropdown(hMap.get("Adults per Room"));
		
		searchHotelPage.searchButton();
		
		Assert.assertEquals(searchHotelPage.getTitle(), hMap.get("Expected Title2"));
		
				
	}

}
