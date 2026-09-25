package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	 
	//constructor
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

	//locators
	@FindBy(xpath = "//div[@id='content']//h2[text()='My Account']") //MyAccount page heading )
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	//Action methods
	//assertion cannot be written in page object class
	
	public boolean isMyAccountPageExists() //Not a validation method it just verify
	{
		try
		{
			return (msgHeading.isDisplayed());

		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
