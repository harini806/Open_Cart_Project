package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	//constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmailAdderss;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPasssword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	//Action methods
	public void setEmail(String email)
	{
		txtEmailAdderss.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPasssword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
}
