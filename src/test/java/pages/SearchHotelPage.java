package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage extends Page {
	
	
	@FindBy(xpath="//select[@name='location']")
	WebElement locationDropdown;
	
	@FindBy(xpath="//select[@name='hotels']")
	WebElement hotelsDropdown;
	
	@FindBy(xpath="//select[@name='room_type']")
	WebElement roomTypeDropdown;
	
	@FindBy(xpath="//select[@name='room_nos']")
	WebElement noOfRoomsDropdown;
	
	@FindBy(xpath="//input[@name='datepick_in']")
	WebElement checkInDateTextBox;
	
	@FindBy(xpath="//input[@name='datepick_out']")
	WebElement checkOutDateTextBox;
	
	@FindBy(xpath="//select[@name='adult_room']")
	WebElement adultsPerRoomDropdown;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement searchButton;
	
	public void locationDropdown(String option)
	{
		new Select(locationDropdown).selectByVisibleText(option);
	}
	
	
	
	public void hotelsDropdown(String option)
	{
		new Select(hotelsDropdown).selectByVisibleText(option);
	}
	
	public void roomTypeDropdown(String option)
	{
		new Select(roomTypeDropdown).selectByVisibleText(option);
	}
	
	public void noOfRoomsDropdown(String option)
	{
		new Select(noOfRoomsDropdown).selectByVisibleText(option);
	}
	
	public void adultsPerRoomDropdown(String option)
	{
		new Select(adultsPerRoomDropdown).selectByVisibleText(option);
	}
	
	public void checkInDateTextBox(String text)
	{
		checkInDateTextBox.clear();
		checkInDateTextBox.sendKeys(text);
	}
	
	public void checkOutDateTextBox(String text)
	{
		checkOutDateTextBox.clear();
		checkOutDateTextBox.sendKeys(text);
	}

	public void searchButton()
	{
		searchButton.click();
	}
	
	
}
