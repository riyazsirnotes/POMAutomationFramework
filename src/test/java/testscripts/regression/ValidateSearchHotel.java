package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;
import pages.SearchHotelPage;

public class ValidateSearchHotel extends BasePage {
	
	
	@Test
	public void ValidateSearchHotelTest()
	{
		
		
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		
		lp.usernameTextbox("reyaz0617");
		
		lp.passwordTextbox("reyaz123");
		
		lp.loginButton();
		
		Assert.assertEquals(lp.getTitle(), "Adactin.com - Search Hotel");
		
		SearchHotelPage searchHotelPage=PageFactory.initElements(driver, SearchHotelPage.class);
		
		
		searchHotelPage.locationDropdown("Sydney");
		
		searchHotelPage.hotelsDropdown("Hotel Creek");
		
		searchHotelPage.roomTypeDropdown("Standard");
		
		searchHotelPage.noOfRoomsDropdown("1 - One");
		
		searchHotelPage.checkInDateTextBox("24/05/2023");
		
		searchHotelPage.checkOutDateTextBox("25/05/2023");
		
		searchHotelPage.adultsPerRoomDropdown("2 - Two");
		
		searchHotelPage.searchButton();
		
		Assert.assertEquals(searchHotelPage.getTitle(), "Adactin.com - Select Hotel");
		
		
		
		
		
		
		
		
		
		
	}

}
